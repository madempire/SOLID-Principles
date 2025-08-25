public class IVoilation{
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

    
// it voilate Interface saggregation principle
interface Workable{
    void work();
    void eat();
    void manage();
}


class Developer implements Workable{

    @Override
    public void work() {
        System.out.println("Developer can work.");
    }

    @Override
    public void eat() {
        System.out.println("Developer can eat.");
    }

    @Override
    public void manage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'manage'");
    }
    
}

class Manager implements Workable{
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

    @Override
    public void eat() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eat'");
    }

    @Override
    public void manage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'manage'");
    }
    
}

