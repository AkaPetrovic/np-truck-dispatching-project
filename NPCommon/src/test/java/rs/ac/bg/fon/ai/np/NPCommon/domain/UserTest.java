package rs.ac.bg.fon.ai.np.NPCommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UserTest {

	private User u;
	
	@BeforeEach
	void setUp() throws Exception {
		u = new User();
	}

	@AfterEach
	void tearDown() throws Exception {
		u = null;
	}

	@Test
	void testSetId() {
		u.setId(5L);
		assertEquals(5L, u.getId());
	}
	
	@Test
	void testSetFirstname() {
		u.setFirstname("Firstname");
		assertEquals("Firstname", u.getFirstname());
	}
	
	@Test
	void testSetLastname() {
		u.setLastname("Lastname");
		assertEquals("Lastname", u.getLastname());
	}
	
	@Test
	void testSetUsername() {
		u.setUsername("Username");
		assertEquals("Username", u.getUsername());
	}
	
	@Test
	void testSetPassword() {
		u.setPassword("Password");
		assertEquals("Password", u.getPassword());
	}
	
	@Test
	void testSetRole() {
		u.setRole("Manager");
		assertEquals("Manager", u.getRole());
	}
	
	@Test
	void testToString() {
		u.setId(5L);
		u.setFirstname("Firstname");
		u.setLastname("Lastname");
		u.setUsername("Username");
		u.setPassword("Password");
		u.setRole("Manager");
		
		
		
		assertEquals("User{id=5, firstname=Firstname, lastname=Lastname, username=Username, password=Password, role=Manager}", u.toString());
	}
	
	@ParameterizedTest
	@CsvSource ({
		"1, Firstname, Lastname, Username, Password, Manager, 1, Firstname, Lastname, Username, Password, Manager, true",
		"1, Firstname, Lastname, Username, Password, Manager, 1, Firstname, Lastname, Username, Password, Dispatcher, false",
		"1, Firstname, Lastname, Username, Password, Manager, 1, Firstname, Lastname, Username, Passwordd, Manager, false",
		"1, Firstname, Lastname, Username, Password, Manager, 1, Firstname, Lastname, Usernamee, Password, Manager, false",
		"1, Firstname, Lastname, Username, Password, Manager, 1, Firstname, Lastnamee, Username, Password, Manager, false",
		"1, Firstname, Lastname, Username, Password, Manager, 1, Firstnamee, Lastname, Username, Password, Manager, false",
		"1, Firstname, Lastname, Username, Password, Manager, 2, Firstname, Lastname, Username, Password, Manager, false",
	})
	void testEquals(Long id1, String firstname1, String lastname1, String username1, String password1, String role1, Long id2, String firstname2, String lastname2, String username2, String password2, String role2, boolean same) {
		u.setId(id1);
		u.setFirstname(firstname1);
		u.setLastname(lastname1);
		u.setUsername(username1);
		u.setPassword(password1);
		u.setRole(role1);
		
		User u2 = new User();
		
		u2.setId(id2);
		u2.setFirstname(firstname2);
		u2.setLastname(lastname2);
		u2.setUsername(username2);
		u2.setPassword(password2);
		u2.setRole(role2);
		
		assertEquals(same, u.equals(u2));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(u.equals(null));
	}
	
	@Test
	void testEqualsSame() {
		assertTrue(u.equals(u));
	}
	
	@Test
	void testEqualsDifferentClass() {
		assertFalse(u.equals(new Exception()));
	}

}
