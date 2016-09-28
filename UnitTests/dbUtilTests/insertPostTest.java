package dbUtilTests;
import static org.junit.Assert.*;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import org.junit.Test;
import customTools.DBUtil;
import customTools.DbBullhorn;
import model.Bhuser;


public class insertPostTest {

	@Test
	public void test() {
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
