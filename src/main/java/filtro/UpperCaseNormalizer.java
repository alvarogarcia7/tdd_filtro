package filtro;

public class UpperCaseNormalizer implements Normalizer{
	
	public String normalize(String word) { 
		word = word.toUpperCase();
		return word;
	}

}
