public class Srp {
    public static void main(String[] args) {
        
    }
}
// Responsible for single purpose
class Employee{
    private int empId;
    private String name;
    private String email;
    // Only employee related Operations
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
     
}

class  EmployeeRepository {

    public void save(Employee e){
        // data base operations.
    }
}

class NotificationService {
    public void sendMail(String email, String message) {
        // email operations/logic
    }
}
