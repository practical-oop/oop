import java.util.Scanner;

abstract class shape {

	private double dimen1, dimen2;

	double getDimen1() {
		return dimen1;
	}

	double getDimen2() {
		return dimen2;
	}

	shape() {}

	shape(double a, double b) {
		dimen1 = a;
		dimen2 = b;
	}

	abstract double compute_area();

	void read() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ENTER FIRST DIMENSION: ");
		dimen1 = sc.nextDouble();
		System.out.print("ENTER SECOND DIMENSION: ");
		dimen2 = sc.nextDouble();
	}
}
class triangle extends shape {

	double area;

	triangle() {}

	triangle(double base, double height) {
		super(base, height);
	}

	@Override
	double compute_area() {
		area = (getDimen1() * getDimen2()) / 2;
		return area;
	}
}

class rectangle extends shape {

	double area;

	rectangle() {}

	rectangle(double length, double breadth) {
		super(length, breadth);
	}

	@Override
	double compute_area() {
		area = (getDimen1() * getDimen2());
		return area;
	}
}

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int x;
		shape s;

		do {
			System.out.print("\n\t  MENU\n\t1.Triangle\n\t2.Rectangle \n\t3.Exit\n\tChoice ::");
			x = sc.nextInt();
			System.out.println();

			switch(x) {
			case 1:
				double a, b;
				System.out.print("ENTER BASE OF TRIANGLE: ");
				a = sc.nextDouble();
				System.out.print("ENTER HEIGHT OF TRIANGLE: ");
				b = sc.nextDouble();

				triangle t = new triangle(a, b);
				s = t;
				System.out.println("AREA OF TRIANGLE IS: " + s.compute_area());
				System.out.println("=======================================================");
				break;

			case 2:
				rectangle r = new rectangle();
				s = r;
				s.read();
				System.out.println("AREA OF RECTANGLE IS: " + s.compute_area());
				System.out.println("=======================================================");
				break;

			case 3:
				System.out.println("EXITED SUCCESSFULLY");
				System.out.println("=======================================================");
				break;

			default:  // Invalid input
				System.out.println("INVALID INPUT");
				System.out.println("=======================================================");
			}
		} while (x != 3);

		sc.close();
	}
}
