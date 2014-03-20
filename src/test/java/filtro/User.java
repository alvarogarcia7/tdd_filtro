package filtro;

public class User {

	private String name;
	private String profile;

	public User() {
	}
	
	public User(String name, String profile) {
		setName(name);
		setProfile(profile);
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

	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return getName().equals(other.getName()) && getProfile().equals(other.getProfile());
	}
}
