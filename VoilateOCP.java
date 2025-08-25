public class VoilateOCP {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment("CREDIT_CARD", 100);
        processor.processPayment("PAYPAL", 10.0);
    }
}
class PaymentProcessor{
    // to add new payment method we should need to modify processPayment method and logic
    public void processPayment(String paymentType, double amount){
        switch (paymentType) {
            case "CREDIT_CARD" -> System.out.println("Credit card payment processing : $"+amount);
            case "PAYPAL" -> System.out.println("Paypal payment processing : $"+amount);
            default -> System.out.println("Payment Type is not supported");
        }
    }
}
