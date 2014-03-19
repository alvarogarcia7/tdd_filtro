package filtro;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchQueryFilter {
	
	public List<String> normalize(String searchQuery) {
		return normalize(searchQuery, "ES");
	}
	public List<String> normalize(String searchQuery, String language) {
		
		UpperCaseNormalizer filter = new UpperCaseNormalizer();
		searchQuery = filter.normalize(searchQuery);

		AccentRemoverNormalizer filterAccents = new AccentRemoverNormalizer();
		searchQuery = filterAccents.normalize(searchQuery);
		
		SingularizerNormalizer filterSingularizer = new SingularizerNormalizer();
		searchQuery = filterSingularizer.normalize(searchQuery, language);
		
		return getWordsFrom(searchQuery);
	}

	private List<String> getWordsFrom(String sentence) {
		sentence = removeExtraSpaces(sentence);
		List<String> words = Arrays.asList(sentence.trim().split(" "));
		return words;
	}

	private String removeExtraSpaces(String sentence) {
		return sentence.replaceAll("\\s+", " ");
	}
}
