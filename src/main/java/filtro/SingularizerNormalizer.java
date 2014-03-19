package filtro;

public class SingularizerNormalizer {

	public String normalize(String searchQuery, String language) {
		String SUFFIX_PLURAL = "S";
		if("XX".equals(language)){
			SUFFIX_PLURAL = "X";
		}
		
		if(searchQuery.endsWith(SUFFIX_PLURAL)){
			return searchQuery.substring(0, searchQuery.length()-1);
		}
		return searchQuery;
	}
}
