import java.util.ArrayList;

public class Teacher {
    private int id;
    private String name;
    public int salary;
    private int salaryEarned;


    //Define constructor for Teacher to create a new teacher object on initialization with the provided values

    Teacher(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;

    }
    //Methods for setting and getting
    //method to set a salary for the teacher
    public void setSalary(int salary){
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    //shortcut for getter/setter method "cmd + N"
    public void receiveSalary() {
        salaryEarned += salary;
        School.updateTotalMoneySpent(salary);

    }

    public int getSalaryEarned() {
        return salaryEarned;
    }

    public String toString(){
        return "Teacher ID: " + id +
                "\nName: " + name +
                "\nSalary: " + salary +
                "\n--------------------------------";
    }




}



