package filtro;


public class StubUserRepository implements UserRepository{

	private Users users = new Users();

	public void setUsers(Users users) {
		this.users = users;
	}
	
	public Users getUsers(){
		return users;
	}
 
}
