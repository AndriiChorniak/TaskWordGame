package com.epam.chorniak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

public class Game {

	private static final Logger LOG = Logger.getLogger(Game.class);

	private Scanner scan = new Scanner(System.in);

	private List<User> users;
	private List<String> cities;
	private Set<String> usedCities;
	private String answerWord;
	 
	

	public List<String> getCities() {
		return cities;
	}

	public Game(List<String> cities) {
		this.users = new ArrayList<>();
		this.cities = cities;
		this.usedCities = new HashSet<>();
	}

	public void start() {
		init();
		LOG.info("Start of the game!");
		while (true) {
			    for (User user : users) {
				boolean correct = false;
				while (!correct) {
					System.out.println(user.getName() + " says: ");
					String enteredCity = null;
					try {
						enteredCity = scan.nextLine();
					} catch (Exception e) {
						correct = true;
						
					}
					if (!enteredCity.equalsIgnoreCase("quit")) {
						if (!usedCities.contains(enteredCity)) {
							if (!cities.contains(enteredCity)) {
								System.out
										.println("There is no such city. Please enter correct city.");
								LOG.warn("User entered a non-existent city.");
							} else {
								if (enteredCity.charAt(0) == answerWord
										.charAt(answerWord.length() - 1)) {
									usedCities.add(enteredCity);
									answerWord = enteredCity;
									correct = true;
								} else {
									System.out
											.println("You enter incorrect city.");
									LOG.warn("User entered incorrent city");
								}
							}

						} else {
							System.out
									.println("This city has already been. Please enter another city.");
							LOG.warn("User entered city wich has already been.");
						}
					} else {
						end();
						return;
					}
				}
			}
		}
	}

	public void end() {
		scan.close();
		System.out.println("Game over!");
	}

	public void init() {
		LOG.info("Initialization of game");
		answerWord = cities.get(new Random().nextInt(cities.size()));
		LOG.info("Random city has been chosed: " + answerWord);
		System.out.println("Enter number of users: ");
		Integer numOfUsers = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < numOfUsers; i++) {
			System.out.println("Enter name of " + (i + 1) + " user: ");
			String name = scan.nextLine();
			users.add(new User(name));
		}
		LOG.info("Users has been created!");
		System.out
				.println("Game starts! If you want quit enter quit Good Luck =)");
		System.out.println("First city is " + answerWord);
		System.out.println("Enter city in English and in lowercase");
		LOG.info("Game has been initialized");
	}

}
