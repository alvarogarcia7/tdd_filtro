package filtro;


public class SearchEngine {
	
	private StubUserRepository userRepository;
	public SearchEngine(Filter filter, StubUserRepository userRepository){
		this.userRepository = userRepository;
	}
	public Object find(String string) {
		return userRepository.getUsers();
	}
	
}
