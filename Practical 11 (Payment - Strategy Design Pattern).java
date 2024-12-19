// PaymentStrategy.java
interface PaymentStrategy {
    void pay(int amount);
}

// CreditCardPayment.java
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Credit Card.");
    }
}

// PayPalPayment.java
class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal.");
    }
}

// BitcoinPayment.java
class BitcoinPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Bitcoin.");
    }
}

// ShoppingCart.java
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // Constructor that accepts a PaymentStrategy
    public ShoppingCart(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Method to change payment strategy
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Execute the payment strategy
    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

// StrategyPatternDemo.java
public class Main {
    public static void main(String[] args) {
        // Create ShoppingCart with CreditCardPayment strategy
        ShoppingCart cart = new ShoppingCart(new CreditCardPayment());
        cart.checkout(100);  // Output: 100 paid using Credit Card.

        // Change strategy to PayPalPayment
        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(200);  // Output: 200 paid using PayPal.

        // Change strategy to BitcoinPayment
        cart.setPaymentStrategy(new BitcoinPayment());
        cart.checkout(300);  // Output: 300 paid using Bitcoin.
    }
}
