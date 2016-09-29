

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SupportServlet
 */
@WebServlet("/SupportServlet")
public class SupportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupportServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");	
		System.out.println("em: " + email);
		request.setAttribute("emailConfirmation","Your email address is: " + email);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String email = request.getParameter("email");
		String nextURL ="/support.jsp";

		if(email.length()!=0)
		{
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			System.out.println("emm: " + email);
			response.getWriter().append(email);
			nextURL ="/confirm.jsp?email="+email;
			request.setAttribute("email" , email);
		}
		response.sendRedirect(request.getContextPath()+nextURL);


	}

}
