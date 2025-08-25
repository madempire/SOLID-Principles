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
