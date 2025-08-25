public class VoilateDip {
    public static void main(String[] args) {
        Mysql sql = new Mysql();
        UserService service = new UserService(sql);
        service.createUser("Anusha");
    }
}
class Mysql {
    void save(String name){
        System.out.println("Save data to Mysql: "+name);
    }
}
// voilate DIP High-level Module Userservice depends on Low-Level module Mysql 
// this make it tightly coupled.
class UserService {
    private Mysql mysql;

    public UserService(Mysql mysql) {
        this.mysql = mysql;
    }
    public void createUser(String name){
        System.out.println("Creating User.....");
        mysql.save(name);
    }
}
