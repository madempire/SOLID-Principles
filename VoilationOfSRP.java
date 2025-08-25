public class VoilationOfSRP {

    public static void main(String[] args) {
        
    }
}
// This one is monster class handling everything 
// Not belongs to one reponsiblity
class Employee{
    private  int  empId;
    private String name;
    private String email;

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
    
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void updateSalary(int empId){
        // Salary logic
    }

    public void sendMail(){
        // Mail logic
    }

    public void saveToDatabase(){
        // Database logic
    }
}