package SpringBoot.SpringBootMockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.spring.dao.CustomDao;
import com.spring.entity.Users;
import com.spring.service.CustomService;

/**
 * Unit test for simple App.
 * https://www.youtube.com/watch?v=kXhYu939_5s
 * https://github.com/Java-Techie-jt/spring-boot-mockito
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest
{
	@Autowired
	private CustomService objService;
	
	@MockBean
	private CustomDao objDao;
	
	@Test
	public void getAllUsers() {
		when(objDao.findAll()).thenReturn(Stream.of(new Users(1,"vishnu","testuser"), new Users(2,"dinesh","testuser")).collect(Collectors.toList()));
		assertEquals(2, objService.getUsers().size());
	}
	
	@Test
	public void findUserByName() {
		when(objDao.findByName("dinesh")).thenReturn(new Users(1, "dinesh", "developer"));
		assertEquals("dinesh", objService.findUserByName("dinesh").getName());
	}

	@Test
	public void addUser() {
		Users user = new Users(1, "dinesh", "developer");
		when(objDao.save(user)).thenReturn(user);
		assertEquals(user, objService.addUser(user));
	}
	
	@Test
	public void delete() {
		Users user = new Users(1, "dinesh", "developer");
		objService.deleteUser(user);
		verify(objDao, times(1)).delete(user); 
	}
}
