package filtro;

import java.util.List;

public class SearchEngine {
	
	private Filter filter;
	public SearchEngine(Filter filter){
		this.filter = filter; 
	}
	
	public List<String> find(String searchQuery) {
		return normalize(searchQuery);
	}

	private List<String> normalize(String searchQuery) {
		searchQuery = filter.normalize(searchQuery);
		
		SplitterNormalizer splitter = new SplitterNormalizer();
		return splitter.normalize(searchQuery);
	}
}
