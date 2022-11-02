package com.example.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.customers.Customer;
import com.example.demo.customers.Customer_serv;


@SpringBootApplication
public class CapstoneProjMAadharApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CapstoneProjMAadharApplication.class, args);
	}

	@Autowired
	private Customer_serv customer_serv;
	
	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception {
//		String string = "08-10-2000";
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
//		LocalDate date = LocalDate.parse(string, formatter);
//		System.out.println(date); // 2010-01-02
		Customer newCust = new Customer(1001, "Ajith",new Date(),"ajith@gmail.com",9876546789L,"male",
				"2/87 midle srt","ulun","kalla","tn",604321L);
		customer_serv.addCustomer(newCust);
	}

}
