import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import filtro.Filter;
import filtro.FilterFactory;
import filtro.SearchEngine;
import filtro.StubUserRepository;
import filtro.User;
import filtro.Users;


public class SearchEngineTest {

	private Filter spanishFilter;
	private StubUserRepository userRepository;

	@Before
	public void setUp(){
		FilterFactory filterFactory = new FilterFactory();
		spanishFilter = filterFactory.createSpanishFilter();

		userRepository = new StubUserRepository();
		userRepository.setUsers(new ArrayList<User>());
	}
	
	@Test
	public void when_language_ES_input_single_word_returns_list_of_user() {
		SearchEngine searchEngine = new SearchEngine(spanishFilter, userRepository);
		assertEquals(new ArrayList<User>(), searchEngine.find("FONTANERO"));
	}

	@Test
	public void when_language_ES_and_searching_by_a_keyword_returns_matching_users() {
		Users users = new Users();
		users.addUser("James", "FONTANERO");
		users.addUser("David", "FONTANERO");
		userRepository.setUsers(users);

		SearchEngine searchEngine = new SearchEngine(spanishFilter, userRepository);
		assertEquals(users, searchEngine.find("FONTANERO"));
	}
}
