package generalservices;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import database.DBOperation;
import database.DBTableUser;
import model.User;
import services.BasicService;

public class LoginService {

	private User user;

	public boolean checkUsernameAndPass(SessionFactory factory, String username, String pass) {
		DBTableUser dbOperation = new DBTableUser();

		 user = dbOperation.checkUserAndPass(factory, username, pass);

		if (user == null)
			return false;

		return true;

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
