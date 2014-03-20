import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import filtro.FilterFactory;
import filtro.SearchEngine;
import filtro.StubUserRepository;
import filtro.User;


public class SearchEngineTest {

	@Test
	public void when_language_ES_input_single_word_returns_list_of_user() {
		FilterFactory filterFactory = new FilterFactory();
		StubUserRepository userRepository = new StubUserRepository();
		userRepository.setUsers(new ArrayList<User>());
		SearchEngine searchEngine = new SearchEngine(filterFactory.createSpanishFilter(), userRepository);
		assertEquals(new ArrayList<User>(), searchEngine.find("FONTANERO"));
	}

	@Test
	public void when_language_ES_and_searching_by_a_keyword_returns_matching_users() {
		FilterFactory filterFactory = new FilterFactory();
		User firstUser = new User();
		firstUser.setName("James");
		firstUser.setProfession("FONTANERO");
		User secondUser = new User();
		secondUser.setName("David");
		secondUser.setProfession("FONTANERO");
		List<User> users = new ArrayList<User>();
		users.add(firstUser);
		users.add(secondUser);

		StubUserRepository stubUserRepository = new StubUserRepository();
		stubUserRepository.setUsers(users);
		SearchEngine searchEngine = new SearchEngine(filterFactory.createSpanishFilter(), stubUserRepository);
		assertEquals(users, searchEngine.find("FONTANERO"));
	}
	
}
