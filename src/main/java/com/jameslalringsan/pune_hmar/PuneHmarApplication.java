package com.jameslalringsan.pune_hmar;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@SpringBootApplication
public class PuneHmarApplication {


	

	public static void main(String[] args) {
		SpringApplication.run(PuneHmarApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/basicInfo")
	public String saveusers() {
		return "basicInfo";
	}

	@GetMapping("/allUserDetails")
	public String allUserDetails() {
		return "allUserDetails.html";
	}
}
