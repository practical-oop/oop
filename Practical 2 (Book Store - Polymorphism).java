import java.util.Scanner;

// Base Class: Publication
class Publication {
	// Title of the publication
	private String title;
	// Price of the publication
	protected double price;
	// Copies of the publication
	private int copies;

	// Getter and Setter for title
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// Getter and Setter for price
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		} else {
			System.out.println("Invalid price");
		}
	}

	// Getter and Setter for copies
	public int getCopies() {
		return this.copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	// Method to calculate sales
	public void sellCopy(int qty) {
		System.out.println("Total Publication sell: $" + (qty * price));
	}
}

// Subclass: Book
class Book extends Publication {
	// Author of the book
	private String author;

	// Getter and Setter for author
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	// Method to order copies
	public void orderCopies(int pCopies) {
		setCopies(getCopies() + pCopies);
	}

	// Overridden sellCopy method
	@Override
	public void sellCopy(int qty) {
		System.out.println("Total Book sell: $" + (qty * getPrice()));
	}
}

// Subclass: Magazine
class Magazine extends Publication {
	// Specific attributes for Magazine
	private int orderQty;
	private String currIssue;

	// Getter and Setter for current issue
	public String getCurrIssue() {
		return this.currIssue;
	}

	public void setCurrIssue(String issue) {
		this.currIssue = issue;
	}

	// Getter and Setter for order quantity
	public int getOrderQty() {
		return this.orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	// Overridden sellCopy method
	@Override
	public void sellCopy(int qty) {
		System.out.println("Total Magazine sell: $" + (qty * getPrice()));
	}

	// Method to receive a new issue
	public void recvNewIssue(String pNewIssue) {
		setCopies(orderQty);
		currIssue = pNewIssue;
	}
}

// Main Class
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Choose an operation:");
		System.out.println("1. Work with Book");
		System.out.println("2. Work with Publication (Polymorphism)");
		System.out.println("3. Work with Magazine");
		System.out.print("Enter your choice (1-3): ");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1: // Work with Book
			Book obj1 = new Book();
			scanner.nextLine(); // Consume leftover newline
			System.out.print("Enter Book Title: ");
			obj1.setTitle(scanner.nextLine());
			System.out.print("Enter Author: ");
			obj1.setAuthor(scanner.nextLine());
			System.out.print("Enter Price: ");
			obj1.setPrice(scanner.nextDouble());
			System.out.print("Enter Copies Available: ");
			obj1.setCopies(scanner.nextInt());
			System.out.print("Enter Copies to Order: ");
			int bookOrderCopies = scanner.nextInt();
			obj1.orderCopies(bookOrderCopies);
			System.out.print("Enter Copies to Sell: ");
			int bookSellCopies = scanner.nextInt();
			obj1.sellCopy(bookSellCopies);
			break;

		case 2: // Work with Publication (Polymorphism)
			Publication obj2 = new Book();
			scanner.nextLine(); // Consume leftover newline
			System.out.print("Enter Publication Title: ");
			obj2.setTitle(scanner.nextLine());
			System.out.print("Enter Price: ");
			obj2.setPrice(scanner.nextDouble());
			System.out.print("Enter Copies Available: ");
			obj2.setCopies(scanner.nextInt());
			System.out.print("Enter Copies to Sell: ");
			int pubSellCopies = scanner.nextInt();
			obj2.sellCopy(pubSellCopies); // Overridden method invoked
			break;

		case 3: // Work with Magazine
			Magazine obj3 = new Magazine();
			scanner.nextLine(); // Consume leftover newline
			System.out.print("Enter Magazine Title: ");
			obj3.setTitle(scanner.nextLine());
			System.out.print("Enter Current Issue: ");
			obj3.setCurrIssue(scanner.nextLine());
			System.out.print("Enter Price: ");
			obj3.setPrice(scanner.nextDouble());
			System.out.print("Enter Copies Available: ");
			obj3.setCopies(scanner.nextInt());
			System.out.print("Enter Order Quantity: ");
			int magOrderQty = scanner.nextInt();
			obj3.setOrderQty(magOrderQty);
			scanner.nextLine(); // Consume leftover newline
			System.out.print("Enter New Issue Name: ");
			String newIssue = scanner.nextLine();
			obj3.recvNewIssue(newIssue);
			System.out.print("Enter Copies to Sell: ");
			int magSellCopies = scanner.nextInt();
			obj3.sellCopy(magSellCopies);
			break;

		default:
			System.out.println("Invalid choice! Please select 1, 2, or 3.");
		}

		scanner.close();
	}
}

