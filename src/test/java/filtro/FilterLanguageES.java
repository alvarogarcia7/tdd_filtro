package filtro;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FilterLanguageES {
	
	private List<String> expectedWords;
	private SearchQueryFilter filter; 

	@Before
	public void setUp() {
		FilterFactory factory = new FilterFactory();
		Filter spanishFilter = factory.createSpanishFilter();
		filter = new SearchQueryFilter(spanishFilter);
		
		expectedWords = new ArrayList<String>();
		expectedWords.add("FONTANERO");
	}

	@Test
	public void input_with_single_word_is_converted_to_list_of_single_word() {
		assertEquals(expectedWords, filter.normalize("FONTANERO")); 
	}
	
	@Test
	public void input_with_lowcase_word_is_converted_to_list_of_uppercase_word(){
		assertEquals(expectedWords, filter.normalize("fontanero"));
	}
	
	@Test
	public void input_with_accentuated_word_is_converted_to_list_of_non_accentuated_word(){
		assertEquals(expectedWords, filter.normalize("FÓNTANÈRÓ"));
	}
	
	@Test
	public void input_with_plural_word_is_converted_to_list_of_singula_word(){
		assertEquals(expectedWords, filter.normalize("FONTANEROS"));
	}

	@Test
	public void input_with_words_is_converted_to_list_of_words(){
		expectedWords.add("BARCELONA");
		assertEquals(expectedWords, filter.normalize("FONTANERO BARCELONA"));
	}
	
	@Test
	public void input_with_words_with_lead_spaces_converted_to_list_of_words(){
		expectedWords.add("BARCELONA");
		assertEquals(expectedWords, filter.normalize(" FONTANERO BARCELONA"));		
	}
	
	@Test
	public void input_with_words_with_inline_spaces_converted_to_list_of_words(){
		expectedWords.add("BARCELONA");
		assertEquals(expectedWords, filter.normalize("FONTANERO   BARCELONA"));		
	}
	

}
