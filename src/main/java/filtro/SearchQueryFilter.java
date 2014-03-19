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
		
		SplitterNormalizer filterSplitter = new SplitterNormalizer();
		return filterSplitter.normalize(searchQuery);
	}
}
