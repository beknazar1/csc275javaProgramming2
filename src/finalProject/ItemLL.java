package finalProject;

public class ItemLL {
	private Node head;
	private Node tail;
	protected int size = 0;
	public double weight = 0.0;

	public ItemLL() {
		head = null;
		tail = null;
	}
	
	public int size() {
		return size;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public Item get(int index) {
		Node current;
		
		current = head;
		int count = 0;
		
		while (current != null) {
			if (count == index) {
				break;
			}
			count++;
			current = current.next;
		}
		
		if (current != null) {
			return current.item;
		} else {
			return null;
		}
		
		
	}

	public void add(Item item) {
		Node newNode = new Node(item);
		if ((getWeight() + item.getWeight()) > 25.0001) {
			System.out.println("Not enough capacity in cargohold. Item was not added");
			return;
		}
		
		if (tail == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = tail.next;
		}
		
		size++;
		
		weight += item.getWeight();
		System.out.println("Item " + item.getName() + " added to cargohold");
	}
	
	public int search(String itemName) {
		Node p = head;
		int count = 0;
		
		while (p != null) {
			if (p.item.getName().equalsIgnoreCase(itemName)) {
				break;
			}
			count++;
			p = p.next;
		}
		
		if (p != null) {
			return count;
		} else {
			return -1;
		}
	}
	
	public int searchByID(int ID) {
		Node p = head;
		int count = 0;
		
		while (p != null) {
			if (p.item.getID() == ID) {
				break;
			}
			count++;
			p = p.next;
		}
		
		if (p != null) {
			return count;
		} else {
			return -1;
		}
	}
	
	
	public String filter(String itemName) {
		Node p = head;
		int count = 0;
		
		while (p != null) {
			if (p.item.getName().toLowerCase().contains(itemName)) {
				break;
			}
			count++;
			p = p.next;
		}
		
		if (p != null) {
			return p.item.getName();
		} else {
			return null;
		}
	}
	
	public void remove(String itemName) {
		if (size == 0) {
			System.out.println("List is empty. Nothing to remove");
			return;
		}
		
		int index = search(itemName);
		remove(index);
		
	}
	

	public void remove(int index) {
		if (index < 0) {
			System.out.println("Item was not found in cargohold");
			return;
		}
		else if (size == 1 && index == 0) {
			head = tail = null;
			weight = 0.0;
			size = 0;
			return;
		} else {
		Node prev, del;
		del = head;
		prev = null;
		int count = 0;
		while (count < index) {
			prev = del;
			del = del.next;
			count++;
		}
		
		if (del==head) {
			weight -= head.item.getWeight();
			head = head.next;
		} else if (index + 1 == size) {
			weight -= tail.item.getWeight();
			tail = prev;
			tail.next = null;
		} else {
			weight -= del.item.getWeight();
			prev.next = del.next;
		}
		size--;
		}
	}

}
