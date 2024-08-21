package com.doctorhoai.shipping_service;

import com.doctorhoai.shipping_service.service.client.OrderFeignClient;
import com.doctorhoai.shipping_service.service.client.ProductFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class ShippingServiceApplication{
    public static void main(String[] args) {
        SpringApplication.run(ShippingServiceApplication.class, args);
    }

}
