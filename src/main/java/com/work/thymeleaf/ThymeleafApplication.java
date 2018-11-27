package com.work.thymeleaf;

import com.sun.nio.zipfs.ZipPath;
import com.work.thymeleaf.controller.ImageController;
import com.work.thymeleaf.helper.Helper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.MalformedURLException;

@SpringBootApplication
public class ThymeleafApplication {

	public static void main(String[] args) throws MalformedURLException {


		SpringApplication.run(ThymeleafApplication.class, args);
	}
}
