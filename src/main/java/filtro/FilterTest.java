package filtro;

import static org.junit.Assert.assertEquals;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

import filtro.FilterTest.SearchQueryNormalizer;

public class FilterTest {
	
	private List<String> result;
	
	public static class SearchQueryNormalizer {
		

		public SearchQueryNormalizer() {
		}
		
		public List<String> filter(String searchQuery) {
			List<String> result = new ArrayList<String>();

			searchQuery = searchQuery.toUpperCase();
			
			searchQuery = Normalizer.normalize(searchQuery, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
			
			String SUFFIX_PLURAL = "S";
			if(searchQuery.endsWith(SUFFIX_PLURAL)){
				searchQuery = searchQuery.substring(0, searchQuery.length()-1);
			}
			
			result.add(searchQuery);
			
			return result;
		}
	}


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
