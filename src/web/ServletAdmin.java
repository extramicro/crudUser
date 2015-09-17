package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dao.UserDaoImpl;
import model.User;

/**
 * Servlet implementation class ServletAdmin
 */
@WebServlet(name = "ServletAdmin", urlPatterns = { "/UserController" }, description = "first Servlet")
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO userDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAdmin() {
		super();
		userDAO = new UserDaoImpl();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String page = null;

		if (action.equalsIgnoreCase("update")) {
			page = "/update.jsp";
		}

		else if (action.equalsIgnoreCase("delete")) {
			String id = request.getParameter("id");
			int idDelete = Integer.parseInt(id);
			userDAO.deleteUser(idDelete);
			request.setAttribute("users", userDAO.getAllUsers());
			page = "/home.jsp";

		} else {
			page = "/home.jsp";
		}

		request.getRequestDispatcher(page).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("txtNome");
		String senha = request.getParameter("txtSenha");
		String action = request.getParameter("action");
		String page = null;
		User user = new User();
		String id = request.getParameter("id");
		int idd;

		boolean ok = userDAO.checkUser(nome, senha);

		if (action.equalsIgnoreCase("isUpdated")) {

			idd = Integer.parseInt(id);
			user.setId(idd);
			user.setNome(nome);
			user.setSenha(senha);
			userDAO.updateUser(user);
			request.setAttribute("users", userDAO.getAllUsers());
			page = "/home.jsp";

		} else if (action.equalsIgnoreCase("isChecked")) {

			if (ok) {
				request.setAttribute("users", userDAO.getAllUsers());
				page = "/home.jsp";
			} else {
				page = "/failed.jsp";
			}

		}

		else if (action.equalsIgnoreCase("isInserted")) {
			
			user.setNome(nome);
			user.setSenha(senha);
			userDAO.insertUser(user);
			request.setAttribute("users", userDAO.getAllUsers());
			page = "/home.jsp";

		}

		else {

			page = "/failed.jsp";

		}

		request.getRequestDispatcher(page).forward(request, response);

	}

}
