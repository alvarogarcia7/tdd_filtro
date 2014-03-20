import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import filtro.FilterFactory;
import filtro.SearchEngine;


public class SearchEngineTest {

	@Test
	public void when_language_ES_input_single_word_returns_list_of_user() {
		FilterFactory filterFactory = new FilterFactory();
		SearchEngine searchEngine = new SearchEngine(filterFactory.createSpanishFilter());
		assertEquals(new ArrayList<User>(), searchEngine.find("FONTANERO"));
	}

}
