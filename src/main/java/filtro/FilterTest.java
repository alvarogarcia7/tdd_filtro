package filtro;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FilterTest {

	@Test
	public void input_with_single_word_is_converted_to_list_of_single_word() {
		ArrayList<String> result = new ArrayList<String>();
		result.add("FONTANERO");
		assertEquals(result, filter("FONTANERO")); 
	}
	
	@Test
	public void input_with_lowcase_word_is_converted_to_list_of_uppercase_word(){
		ArrayList<String> result = new ArrayList<String>();
		result.add("FONTANERO");
		assertEquals(result, filter("fontanero"));
	}

	private Object filter(String searchQuery) {
		List<String> result = new ArrayList<String>();
		result.add(searchQuery.toUpperCase());
		return result;
	}

}
