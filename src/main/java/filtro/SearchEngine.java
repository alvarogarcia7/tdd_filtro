package filtro;


public class SearchEngine {
	
	private UserRepository userRepository;
	public SearchEngine(Filter filter, UserRepository userRepository){
		this.userRepository = userRepository;
	}
	public Users find(String string) {
		return userRepository.getUsers();
	}
	
}
