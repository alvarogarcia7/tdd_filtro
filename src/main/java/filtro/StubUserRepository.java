package filtro;

import java.util.List;

public class StubUserRepository {

	private Users users = new Users();

	public void setUsers(List<User> users) {
		this.users.clear();
		this.users.addAll(users);
	}
	
	public Users getUsers(){
		return users;
	}
 
}
