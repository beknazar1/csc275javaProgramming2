package assignment04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Assignment04 {
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		new Assignment04();
	}

	// This will act as our program switchboard
	public Assignment04() {
		List<Item> cargohold = new ArrayList<Item>();

		System.out.println("Welcome to the BlackStar Cargo Hold interface.");
		System.out.println("Would you like to load a previously saved file? yes or no");
		String choice = input.nextLine();

		if (choice.equals("yes") && new File("cargohold.txt").isFile()) {
			loadFile(cargohold);
		}

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
				System.out.println(
						"Enter 1 to search by name (full match), 2 to search by name (partial match), and 3 to search by ID: ");
				userChoice = input.nextInt();
				switch (userChoice) {
				case 1:
					searchItems(cargohold);
					break;
				case 2:
					partialSearch(cargohold);
					break;
				case 3:
					searchItemsById(cargohold);
					break;
				}
				break;
			case 5:
				displayItems(cargohold);
				break;
			case 0:
				System.out.println("Would you like to save changes into file? yes or no");
				choice = input.nextLine();
				if (choice.equals("yes")) {
					saveFile(cargohold);
				}
				System.out.println("Thank you for using the BlackStar Cargo Hold interface. See you again soon!");
				System.exit(0);
			}
		}

	}

	private void addItem(List<Item> cargohold) {
		System.out.println("Enter 1 for Equipable, 2 for Consumable, 3 for Weapon: ");
		int type = input.nextInt();
		input.nextLine();
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
		input.nextLine();

		Item item = null;

		switch (type) {
		case 1:
			System.out.println("Enter the body part that your item is equipable on: ");
			String bodyPart = input.nextLine();
			System.out.println("Is the equipable item a piece of clothing? Type 1 for yes, 2 for no: ");
			int clothingnum = input.nextInt();
			input.nextLine();
			boolean clothing = false;
			if (clothingnum == 1) {
				clothing = true;
			}
			System.out.println("Enter the effect of the equipable you want to put in cargohold: ");
			String effect = input.nextLine();
			item = new Equipable(name, weight, value, durability, ID, bodyPart, clothing, effect);
			break;
		case 2:
			System.out.println("Is the consumable item rechargable? Type 1 for yes, 2 for no: ");
			int rechargablenum = input.nextInt();
			boolean rechargable = false;
			if (rechargablenum == 1) {
				rechargable = true;
			}
			System.out.println("Is the consumable item a toxic? Type 1 for yes, 2 for no: ");
			int toxicnum = input.nextInt();
			boolean toxic = false;
			if (toxicnum == 1) {
				toxic = true;
			}
			System.out.println("Enter the duration of the effect of consumable: ");
			int effectDuration = input.nextInt();
			input.nextLine();
			item = new Consumable(name, weight, value, durability, ID, rechargable, toxic, effectDuration);
			break;
		case 3:
			System.out.println("Enter the attack damage of the weapon: ");
			int damage = input.nextInt();
			input.nextLine();
			System.out.println("Enter the type of the weapon: ");
			String weaponType = input.nextLine();
			System.out.println("Is the weapon two-handed? Type 1 for yes, 2 for no: ");
			int twoHandednum = input.nextInt();
			input.nextLine();
			boolean twoHanded = false;
			if (twoHandednum == 1) {
				twoHanded = true;
			}
			item = new Weapon(name, weight, value, durability, ID, damage, weaponType, twoHanded);
			break;
		default:
			return;
		}

		double cargoWeight = 0;

		for (Item item2 : cargohold) {
			cargoWeight += item2.getWeight();
		}

		if (cargoWeight < 25.0 && cargoWeight + item.getWeight() < 25.0) {
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

		while (iter.hasNext()) {
			Item i = iter.next();
			if (i.getName().equals(remove)) {
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
			if (cargohold.get(i).getID() == find) {
				System.out.println("Item " + cargohold.get(i).getName() + " found in space " + i);
				return;
			}
		}

		System.out.println("ID " + find + " is not found in cargohold");
	}

	private void displayItems(List<Item> cargohold) {
		List<Item> temp = new ArrayList<Item>(cargohold);

		if (temp.size() == 0) {
			System.out.println("Cargohold is empty");
			return;
		}

		for (int i = 0; i < temp.size();) {
			String name = temp.get(i).getName();
			int count = 0;

			for (int j = i; j < temp.size();) {
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

	private void loadFile(List<Item> cargohold) {
		BufferedReader br = null;

		try {
			File file = new File("cargohold.txt");
			br = new BufferedReader(new FileReader(file));

			String line;
			while ((line = br.readLine()) != null) {
				String[] arr = line.split("\t");
				Item item = null;
				
				String name = arr[0];
				double weight = Double.parseDouble(arr[1]);
				int value = Integer.parseInt(arr[2]);
				int durability = Integer.parseInt(arr[3]);
				int iD = Integer.parseInt(arr[4]);
				String attribute1 = arr[6];
				String attribute2 = arr[7];
				String attribute3 = arr[8];
				
				switch(arr[5]) {
				case "weapon": 
					item = new Weapon(name, weight, value, durability, iD, Integer.parseInt(attribute1), attribute2, Boolean.parseBoolean(attribute3));
					break;
				case "consumable":
					item = new Consumable(name, weight, value, durability, iD, Boolean.parseBoolean(attribute1), Boolean.parseBoolean(attribute2), Integer.parseInt(attribute3));
					break;
				case "equipable":
					item = new Equipable(name, weight, value, durability, iD, attribute1, Boolean.parseBoolean(attribute2), attribute3);
					break;
				}
				
				cargohold.add(item);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void saveFile(List<Item> cargohold) {
		Iterator<Item> iter = cargohold.iterator();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("cargohold.txt"))) {
			while (iter.hasNext()) {
				Item temp = iter.next();
				String type = temp.getType();

				String del = "\t";
				bw.write(temp.getName() + del + temp.getWeight() + del + temp.getValue() + del + temp.getDurability()
						+ del + temp.getID() + del + type + del);

				switch (type) {
				case "weapon":
					Weapon w = (Weapon) temp;
					bw.write(w.getDamage() + del + w.getWeaponType() + del + w.isTwoHanded());
					break;
				case "consumable":
					Consumable c = (Consumable) temp;
					bw.write(c.isRechargable() + del + c.isToxic() + del + c.getEffectDuration());
					break;
				case "equipable":
					Equipable e = (Equipable) temp;
					bw.write(e.getBodyPart() + del + e.isClothing() + del + e.getEffect());
					break;
				}
				bw.newLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
