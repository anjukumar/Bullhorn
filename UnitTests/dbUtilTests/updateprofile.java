package dbUtilTests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import customTools.DbUser;

public class updateprofile {

	@Test
	public void test() {
		model.Bhuser user = new model.Bhuser();
		user.setBhuserid(5);
		user.setUseremail("anju@domain.com");
		user.setUserpassword("anju");
		user.setUsername("AK");
		user.setMotto("Life");
		user.setJoindate(new Date());
		DbUser.update(user);
	}

}
