package filtro;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FilterTest {
	
	private List<String> result;

	@Before
	public void setUp() {
		result = new ArrayList<String>();
		result.add("FONTANERO");
	}

	@Test
	public void input_with_single_word_is_converted_to_list_of_single_word() {
		assertEquals(result, filter("FONTANERO")); 
	}
	
	@Test
	public void input_with_lowcase_word_is_converted_to_list_of_uppercase_word(){
		assertEquals(result, filter("fontanero"));
	}
	
	@Test
	public void input_with_accentuated_word_is_converted_to_list_of_non_accentuated_word(){
		assertEquals(result, filter("FÓNTANÈRÓ"));
	}
	
	@Test
	public void input_with_plural_word_is_converted_to_list_of_singula_word(){
		assertEquals(result, filter("FONTANEROS"));
	}

	private List<String> filter(String searchQuery) {
		SearchQueryNormalizer normalizer = new SearchQueryNormalizer();
		return normalizer.filter(searchQuery);
	}

}
