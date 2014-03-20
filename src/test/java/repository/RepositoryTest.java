package repository;

import static org.junit.Assert.*;

import org.junit.Test;

public class RepositoryTest {

	@Test
	public void repository_creation() {
		assertNotNull(new Repository());
	}

}
