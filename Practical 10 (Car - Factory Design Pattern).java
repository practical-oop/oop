// Abstract Car class
abstract class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    // Steps in car building process
    public void allocateAccessories() {
        System.out.println(name + ": Allocating accessories.");
    }

    public void assembleBody() {
        System.out.println(name + ": Assembling the body.");
    }

    public void paintCar() {
        System.out.println(name + ": Painting the car.");
    }

    public void finalMakeup() {
        System.out.println(name + ": Final makeup and polishing.");
    }

    // Template method for car production
    public void buildCar() {
        allocateAccessories();
        assembleBody();
        paintCar();
        finalMakeup();
    }
}

// Hatchback subclass
class Hatchback extends Car {
    public Hatchback() {
        super("Hatchback");
    }
}

// Sedan subclass
class Sedan extends Car {
    public Sedan() {
        super("Sedan");
    }
}

// SUV subclass
class SUV extends Car {
    public SUV() {
        super("SUV");
    }
}

// Factory class to produce cars
class CarFactory {
    public static Car createCar(String carType) {
        switch (carType.toLowerCase()) {
            case "hatchback":
                return new Hatchback();
            case "sedan":
                return new Sedan();
            case "suv":
                return new SUV();
            default:
                throw new IllegalArgumentException("Unknown car type: " + carType);
        }
    }
}

// Testing the Factory Pattern
public class Main {
    public static void main(String[] args) {
        // Create cars using the factory
        Car hatchback = CarFactory.createCar("hatchback");
        Car sedan = CarFactory.createCar("sedan");
        Car suv = CarFactory.createCar("suv");

        // Build cars
        System.out.println("\nBuilding a Hatchback:");
        hatchback.buildCar();

        System.out.println("\nBuilding a Sedan:");
        sedan.buildCar();

        System.out.println("\nBuilding an SUV:");
        suv.buildCar();
    }
}
