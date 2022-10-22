package SpringBoot.SpringBootReactor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringBootReactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactorApplication.class, args);
	}

}

@RestController
class FluxAPI{
	
	@GetMapping("/cus")
	public Flux<Customer> getFluxObjects() {
		List<Customer> objCustList = new ArrayList<Customer>();
		for(int i=0;i<5;i++) {
			Customer objCust = new Customer();
			objCust.setId(i);
			objCust.setName("Test name " + i);
			objCust.setDesc("Test desc " + i);
			objCustList.add(objCust);
		}
		
		return Flux.fromIterable(objCustList);
	}
}

class Customer{
	int id;
	String name;
	String desc;
	
	Customer(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
