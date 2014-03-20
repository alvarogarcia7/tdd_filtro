package filtro;

import java.util.ArrayList;

public class Users extends ArrayList<User>{
	private static final long serialVersionUID = 1L;

	public void addUser(String name, String profession) {
		User user = new User();
		user.setName(name);
		user.setProfession(profession);
		this.add(user);
	}
}
