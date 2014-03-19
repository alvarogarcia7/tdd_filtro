package filtro;

import java.util.Arrays;
import java.util.List;

public class SplitterNormalizer {

	public List<String> normalize(String searchQuery) {
		searchQuery = removeExtraSpaces(searchQuery);
		List<String> words = Arrays.asList(searchQuery.trim().split(" "));
		return words;
	}
	
	private String removeExtraSpaces(String sentence) {
		return sentence.replaceAll("\\s+", " ");
	}
}
