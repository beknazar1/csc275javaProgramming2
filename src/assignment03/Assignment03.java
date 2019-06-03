package assignment03;

import java.util.*;

public class Assignment03 {
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		new Assignment03();
	}

	// This will act as our program switchboard
	public Assignment03() {
		List<Item> cargohold = new ArrayList<Item>();
		
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
			case 6:
				partialSearch(cargohold);
				break;

			case 0:
				System.out.println("Thank you for using the BlackStar Cargo Hold interface. See you again soon!");
				System.exit(0);
			}
		}

	}

	private void addItem(List<Item> cargohold) {
		System.out.println("Enter the name of the item you want to put in cargohold: ");
		String name = input.nextLine();
		System.out.println("Enter the weight of the item you want to put in cargohold: ");
		double weight = input.nextDouble();
		System.out.println("Enter the value of the item you want to put in cargohold: ");
		int value = input.nextInt();
		System.out.println("Enter the durability of the item you want to put in cargohold: ");
		int durability = input.nextInt();
		System.out.println("Enter the ID of the item you want to put in cargohold: ");
		int ID = input.nextInt();

		Item item = new Item(name, weight, value, durability, ID);
		
		double cargoWeight = 0;
		
		for (Item item2 : cargohold) {
			cargoWeight += item2.getWeight();
		}
		
		if (cargoWeight < 25.0 && cargoWeight+item.getWeight() < 25.0) {
			cargohold.add(item);
			System.out.println("Item " + item.getName() + " added to cargohold");
			return;
		}
		
		System.out.println("Cargohold is full");
	}

	private void removeItem(List<Item> cargohold) {
		System.out.println("Enter the name of the item you want to remove from cargohold: ");
		String remove = input.nextLine();
		
		Iterator<Item> iter = cargohold.iterator();
		
		while(iter.hasNext()) {
			Item i = iter.next();
			if(i.getName().equals(remove)) {
				cargohold.remove(i);
				System.out.println("Item " + remove + " removed from cargohold");
				return;
			}
		}
		
		System.out.println(remove + " was not found in cargohold");
	}

	private void sortItems(List<Item> cargohold) {
		for (int i = 0; i < cargohold.size(); i++) {
			Item currentMin = cargohold.get(i);
			int currentMinIndex = i;

			for (int j = i; j < cargohold.size(); j++) {
				if (currentMin.getName().compareTo(cargohold.get(j).getName()) > 0) {
					currentMin = cargohold.get(j);
					currentMinIndex = j;
				}
			}

			if (currentMinIndex != i) {
				cargohold.set(currentMinIndex, cargohold.get(i));
				cargohold.set(i, currentMin);
			}
		}
	}

	private void searchItems(List<Item> cargohold) {
		input.nextLine();
		System.out.println("Enter the name of the item you want to find in cargohold: ");
		String find = input.nextLine();

		for (int i = 0; i < cargohold.size(); i++) {
			if (cargohold.get(i).getName().equals(find)) {
				System.out.println("Item " + cargohold.get(i).getName() + " found in space " + i);
				return;
			}
		}

		System.out.println(find + " is not found in cargohold");
	}

	private void searchItemsById(List<Item> cargohold) {
		System.out.println("Enter the ID of the item you want to find in cargohold: ");
		int find = input.nextInt();

		for (int i = 0; i < cargohold.size(); i++) {
			if (cargohold.get(i).getID()==find) {
				System.out.println("Item " + cargohold.get(i).getName() + " found in space " + i);
				return;
			}
		}

		System.out.println("ID " + find + " is not found in cargohold");
	}
	private void displayItems(List<Item> cargohold) {
		List<Item> temp = new ArrayList<Item>(cargohold);
		
		if (temp.size()==0) {
			System.out.println("Cargohold is empty");
			return;
		}
			
		for (int i = 0; i < temp.size(); ) {
			String name = temp.get(i).getName();
			int count = 0;
			
			for (int j = i; j < temp.size(); ) {
				if (temp.get(j).getName().equals(name)) {
					count++;
					temp.remove(j);
					continue;
				} else {
					j++;
				}
			}
			
			System.out.println(name + " - " + count);
		}
	}
	
	private void partialSearch(List<Item> cargohold) {
		input.nextLine();
		System.out.println("Enter the partial name of the item you want to find in cargohold: ");
		String find = input.nextLine();

		for (int i = 0; i < cargohold.size(); i++) {
			if (cargohold.get(i).getName().contains(find)) {
				System.out.println("Item " + cargohold.get(i).getName() + " found in space " + i);
				return;
			}
		}

		System.out.println(find + " is not found in cargohold");
	}

}
