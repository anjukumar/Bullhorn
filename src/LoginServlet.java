

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DbBullhorn;
import customTools.DbUser;
import model.Bhpost;
import model.Bhuser;
import userPack.User;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		String useremail = request.getParameter("username");
		String password = request.getParameter("password");

//		user.setUsername(username);
//		user.setPassword(password);

		String nextURL ="/error.jsp";
		
		Bhuser user=null;
		List<Bhpost> posts = null;		
		HttpSession session = request.getSession();
		
		if(DbUser.isValidUser(useremail,password))
		{
			user = DbUser.getUserByEmail(useremail);
			session.setAttribute("User", user);
			nextURL="/Home.jsp";
			posts = DbBullhorn.bhPost();
			session.setAttribute("posts", posts);
			 
		}
		else
		{
			response.getWriter().append("Invalid id/password try again.");
			nextURL="/LoginPage.html";
		}
		response.sendRedirect(request.getContextPath()+nextURL);
	
	}

}
