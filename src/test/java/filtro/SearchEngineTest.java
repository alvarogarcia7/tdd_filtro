package filtro;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class SearchEngineTest {

	private Filter spanishFilter;
	private StubUserRepository userRepository;

	@Before
	public void setUp(){
		spanishFilter = FilterFactory.createSpanishFilter();

		userRepository = new StubUserRepository();
		userRepository.setUsers(new Users());
	}
	
	@Test
	public void when_language_ES_input_single_word_returns_list_of_user() {
		SearchEngine searchEngine = new SearchEngine(spanishFilter, userRepository);
		assertEquals(new Users(), searchEngine.find("FONTANERO"));
	}

	@Test
	public void when_language_ES_and_searching_by_a_keyword_returns_matching_users() {
		Users users = new Users();
		users.addUser("James", "Fontanero en Barcelona");
		users.addUser("David", "FONTANERO");
		users.addUser("Marcos", "Mecánico en Mataró");
		
		userRepository.setUsers(users);

		SearchEngine searchEngine = new SearchEngine(spanishFilter, userRepository);
		Users result = searchEngine.find("FONTANERO");
		
		assertContainsUser(result, new User("James", "Fontanero en Barcelona"));
		assertContainsUser(result, new User("David", "FONTANERO"));
	}

	private void assertContainsUser(Users result, User user) {
		assertTrue(result.contains(user));
	}
}
