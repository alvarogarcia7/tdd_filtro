package filtro;

import java.util.List;

public class SearchQueryFilter {
	
	private Filter filter;
	public SearchQueryFilter(Filter filter){
		this.filter = filter;
	}
	
	public List<String> normalize(String searchQuery) {
		searchQuery = filter.normalize(searchQuery);
		
		SplitterNormalizer splitter = new SplitterNormalizer();
		return splitter.normalize(searchQuery);
	}
}
