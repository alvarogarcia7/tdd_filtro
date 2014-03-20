package filtro;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class FilterLanguageXX extends FilterLanguage {

	@Before
	public void setUp() {
		filter = FilterFactory.createXFilter();

		expectedWords = new ArrayList<String>();
		expectedWords.add("FONTANERO");
	}

	@Test
	public void in_language_XX_input_with_plural_words_converted_to_list_of_singular_word() {
		assertEquals(expectedWords, filter.normalize("FONTANEROX"));
	}

}
