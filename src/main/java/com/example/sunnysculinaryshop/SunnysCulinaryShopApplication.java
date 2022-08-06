package com.example.sunnysculinaryshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@SpringBootApplication
@EnableScheduling
public class SunnysCulinaryShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SunnysCulinaryShopApplication.class, args);
//	PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder();
//		System.out.println(passwordEncoder.encode("12345"));
	}

}
