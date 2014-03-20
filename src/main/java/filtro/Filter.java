package filtro;

public class Filter {
	
	private Normalizer[] normalizers;

	public Filter(Normalizer[] normalizers) {
		this.normalizers = normalizers;
	}

	public String normalize(String searchQuery) {

		for (Normalizer filter : normalizers) {
			searchQuery = filter.normalize(searchQuery);
		}
		
		return searchQuery;
	}
}
