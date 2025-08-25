public class Ocp_Follow {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment(new CreditCardPayment(), 100);
    }
}
// to add new payment method we only need to do extension // create new payment method by implementind PaymentMethod interface
interface PaymentMethod{
    void processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit card payment: "+amount);
    }
    
}

class PaypalPaymentMethod implements PaymentMethod {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Paypal payment: "+amount);
    }
    
}

// to add new payment method no need to modify the processPayment method
class PaymentProcessor {
    void processPayment(PaymentMethod paymentMethod, double amount){
        paymentMethod.processPayment(amount);
    }
}

