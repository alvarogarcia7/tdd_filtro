package filtro;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;

public class SearchQueryFilter {
	
	public List<String> normalize(String searchQuery) {
		searchQuery = toUpperCase(searchQuery);
		searchQuery = removeAccents(searchQuery);
		searchQuery = toSingular(searchQuery);
		return getWordsFrom(searchQuery);
	}

	private List<String> getWordsFrom(String sentence) {
		List<String> result = Arrays.asList(sentence.split(" "));
		return result;
	}

	private String toSingular(String candidateRegularPlural) {
		final String SUFFIX_PLURAL = "S";
		
		if(candidateRegularPlural.endsWith(SUFFIX_PLURAL)){
			return candidateRegularPlural.substring(0, candidateRegularPlural.length()-1);
		}
		return candidateRegularPlural;
	}

	private String removeAccents(String searchQuery) {
		searchQuery = Normalizer.normalize(searchQuery, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		return searchQuery;
	}

	private String toUpperCase(String searchQuery) {
		searchQuery = searchQuery.toUpperCase();
		return searchQuery;
	}
}
