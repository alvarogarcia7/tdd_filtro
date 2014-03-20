package filtro;

import java.util.ArrayList;

public class SearchEngine {
	
	private Filter filter;
	private StubUserRepository userRepository;
	public SearchEngine(Filter filter, StubUserRepository userRepository){
		this.filter = filter;
		this.userRepository = userRepository;
	}
	public Object find(String string) {
		return userRepository.getUsers();
	}
	
}
