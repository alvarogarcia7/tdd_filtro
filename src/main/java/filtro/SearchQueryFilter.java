package filtro;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchQueryFilter {
	
	public SearchQueryFilter() {
	}
	
	public List<String> normalize(String searchQuery) {
		List<String> result = new ArrayList<String>();
		searchQuery = toUpperCase(searchQuery);
		searchQuery = removeAccents(searchQuery);
		searchQuery = toSingular(searchQuery);
		result = splitByOneSpace(searchQuery);
		return result;
	}

	private List<String> splitByOneSpace(String searchQuery) {
		List<String> result;
		result = Arrays.asList(searchQuery.split(" "));
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
