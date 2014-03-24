package filtro;

import java.util.List;

public class SearchEngine {
	
	private Filter filter;
	public SearchEngine(Filter filter){
		this.filter = filter; 
	}
	
	public List<String> find(String searchQuery) {
		return filter.normalize(searchQuery);
	}
}
