

import java.io.IOException;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customTools.DBUtil;
import customTools.DbBullhorn;
import model.Bhuser;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
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
		Date postdate = new Date();
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String query ="select u from Bhuser u where u.useremail=:email";
		TypedQuery<Bhuser> q =em.createQuery(query,Bhuser.class);
		q.setParameter("email","anju@domain.com");
		
		Bhuser bhUser = null;
		try {
			bhUser = q.getSingleResult();
			System.out.println("The user id is :" +bhUser.getBhuserid());
		}
		catch (NoResultException e){
			System.out.println(e);
		}
		catch (NonUniqueResultException e){
			System.out.println(e);
		}
		finally{
			em.close();
		}
	 System.out.println("inserting into post table.");
	 model.Bhpost bhPost = new model.Bhpost();
	 bhPost.setBhuser(bhUser);
	 bhPost.setPostdate(postdate);
	 bhPost.setPosttext("This is a unit test post");
	 
	 System.out.println("calling DbBullhorn.insert");
	 DbBullhorn.insert(bhPost);
	}
}
