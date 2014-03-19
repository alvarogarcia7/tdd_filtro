package filtro;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FilterTest {
	
	private List<String> result;
	private SearchQueryFilter filter; 

	@Before
	public void setUp() {
		filter = new SearchQueryFilter();
		
		result = new ArrayList<String>();
		result.add("FONTANERO");
	}

	@Test
	public void input_with_single_word_is_converted_to_list_of_single_word() {
		assertEquals(result, filter.normalize("FONTANERO")); 
	}
	
	@Test
	public void input_with_lowcase_word_is_converted_to_list_of_uppercase_word(){
		assertEquals(result, filter.normalize("fontanero"));
	}
	
	@Test
	public void input_with_accentuated_word_is_converted_to_list_of_non_accentuated_word(){
		assertEquals(result, filter.normalize("FÓNTANÈRÓ"));
	}
	
	@Test
	public void input_with_plural_word_is_converted_to_list_of_singula_word(){
		assertEquals(result, filter.normalize("FONTANEROS"));
	}

	@Test
	public void input_with_words_is_converted_to_list_of_words(){
		result.add("BARCELONA");
		assertEquals(result, filter.normalize("FONTANERO BARCELONA"));
	}

}
