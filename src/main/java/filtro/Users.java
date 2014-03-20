package filtro;

import java.util.ArrayList;
import java.util.List;

public class Users {

	private List<User> users = new ArrayList<User>();
	
	public void addUser(String name, String profile) {
		User user = new User();
		user.setName(name);
		user.setProfile(profile);
		this.users.add(user);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	public boolean contains(User user) {
		return users.contains(user);
	}

	public int size() {
		return users.size();
	}
}
