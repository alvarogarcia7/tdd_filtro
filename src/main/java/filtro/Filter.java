package filtro;

import java.util.List;

public class Filter {
	
	private Normalizer[] normalizers;

	public Filter(Normalizer[] normalizers) {
		this.normalizers = normalizers;
	}

	public List<String> normalize(String searchQuery) {

		for (Normalizer filter : normalizers) {
			searchQuery = filter.normalize(searchQuery);
		}
		
		SplitterNormalizer splitter = new SplitterNormalizer();
		return splitter.normalize(searchQuery);
	}
}
