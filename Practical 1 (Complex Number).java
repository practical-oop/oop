// Define the Complex class
class Complex {
    private double real;
    private double imaginary;

    // Default constructor
    public Complex() {
        this.real = 0.0;
        this.imaginary = 0.0;
    }

    // Parameterized constructor
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Method to add two complex numbers
    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    // Method to subtract two complex numbers
    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imaginary - other.imaginary);
    }

    // Method to multiply two complex numbers
    public Complex multiply(Complex other) {
        double realPart = (this.real * other.real) - (this.imaginary * other.imaginary);
        double imaginaryPart = (this.real * other.imaginary) + (this.imaginary * other.real);
        return new Complex(realPart, imaginaryPart);
    }

    // Method to display the complex number
    public void display() {
        if (imaginary >= 0) {
            System.out.println(real + " + " + imaginary + "i");
        } else {
            System.out.println(real + " - " + Math.abs(imaginary) + "i");
        }
    }
}

// Main class to test the Complex class
public class ComplexOperations {
    public static void main(String[] args) {
        // Create two complex numbers
        Complex num1 = new Complex(3, 2);
        Complex num2 = new Complex(1, 4);

        // Perform addition
        Complex sum = num1.add(num2);
        System.out.print("Sum: ");
        sum.display();

        // Perform subtraction
        Complex difference = num1.subtract(num2);
        System.out.print("Difference: ");
        difference.display();

        // Perform multiplication
        Complex product = num1.multiply(num2);
        System.out.print("Product: ");
        product.display();
    }
}
