package finalProject;

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

public class FinalProject {
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		new FinalProject();
	}

	// This will act as our program switchboard
	public FinalProject() {
		ItemLL linkedcargo = new ItemLL();
		
		ItemLL targetShip = new ItemLL();
		
		System.out.println("Welcome to the BlackStar Cargo Hold interface."+ "\n" +"Would you like to load a previously saved file? yes or no");
		String choice = input.nextLine();

		if (choice.equals("yes") && new File("cargohold.txt").isFile()) {
			loadFile(linkedcargo);
		}
		
		System.out.println("\nPlease select a number from the options below");

		while (true) {
			// Give the user a list of their options
			System.out.println("1: Add an item to the cargo hold.");
			System.out.println("2: Remove an item from the cargo hold.");
			System.out.println("3: Sort the contents of the cargo hold.");
			System.out.println("4: Search for an item.");
			System.out.println("5: Display the items in the cargo hold.");
			System.out.println("6: RANSACK THIS SHIP!!!");
			System.out.println("0: Exit the BlackStar Cargo Hold interface.");

			// Get the user input
			int userChoice = input.nextInt();
			input.nextLine();

			switch (userChoice) {
			case 1:
				addItem(linkedcargo);
				break;
			case 2:
				removeItem(linkedcargo);
				break;
			case 3:
				sortItems(linkedcargo);
				break;
			case 4:
				System.out.println(
						"Enter 1 to search by name (full match), 2 to search by name (partial match), and 3 to search by ID: ");
				userChoice = input.nextInt();
				switch (userChoice) {
				case 1:
					searchItems(linkedcargo);
					break;
				case 2:
					partialSearch(linkedcargo);
					break;
				case 3:
					searchItemsById(linkedcargo);
					break;
				}
				break;
			case 5:
				displayItems(linkedcargo);
				break;
			case 6:
				loadRansack(targetShip);
				ransack(linkedcargo, targetShip, linkedcargo.getWeight());
				break;
			case 0:
				System.out.println("Would you like to save changes into file? yes or no");
				choice = input.nextLine();
				if (choice.equals("yes")) {
					saveFile(linkedcargo);
				}
				System.out.println("Thank you for using the BlackStar Cargo Hold interface. See you again soon!");
				System.exit(0);
			}
		}

	}


	private void ransack(ItemLL linkedcargo, ItemLL targetShip, double currentWeight) {
		if (targetShip.size() == 0) {
			return;
		}
		// Identify and remove items that will not fit in our cargohold
		for (int i = 0; i < targetShip.size(); ) {
			if (currentWeight + targetShip.get(i).getWeight() >= 25.0001) {
				targetShip.remove(i);
			} else {
				i++;
			}
		}
		
				
		if (targetShip.size() == 0) {
			return;
		}
		
		// Identify the most valuable item per unit of weight on the target ship
		Item mostValuable = targetShip.get(0);
		int index = 0;
		for (int i = 0; i < targetShip.size(); i++) {
			Item current = targetShip.get(i);
			
			if (current.getValue() / current.getWeight() > mostValuable.getValue() / mostValuable.getWeight()) {
				mostValuable = targetShip.get(i);
				index = i;
			}
		}
		
		// "Borrow" the most valuable item
		linkedcargo.add(mostValuable);
		currentWeight += mostValuable.getWeight();
		targetShip.remove(index);
		
		//Call the method recursively
		ransack(linkedcargo, targetShip, currentWeight);
	}


	private void addItem(ItemLL linkedcargo) {
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

			
		linkedcargo.add(item);
		
	}

	private void removeItem(ItemLL linkedcargo) {
		System.out.println("Enter the name of the item you want to remove from cargohold: ");
		String remove = input.nextLine();

		linkedcargo.remove(remove);
	}

	private void sortItems(ItemLL linkedcargo) {
		
		int count = linkedcargo.size()-1;
		
		while (count >= 0) {
			String smallest = linkedcargo.get(0).getName();
			int index = 0;
			for (int i = 0; i <= count; i++) {
				String current = linkedcargo.get(i).getName();
				if (smallest.compareTo(current) > 0 ) {
					smallest = current;
					index = i;
				}
			}
			
			Item smallestItem = linkedcargo.get(index);
			
			linkedcargo.remove(index);
			
			linkedcargo.add(smallestItem);
			
			count--;
		}
		
	}

	private void searchItems(ItemLL linkedcargo) {
		input.nextLine();
		System.out.println("Enter the name of the item you want to find in cargohold: ");
		String find = input.nextLine();
		int index = linkedcargo.search(find);
		if ( index >= 0) {
			System.out.println("Item " + find + " found in space " + index);
		} else {
			System.out.println(find + " is not found in cargohold");
		}
	}

	private void searchItemsById(ItemLL linkedcargo) {
		System.out.println("Enter the ID of the item you want to find in cargohold: ");
		int find = input.nextInt();
		int index = linkedcargo.searchByID(find);
		
		if ( index >= 0) {
			System.out.println("Item with ID " + find + " found in space " + index);
		} else {
			System.out.println("ID " + find + " is not found in cargohold");
		}
	}

	private void displayItems(ItemLL linkedcargo) {
		ItemLL temp = new ItemLL();
		
		for (int i = 0; i < linkedcargo.size(); i++) {
			temp.add(linkedcargo.get(i));
		}
		
		while (temp.size() > 0) {
			String name = temp.get(0).getName();
			int count = 0;
			for (int i = 0; i < temp.size() ; ) {
				if (name.equals(temp.get(i).getName())) {
					count++;
					temp.remove(i);
				} else {
					i++;
				}
			}
			
			System.out.println(name + " - " + count);
		}
	}

	private void partialSearch(ItemLL linkedcargo) {
		input.nextLine();
		System.out.println("Enter the partial name of the item you want to find in cargohold: ");
		String find = input.nextLine();

		String output = linkedcargo.filter(find);
		
		if (output == null) {
			System.out.println(find + " is not found in cargohold");
		} else {
			System.out.println("Item was found. Full name is: " + output);
		}
	}

	private void loadFile(ItemLL linkedcargo) {
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

				switch (arr[5]) {
				case "weapon":
					item = new Weapon(name, weight, value, durability, iD, Integer.parseInt(attribute1), attribute2,
							Boolean.parseBoolean(attribute3));
					break;
				case "consumable":
					item = new Consumable(name, weight, value, durability, iD, Boolean.parseBoolean(attribute1),
							Boolean.parseBoolean(attribute2), Integer.parseInt(attribute3));
					break;
				case "equipable":
					item = new Equipable(name, weight, value, durability, iD, attribute1,
							Boolean.parseBoolean(attribute2), attribute3);
					break;
				}

				linkedcargo.add(item);

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

	private void saveFile(ItemLL linkedcargo) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("cargohold.txt"))) {
			for (int i = 0; i < linkedcargo.size(); i++) {
				Item temp = linkedcargo.get(i);
				if (temp == null) {
					break;
				}
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
	
	private void loadRansack(ItemLL targetShip) {
		BufferedReader br = null;

		try {
			File file = new File("ransack.txt");
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

				switch (arr[5]) {
				case "weapon":
					item = new Weapon(name, weight, value, durability, iD, Integer.parseInt(attribute1), attribute2,
							Boolean.parseBoolean(attribute3));
					break;
				case "consumable":
					item = new Consumable(name, weight, value, durability, iD, Boolean.parseBoolean(attribute1),
							Boolean.parseBoolean(attribute2), Integer.parseInt(attribute3));
					break;
				case "equipable":
					item = new Equipable(name, weight, value, durability, iD, attribute1,
							Boolean.parseBoolean(attribute2), attribute3);
					break;
				}

				targetShip.add(item);

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
}
