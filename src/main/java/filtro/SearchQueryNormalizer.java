package filtro;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class SearchQueryNormalizer {
	

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
