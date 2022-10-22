package SpringBootJWTTokenSecurity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.spring.entity.CustomUser;
import com.spring.repository.CustomDaoRepository;

@SpringBootApplication(scanBasePackages={"com.spring"})
@ComponentScan(basePackages= {"com.spring"})
@EntityScan("com.spring.entity")
@EnableJpaRepositories("com.spring.repository")
public class SpringBootJwtTokenSecurityApplication {
	
	@Autowired
	CustomDaoRepository objRepository;
	
	@PostConstruct
	public void initData() {
		CustomUser objUser1 = new CustomUser(100, "dinesh", "1234", "d@k.com");
		CustomUser objUser2 = new CustomUser(101, "vishnu", "1234", "d@k.com");
		CustomUser objUser3 = new CustomUser(102, "kumar", "1234", "d@k.com");
		CustomUser objUser4 = new CustomUser(103, "chandru", "1234", "d@k.com");
		List<CustomUser> objList = new ArrayList<CustomUser>();
		objList.add(objUser1);
		objList.add(objUser2);
		objList.add(objUser3);
		objList.add(objUser4);
		objRepository.saveAll(objList);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtTokenSecurityApplication.class, args);
	}
	
	
	/** how to test this?
	 * step 1: run the app
	 * step 2: hit the generate token service pass {"userName":"dinesh","password":"1234"} to get the token
	 * step 3: hit the /welcome service and pass in hte header section for Authorization as header parameter, the beloe value
	 * Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkaW5lc2giLCJleHAiOjE2MTc3MDQyODksImlhdCI6MTYxNzY2ODI4OX0.u_ilownHurHlnZ276BLl7d955AezFT-11Izi9ZrW2hM
	 * now you will see the desired result
	 * if you want to test how the stateless session works, then u can uncheck this parameter and hit and see
	 * you will find the forbidden result
	 * */

}
