

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DbUser;
import model.Bhuser;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String updatename = request.getParameter("username");
		String updatepassword = request.getParameter("password");
		String updateemail = request.getParameter("useremail");
		String updatemotto = request.getParameter("motto");
		Date updatedate = new Date();
		
		
		HttpSession session = request.getSession();
		model.Bhuser updates = (model.Bhuser) session.getAttribute("User");
		
		
		updates.setUsername(updatename);
		updates.setUserpassword(updatepassword);
		updates.setUseremail(updateemail);
		updates.setMotto(updatemotto);
		updates.setJoindate(updatedate);
		
		
		System.out.println("Updating details");
		DbUser.update(updates);
		String nextURL="/profile.jsp";
		response.sendRedirect(request.getContextPath()+nextURL);
		
	}

}
