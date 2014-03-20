package filtro;

public abstract class SingularizerNormalizer implements Normalizer{

	public String normalize(String searchQuery) {
		String SUFFIX_PLURAL = getPluralSuffix();
		System.out.println("pluaral Suffix = "+SUFFIX_PLURAL);
		if(searchQuery.endsWith(SUFFIX_PLURAL)){
			return searchQuery.substring(0, searchQuery.length()-1);
		}
		return searchQuery;
	}
	
	public abstract String getPluralSuffix();
	
}
