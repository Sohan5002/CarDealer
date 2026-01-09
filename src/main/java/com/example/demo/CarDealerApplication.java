package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class CarDealerApplication {

	public static void main(String[] args) {

		SpringApplication.run(CarDealerApplication.class, args);

		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("ApplicationContext.xml");

		Scanner sc = new Scanner(System.in);
		int userChoice;

		do {
			System.out.println("\nWhich type of car you like?");
			System.out.println("1. Family Car");
			System.out.println("2. Sports Car");
			System.out.println("3. CyberTruck");
			System.out.println("0. Exit");

			userChoice = sc.nextInt();
			String beanId = null;

			switch (userChoice) {
				case 1:
					beanId = "family";
					break;
				case 2:
					beanId = "sportsCar";
					break;
				case 3:
					beanId = "cyberTruck";
					break;
				case 0:
					System.out.println("Thank you for visiting 🚗");
					break;
				default:
					System.out.println("Invalid choice, try again!");
			}

			if (beanId != null) {
				Car car = (Car) context.getBean(beanId);
				car.ShowCar();
			}

		} while (userChoice != 0);

		context.close();
		sc.close();
	}
}
