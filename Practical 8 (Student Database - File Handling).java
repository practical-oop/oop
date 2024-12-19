import java.io.*;
import java.util.*;

class Database {
    private static final String FILE_NAME = "students.txt";
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public void addRecords() throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME, true)))) {
            while (true) {
                System.out.print("\nEnter Student Name: ");
                String studentName = BR.readLine();
                System.out.print("Student Id: ");
                int studentId = Integer.parseInt(BR.readLine());
                System.out.print("Roll No: ");
                int rollNo = Integer.parseInt(BR.readLine());
                System.out.print("Address: ");
                String address = BR.readLine();
                System.out.print("Class: ");
                int studentClass = Integer.parseInt(BR.readLine());
                System.out.print("Marks: ");
                float marks = Float.parseFloat(BR.readLine());

                pw.println(studentName + " " + studentId + " " + rollNo + " " + address + " " + studentClass + " " + marks);
                System.out.print("\nRecord added successfully!\nDo you want to add more? (y/n): ");
                if (!BR.readLine().equalsIgnoreCase("y")) break;
            }
        }
    }

    public void displayRecords() throws IOException {
        try (BufferedReader file = new BufferedReader(new FileReader(FILE_NAME))) {
            String record;
            System.out.println("\nRecords in the database:");
            while ((record = file.readLine()) != null) {
                System.out.println(record);
            }
        } catch (FileNotFoundException e) {
            System.out.println("\nERROR: File not found!");
        }
    }

    public void searchRecords() throws IOException {
        System.out.print("Enter the Student ID to search: ");
        String searchId = BR.readLine();
        boolean found = false;

        try (BufferedReader file = new BufferedReader(new FileReader(FILE_NAME))) {
            String record;
            while ((record = file.readLine()) != null) {
                if (record.contains(" " + searchId + " ")) {
                    System.out.println("Record Found:\n" + record);
                    found = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("\nERROR: File not found!");
        }

        if (!found) {
            System.out.println("Record not found.");
        }
    }

    public void deleteRecords() throws IOException {
        System.out.print("Enter the Student ID to delete: ");
        String deleteId = BR.readLine();
        boolean found = false;

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        try (BufferedReader file = new BufferedReader(new FileReader(inputFile));
             PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(tempFile)))) {
            String record;
            while ((record = file.readLine()) != null) {
                if (record.contains(" " + deleteId + " ")) {
                    found = true;
                } else {
                    pw.println(record);
                }
            }
        }

        if (found) {
            if (inputFile.delete() && tempFile.renameTo(inputFile)) {
                System.out.println("Record deleted successfully!");
            } else {
                System.out.println("Error during deletion.");
            }
        } else {
            tempFile.delete();
            System.out.println("Record not found.");
        }
    }

    public void updateRecords() throws IOException {
        System.out.print("Enter the Student ID to update: ");
        String updateId = BR.readLine();
        boolean found = false;

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        try (BufferedReader file = new BufferedReader(new FileReader(inputFile));
             PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(tempFile)))) {
            String record;
            while ((record = file.readLine()) != null) {
                if (record.contains(" " + updateId + " ")) {
                    System.out.print("Enter updated marks: ");
                    String newMarks = BR.readLine();
                    String[] parts = record.split(" ");
                    parts[5] = newMarks;
                    pw.println(String.join(" ", parts));
                    found = true;
                } else {
                    pw.println(record);
                }
            }
        }

        if (found) {
            if (inputFile.delete() && tempFile.renameTo(inputFile)) {
                System.out.println("Record updated successfully!");
            } else {
                System.out.println("Error during update.");
            }
        } else {
            tempFile.delete();
            System.out.println("Record not found.");
        }
    }

    public void clearDatabase() throws IOException {
        new PrintWriter(FILE_NAME).close();
        System.out.println("All records cleared successfully!");
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Database db = new Database();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Records");
            System.out.println("2. Display Records");
            System.out.println("3. Search Records");
            System.out.println("4. Delete Records");
            System.out.println("5. Update Records");
            System.out.println("6. Clear All Records");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: db.addRecords();break;
                case 2: db.displayRecords();break;
                case 3: db.searchRecords();break;
                case 4: db.deleteRecords();break;
                case 5: db.updateRecords();break;
                case 6: db.clearDatabase();break;
                case 7: {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
