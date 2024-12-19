import java.util.Scanner;

// Base Employee class
class Employee {
    Scanner sc = new Scanner(System.in);
    String emp_name;
    String address;
    String mail_id;
    long mobile_no;
    int emp_id;
    double basic_pay;
    static int id = 10000;
    double net_salary, gross_salary;
    double hra, da, pf, staff_club_fund;

    // Constructor
    Employee() {
        id++;
    }

    // Common input method
    void input() {
        System.out.print("Enter the name of Employee: ");
        emp_name = sc.nextLine();
        emp_id = id;
        System.out.print("Enter Address: ");
        address = sc.nextLine();
        System.out.print("Enter Mobile No.: ");
        mobile_no = sc.nextLong();
        sc.nextLine(); // Consume the newline
    }

    // Common display method
    void display() {
        System.out.println("EMP NAME: " + emp_name + "\tID: " + emp_id + "\tADDRESS: " + address + "\tMOBILE: " + mobile_no);
    }

    // Common salary calculation
    void salary() {
        da = basic_pay * 0.97;
        hra = basic_pay * 0.10;
        pf = basic_pay * 0.12;
        staff_club_fund = basic_pay * 0.001;
        gross_salary = basic_pay + hra;
        net_salary = gross_salary - pf - staff_club_fund;
    }

    // Display salary slip
    void salarySlip() {
        System.out.println("BASIC PAY: " + basic_pay);
        System.out.println("HRA: " + hra);
        System.out.println("PF: " + pf);
        System.out.println("GROSS SALARY: " + gross_salary);
        System.out.println("NET SALARY: " + net_salary);
    }
}

// Programmer class inherits from Employee
class Programmer extends Employee {
    void readProgrammer() {
        input();
        boolean valid = false;
        while (!valid) {
            System.out.print("BASIC PAY [30000-40000]: ");
            basic_pay = sc.nextDouble();
            if (basic_pay < 30000 || basic_pay > 40000) {
                System.out.println("BASIC PAY FOR PROGRAMMER MUST BE BETWEEN 30000 - 40000.");
            } else {
                valid = true;
            }
        }
    }

    static void search(Programmer[] arr, int key) {
        for (Programmer p : arr) {
            if (p.emp_id == key) {
                System.out.println("Employee Found:");
                p.display();
                p.salarySlip();
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}

// Teamlead class inherits from Employee
class Teamlead extends Employee {
    void readTeamlead() {
        input();
        boolean valid = false;
        while (!valid) {
            System.out.print("BASIC PAY [40000-50000]: ");
            basic_pay = sc.nextDouble();
            if (basic_pay < 40000 || basic_pay > 50000) {
                System.out.println("BASIC PAY FOR TEAMLEAD MUST BE BETWEEN 40000 - 50000.");
            } else {
                valid = true;
            }
        }
    }

    static void search(Teamlead[] arr, int key) {
        for (Teamlead t : arr) {
            if (t.emp_id == key) {
                System.out.println("Employee Found:");
                t.display();
                t.salarySlip();
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}

// Assistant Project Manager inherits from Employee
class AsstProManager extends Employee {
    void readAsstProManager() {
        input();
        boolean valid = false;
        while (!valid) {
            System.out.print("BASIC PAY [50000-60000]: ");
            basic_pay = sc.nextDouble();
            if (basic_pay < 50000 || basic_pay > 60000) {
                System.out.println("BASIC PAY FOR ASSISTANT PROJECT MANAGER MUST BE BETWEEN 50000 - 60000.");
            } else {
                valid = true;
            }
        }
    }

    static void search(AsstProManager[] arr, int key) {
        for (AsstProManager apm : arr) {
            if (apm.emp_id == key) {
                System.out.println("Employee Found:");
                apm.display();
                apm.salarySlip();
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}

// Project Manager inherits from Employee
class ProManager extends Employee {
    void readProManager() {
        input();
        boolean valid = false;
        while (!valid) {
            System.out.print("BASIC PAY [60000-70000]: ");
            basic_pay = sc.nextDouble();
            if (basic_pay < 60000 || basic_pay > 70000) {
                System.out.println("BASIC PAY FOR PROJECT MANAGER MUST BE BETWEEN 60000 - 70000.");
            } else {
                valid = true;
            }
        }
    }

    static void search(ProManager[] arr, int key) {
        for (ProManager pm : arr) {
            if (pm.emp_id == key) {
                System.out.println("Employee Found:");
                pm.display();
                pm.salarySlip();
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}

// Main class to drive the program
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Programmer[] programmers = new Programmer[3];
        Teamlead[] teamleads = new Teamlead[3];
        AsstProManager[] asstManagers = new AsstProManager[2];
        ProManager[] proManagers = new ProManager[1];

        while (true) {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Add Programmer");
            System.out.println("2. Add Teamlead");
            System.out.println("3. Add Assistant Project Manager");
            System.out.println("4. Add Project Manager");
            System.out.println("5. Search Employee");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // Input data for programmers
                    for (int i = 0; i < 3; i++) {
                        programmers[i] = new Programmer();
                        programmers[i].readProgrammer();
                        programmers[i].salary();
                    }
                    break;
                case 2:
                    // Input data for teamleads
                    for (int i = 0; i < 3; i++) {
                        teamleads[i] = new Teamlead();
                        teamleads[i].readTeamlead();
                        teamleads[i].salary();
                    }
                    break;
                case 3:
                    // Input data for Assistant Project Managers
                    for (int i = 0; i < 2; i++) {
                        asstManagers[i] = new AsstProManager();
                        asstManagers[i].readAsstProManager();
                        asstManagers[i].salary();
                    }
                    break;
                case 4:
                    // Input data for Project Managers
                    for (int i = 0; i < 1; i++) {
                        proManagers[i] = new ProManager();
                        proManagers[i].readProManager();
                        proManagers[i].salary();
                    }
                    break;
                case 5:
                    // Search employee
                    System.out.print("Enter Employee ID to search: ");
                    int id = sc.nextInt();
                    System.out.println("Searching in Programmers...");
                    for (Programmer p : programmers) {
                        if (p != null && p.emp_id == id) {
                            p.display();
                            p.salarySlip();
                            break;
                        }
                    }
                    System.out.println("Searching in Teamleads...");
                    for (Teamlead t : teamleads) {
                        if (t != null && t.emp_id == id) {
                            t.display();
                            t.salarySlip();
                            break;
                        }
                    }
                    System.out.println("Searching in Assistant Project Managers...");
                    for (AsstProManager apm : asstManagers) {
                        if (apm != null && apm.emp_id == id) {
                            apm.display();
                            apm.salarySlip();
                            break;
                        }
                    }
                    System.out.println("Searching in Project Managers...");
                    for (ProManager pm : proManagers) {
                        if (pm != null && pm.emp_id == id) {
                            pm.display();
                            pm.salarySlip();
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
