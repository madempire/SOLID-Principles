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