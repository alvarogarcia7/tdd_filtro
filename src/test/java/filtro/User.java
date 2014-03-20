package filtro;

public class User {

	private String name;
	private String profile;
	private String country;

	public User() {
	}

	public User(String name, String profile, String country) {
		setName(name);
		setProfile(profile);
		setCountry(country);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return getName().equals(other.getName()) &&
				getProfile().equals(other.getProfile());
	}

}
