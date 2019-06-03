package assignment02;

import java.util.Scanner;

public class Assignment02 {
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		new Assignment02();
	}

	// This will act as our program switchboard
	public Assignment02() {
		Item[] cargohold = new Item[10];

		System.out.println("Welcome to the BlackStar Cargo Hold interface.");
		System.out.println("Please select a number from the options below");
		System.out.println("");

		while (true) {
			// Give the user a list of their options
			System.out.println("1: Add an item to the cargo hold.");
			System.out.println("2: Remove an item from the cargo hold.");
			System.out.println("3: Sort the contents of the cargo hold.");
			System.out.println("4: Search for an item.");
			System.out.println("5: Display the items in the cargo hold.");
			System.out.println("0: Exit the BlackStar Cargo Hold interface.");

			// Get the user input
			int userChoice = input.nextInt();
			input.nextLine();

			switch (userChoice) {
			case 1:
				addItem(cargohold);
				break;
			case 2:
				removeItem(cargohold);
				break;
			case 3:
				sortItems(cargohold);
				break;
			case 4:
				System.out.println("Enter 1 to search by name and 2 to search by ID: ");
				userChoice = input.nextInt();
				switch (userChoice) {
				case 1: 
					searchItems(cargohold);
					break;
				case 2:
					searchItemsById(cargohold);
					break;
				}
				break;
			case 5:
				displayItems(cargohold);
				break;
			case 0:
				System.out.println("Thank you for using the BlackStar Cargo Hold interface. See you again soon!");
				System.exit(0);
			}
		}

	}

	private void addItem(Item cargohold[]) {
		System.out.println("Enter the name of the item you want to put in cargohold: ");
		String name = input.nextLine();
		System.out.println("Enter the weight of the item you want to put in cargohold: ");
		int weight = input.nextInt();
		System.out.println("Enter the value of the item you want to put in cargohold: ");
		int value = input.nextInt();
		System.out.println("Enter the durability of the item you want to put in cargohold: ");
		int durability = input.nextInt();
		System.out.println("Enter the ID of the item you want to put in cargohold: ");
		int ID = input.nextInt();

		Item item = new Item(name, weight, value, durability, ID);

		for (int i = 0; i < cargohold.length; i++) {
			if (cargohold[i] == null) {
				cargohold[i] = item;
				System.out.println("Item " + item.getName() + " added to space " + i);
				return;
			}
		}
		System.out.println("Cargohold is full");
	}

	private void removeItem(Item cargohold[]) {
		System.out.println("Enter the name of the item you want to remove from cargohold: ");
		String remove = input.nextLine();

		for (int i = 0; i < cargohold.length; i++) {
			if (cargohold[i].getName().equals(remove)) {
				cargohold[i] = null;
				System.out.println("Item " + remove + " removed from space " + i);
				return;
			}
		}

		System.out.println(remove + " was not found in cargohold");
	}

	private void sortItems(Item cargohold[]) {
		for (int i = 0; i < cargohold.length; i++) {
			Item currentMin = cargohold[i];
			int currentMinIndex = i;

			for (int j = i; j < cargohold.length; j++) {
				if (cargohold[j] != null && currentMin.getName().compareTo(cargohold[j].getName()) > 0) {
					currentMin = cargohold[j];
					currentMinIndex = j;
				}
			}

			if (cargohold[i] != null && currentMinIndex != i) {
				cargohold[currentMinIndex] = cargohold[i];
				cargohold[i] = currentMin;
			}
		}
	}

	private void searchItems(Item cargohold[]) {
		input.nextLine();
		System.out.println("Enter the name of the item you want to find in cargohold: ");
		String find = input.nextLine();

		for (int i = 0; i < cargohold.length; i++) {
			if (cargohold[i]!=null && cargohold[i].getName().equals(find)) {
				System.out.println("Item " + cargohold[i].getName() + " found in space " + i);
				return;
			}
		}

		System.out.println(find + " is not found in cargohold");
	}

	private void searchItemsById(Item cargohold[]) {
		System.out.println("Enter the ID of the item you want to find in cargohold: ");
		int find = input.nextInt();

		for (int i = 0; i < cargohold.length; i++) {
			if (cargohold[i]!=null && cargohold[i].getID()==find) {
				System.out.println("Item " + cargohold[i].getName() + " found in space " + i);
				return;
			}
		}

		System.out.println("ID " + find + " is not found in cargohold");
	}
	private void displayItems(Item cargohold[]) {
		Item[] temp = cargohold.clone();

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == null)
				continue;
			int count = 0;
			String value = temp[i].getName();

			for (int j = i; j < temp.length; j++) {
				if (temp[j] == null)
					continue;

				if (value.equals(temp[j].getName())) {
					count++;
					temp[j] = null;
				}

			}
			System.out.println(value + " - " + count);

		}

	}
}
