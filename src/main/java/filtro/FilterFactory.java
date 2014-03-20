package filtro;

public class FilterFactory {

	public static Filter createSpanishFilter() {
		Normalizer[] normalizers = new Normalizer[] { new UpperCaseNormalizer(), new AccentRemoverNormalizer(), new SingularizerSpanishNormalizer() };
		Filter filter = new Filter(normalizers);
		return filter;
	}
	
	public static Filter createXFilter() {
		Normalizer[] normalizers = new Normalizer[] { new UpperCaseNormalizer(), new AccentRemoverNormalizer(), new SingularizerXNormalizer() };
		Filter filter = new Filter(normalizers);
		return filter;
	}

}
