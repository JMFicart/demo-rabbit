package com.example.demo;

import com.example.demo.receive.MessageFactureSender;
import org.springframework.amqp.core.Binding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ReservFactApplication {

	public static void main(String[] args) {
		ApplicationContext ctxt = SpringApplication.run(ReservFactApplication.class, args);
//		Binding b = ctxt.getBean(Binding.class);
//		System.out.println(b);
	}

}
