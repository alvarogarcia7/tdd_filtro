package filtro;


public class AccentRemoverNormalizer implements Normalizer{

	public String normalize(String searchQuery) {
		searchQuery = java.text.Normalizer.normalize(searchQuery, java.text.Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		return searchQuery;
	}

}
