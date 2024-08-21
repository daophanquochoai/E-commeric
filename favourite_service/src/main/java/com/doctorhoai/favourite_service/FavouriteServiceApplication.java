package com.doctorhoai.favourite_service;

import com.doctorhoai.favourite_service.service.client.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FavouriteServiceApplication implements CommandLineRunner {
	@Autowired
	private ProductFeignClient productFeignClient;

	public static void main(String[] args) {
		SpringApplication.run(FavouriteServiceApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println(productFeignClient.findById(1L));
	}
}
