import java.util.*;

interface Vehicle {
    void gearChange(int gear);
    void speedUp();
    void applyBrakes();
    void display();
}

// Bicycle Class
class Bicycle implements Vehicle {
    int gear = 1, speed = 10;

    public Bicycle() {
        System.out.println("\tBicycle started.");
    }

    public void gearChange(int gear) {
        if (gear > 0 && gear < 7) {
            this.gear = gear;
            System.out.println("\tGear changed to: " + gear);
        } else {
            System.out.println("Invalid gear.");
        }
    }

    public void speedUp() {
        if (speed + 5 <= 50) {
            speed += 5;
            System.out.println("\tSpeed: " + speed + " km/h");
        } else {
            System.out.println("Speed limit exceeded.");
        }
    }

    public void applyBrakes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Decrease speed\n2. Stop");
        int choice = sc.nextInt();
        if (choice == 1) {
            if (speed - 5 >= 0) {
                speed -= 5;
                System.out.println("Speed: " + speed);
            } else {
                stop();
            }
        } else if (choice == 2) {
            stop();
        }
    }

    public void stop() {
        speed = 0;
        gear = 0;
        System.out.println("Bicycle stopped.");
    }

    public void display() {
        System.out.println("Bicycle speed: " + speed + " km/h, Gear: " + gear);
    }
}

// Car Class
class Car implements Vehicle {
    int gear = 1, speed = 10;

    public Car() {
        System.out.println("\tCar started.");
    }

    public void gearChange(int gear) {
        if (gear > 0 && gear < 7) {
            this.gear = gear;
            System.out.println("\tGear changed to: " + gear);
        } else {
            System.out.println("Invalid gear.");
        }
    }

    public void speedUp() {
        if (speed + 20 <= 150) {
            speed += 20;
            System.out.println("\tSpeed: " + speed + " km/h");
        } else {
            System.out.println("Speed limit exceeded.");
        }
    }

    public void applyBrakes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Decrease speed\n2. Stop");
        int choice = sc.nextInt();
        if (choice == 1) {
            if (speed - 20 >= 0) {
                speed -= 20;
                System.out.println("Speed: " + speed);
            } else {
                stop();
            }
        } else if (choice == 2) {
            stop();
        }
    }

    public void stop() {
        speed = 0;
        gear = 0;
        System.out.println("Car stopped.");
    }

    public void display() {
        System.out.println("Car speed: " + speed + " km/h, Gear: " + gear);
    }
}

// Bike Class
class Bike implements Vehicle {
    int gear = 1, speed = 10;

    public Bike() {
        System.out.println("\tBike started.");
    }

    public void gearChange(int gear) {
        if (gear > 0 && gear < 6) {
            this.gear = gear;
            System.out.println("\tGear changed to: " + gear);
        } else {
            System.out.println("Invalid gear.");
        }
    }

    public void speedUp() {
        if (speed + 20 <= 100) {
            speed += 20;
            System.out.println("\tSpeed: " + speed + " km/h");
        } else {
            System.out.println("Speed limit exceeded.");
        }
    }

    public void applyBrakes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Decrease speed\n2. Stop");
        int choice = sc.nextInt();
        if (choice == 1) {
            if (speed - 20 >= 0) {
                speed -= 20;
                System.out.println("Speed: " + speed);
            } else {
                stop();
            }
        } else if (choice == 2) {
            stop();
        }
    }

    public void stop() {
        speed = 0;
        gear = 0;
        System.out.println("Bike stopped.");
    }

    public void display() {
        System.out.println("Bike speed: " + speed + " km/h, Gear: " + gear);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicle vehicle = null;

        while (true) {
            System.out.println("Select Vehicle:\n1. Bicycle\n2. Car\n3. Bike\n4. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                vehicle = new Bicycle();
            } else if (choice == 2) {
                vehicle = new Car();
            } else if (choice == 3) {
                vehicle = new Bike();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice.");
                continue;
            }

            while (true) {
                System.out.println("\n1. Speed Up\n2. Change Gear\n3. Apply Brakes\n4. Display Status\n5. Switch Vehicle");
                int action = sc.nextInt();

                switch (action) {
                    case 1: vehicle.speedUp(); break;
                    case 2: 
                        System.out.print("Enter gear: ");
                        int gear = sc.nextInt();
                        vehicle.gearChange(gear);
                        break;
                    case 3: vehicle.applyBrakes(); break;
                    case 4: vehicle.display(); break;
                    case 5: break;
                    default: System.out.println("Invalid input."); break;
                }

                if (action == 5) break;
            }
        }
    }
}
