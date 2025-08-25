# SOLID Principles
## 1. SRP Single Responsibility Principle.
    Class should have only one responsibility to change.
    Voilation of SRP:-
    class Employee{
        private String name;
        private String email;

        public void updateSalary(int empId){
            /* salary logic*/
        }
        public void sendMail(){
            /*Mail logic*/
        }
        public void saveToDatabase(){
            /* data base logic */
        }
    }
    Follow SRP:-
    class Employee {
        private String name;
        private String email;
        // Only employee-related operations
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
    public class EmployeeRepository {
        public void save(Employee employee) { /* database operations */ }
    }

    public class NotificationService {
        public void sendEmail(String email, String message) { /* email logic */ }
    }
### Advantage:-
    1. Easy to understand(Single Purpose)
    2. Super Easy testing.
    3. Change One thing break nothing.
    4. Reusable classes.
    5. Team can work parallel.
    6. Easy to extend.
    7. Minimal Dependencies.
    8. Pro code quality


## 2. Open/Closed Principle.
    Software entities should be open for extension but closed for modification.

    voilate OCP:-
    class PaymentProcessor{
        // to add new payment method you have to modify below method
        public void processPayment(String paymentType, double amount){
            switch(paymentType){
                case "CREDIT_CARD" -> sout("processing credit card payment : $"+amount);
                case "PAYPAL" -> sout("processing paypal payment : "+amount);
                default -> sout("Payment type not supported");
            }
        }
        psvm(String[] args){
            PaymentProcessor processor = new PaymentProcessor();
            processor.processPayment("CREDIT_CARD",1652.0);
            processor.processPayment("PAYPAL",1652.0);
        }
    }
    Follow OCP:-
    public class OCPFollow {
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
## 3. Liskov Substitution Principles:-
    Lsp states that you must be able to replace super class object with a subclass object without affecting the correctness of the program.
    Ex:- public class Lsp {
        // Client code demonstrating substitutability
        public static void letBirdMove(Bird bird){
            bird.move();
        }
        public static void main(String[] args) {
            Bird pigeon = new Pigeon();
            Bird penguine = new Penguine();
            // Both work interchangeably via base type Bird
            letBirdMove(pigeon);
            letBirdMove(penguine);
        }
    }
    interface Bird{
        void move();
    }
    interface FlyingBird extends Bird{
        void fly();
    }
    interface SwimingBird extends Bird{
        void swim();
    }
    // Penguin subclass that cannot fly but can swim
    class Penguine implements SwimingBird{

        @Override
        public void move() {
            swim();
        }

        @Override
        public void swim() {
            System.out.println("Penguine can move by swimming");
        }
    }
    // pigeon subclass that can fly
    class Pigeon implements FlyingBird{

        @Override
        public void move() {
            fly();
        }

        @Override
        public void fly() {
            System.out.println("Pigeon can move by flying");
        }    
    }

## 4. Interface Saggregation:- 
    According to the interface segregation principle, you should build small, focused interfaces that do not force the client to implement behavior they do not need.
    EX:- 
    public class InterfaceSag {
    public static void main(String[] args) {
        Developer developer = new Developer();
        developer.eat();
        developer.work();
        Manager m = new Manager();
        m.eat();
        m.work();
        m.manage();
        Robot r = new Robot();
        r.work(); 
        }
    }
    interface Eatable{
        void eat();
    }
    interface Workable{
        void work();
    }
    interface Manageable{
        void manage();
    }

    class Developer implements Eatable,Workable{

        @Override
        public void work() {
            System.out.println("Developer can work.");
        }

        @Override
        public void eat() {
            System.out.println("Developer can eat.");
        }
        
    }

    class Manager implements Manageable, Eatable, Workable{
        @Override
        public void eat() {
            System.out.println("Manager can eat.");
        }

        @Override
        public void work() {
            System.out.println("Manager can work.");
        }

        @Override
        public void manage() {
            System.out.println("Manager can manage.");
        }

    }

    class Robot implements Workable{

        @Override
        public void work() {
            System.out.println("Robot can work.");
        }
        
    }
## 5. Dependency Inversion Principle:-
    in DIP, high level modules should not depend on low level modules. in other words, you must follow abstraction and ensure loose coupling.
    Ex:-
    public class DependencyInversion {
    public static void main(String[] args) {
        // Inject Mysql db implementation
        Database mysql = new MySql();
        UserService service = new UserService(mysql);
        service.createUser("Yash");

        // Inject postgresql db implementation
        Database postgresql = new Postgresql();
        UserService service1 = new UserService(postgresql);
        service1.createUser("Allu"); 
        }
    }
    // High-level module depends on abstraction, not concrete classes

    // Abstraction: Database interface
    interface Database {
        void save(String data);
    }
    // Low-level module: MySQL implementation
    class MySql implements Database{

        @Override
        public void save(String data) {
            System.out.println("Saving data to the mysql db: "+data);
        }
        
    }
    // Low-level module: Postgresql implementation
    class Postgresql implements Database{

        @Override
        public void save(String data) {
            System.out.println("Saving data to the postgresql db: "+data);
        }
        
    }
    // High-level: UserService depends on Database abstraction
    class UserService{
        private Database database;
        // Depency injection via constructor
        public UserService(Database database) {
            this.database = database;
        }
        public void createUser(String name){
            System.out.println("Creating user: "+name);
        }
    }



