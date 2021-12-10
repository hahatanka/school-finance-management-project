import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    Scanner scanner = new Scanner(System.in);
    Scanner scannerInt = new Scanner(System.in);
    School nyu = new School();


    public static void main(String[] args) {

        //ASSIGNMENT
//CREATE A METHOD IN THE SCHOOL CLASS THAT RETURN THE BALANCE OF THE SCHOOL "getBalance"
//in your main class create a menu that allows to do this:
//1. get all students
//2. get all teachers
//3. add a new teacher(user inputs values for the teacher id, name and salary)
//4. add a new student to the school (user inputs values for the student id, name)
//5.pay all the teachers salary
//6. get total money earned by the school
//7. pay fees for a student with the students ID
// 8. GET THE SCHOOL BALANCE


        Main main = new Main();
        main.Menu();
    }

    void Menu() {
        String userInput = "";
        System.out.println();
        do {
            System.out.println("\nPlease choose what you want to do:");
            System.out.println("1. Add a Teacher");
            System.out.println("2. See all teachers");
            System.out.println("3. Add a STUDENT");
            System.out.println("4. See all students");
            System.out.println("5. Pay salary to all teachers");
            System.out.println("6. Pay fee for a student");
            System.out.println("7. Get total money earned by the school");
            System.out.println("8. Get the school balance");
            System.out.println("\nEnter QUIT to exit the program");

            System.out.println("\nPlease enter a number:");
            userInput = scanner.nextLine().toUpperCase();


            if (userInput.equals("1")) {
                addOneTeacher();
            } else if (userInput.equals("2")) {
                getAllTeachers();
            } else if (userInput.equals("3")) {
                addOneStudent();
            } else if (userInput.equals("4")) {
                getAllStudents();
            } else if (userInput.equals("5")) {
                payTeachersSalary();
            } else if (userInput.equals("6")) {
                payStudentFees();
            } else if (userInput.equals("7")) {
                totalEarned();
            } else if (userInput.equals("8")) {
                getSchoolBalance();
            }
        }
        while (!userInput.equals("Quit"));
        return;
    }

    void addOneTeacher() {

        System.out.println("ADD TEACHER");
        System.out.println("Please enter ID");
        Scanner scannerInt = new Scanner(System.in);
        int id = scannerInt.nextInt();

        System.out.println("Please enter the name: ");
        String name = scanner.nextLine();

        System.out.println("Please enter the salary: ");
        int salary = scannerInt.nextInt();

        Teacher teacher = new Teacher(id, name, salary);
        nyu.addTeacher(teacher);

        System.out.println("New teacher " + teacher.getName() + " added successfully");

    }

    void getAllTeachers() {
        System.out.println("ALL TEACHERS" + "\n------------------------");
        for (Teacher teacher : nyu.getTeachers()) {
            //overriding method
            System.out.println(teacher);

            //common method, more complicated
//            System.out.println("Teacher ID: " + teacher.getId());
//            System.out.println("Name: " + teacher.getName());
//            System.out.println("Salary: " + teacher.getSalary());
//            System.out.println("-----------------------------------");
        }
    }

    void addOneStudent() {

        System.out.println("ADD STUDENT");
        System.out.println("Please enter ID");
        int id = scannerInt.nextInt();

        System.out.println("Please enter the name: ");
        String name = scanner.nextLine();

        System.out.println("Please enter the grade: ");
        int grade = scannerInt.nextInt();

        Student student = new Student(id, name, grade);
        nyu.addStudent(student);

        System.out.println("New student " + student.getName() + " added successfully");

    }

    void getAllStudents() {
        System.out.println("ALL STUDENTS" + "\n------------------------");

        for (Student student : nyu.getStudents()) {
            System.out.println(student);
        }
    }

    void payTeachersSalary() {
        System.out.println("PAY SALARY TO ALL TEACHERS");

        for (Teacher teacher : nyu.getTeachers()) {
            teacher.receiveSalary();
            System.out.println("Teacher " + teacher.getName() + " received " + teacher.salary);
            System.out.println("-----------------------------------");
        }

    }

    void totalEarned() {
        System.out.println("School earned " + nyu.getTotalMoneyEarned());

    }

    void payStudentFees() {
        System.out.println("PAY STUDENT FEE");
        System.out.println("Please enter student ID: ");

        int studentID = scannerInt.nextInt();
        Student student = nyu.findStudentByID(studentID);
        System.out.println("You are about to pay for " + student.getName());


        System.out.println("Please enter the amount paid:");
        int amount = scannerInt.nextInt();
        student.payFees(amount);

        System.out.println("Student " + student.getName() + " paid " + amount);
        System.out.println("Total fees paid by " + student.getName() + student.getFeesPaid());

        }
    void getSchoolBalance () {
         System.out.println("Current balance of the school is " + nyu.getBalance());
            }

}










/*
        //used to show how to call the methods we created

        //initializing an instance of school into a variable "nyu"
        School nyu = new School();// this way we have access to the methods stored in School class
        System.out.println(nyu.getTotalMoneySpent());

        //create some students
        Student karina = new Student(101,"Karina",6);
        Student maija = new Student(102, "Maija", 7);

        System.out.println("Name: " + karina.getName() + "\nGrade: " + karina.getGrade());
        System.out.println("Total fees paid by " + karina.getName() + ":\t" +karina.getFeesPaid());

        //to use methods in a particular class, create an instance of that class and call that method from that instance, e.g. karina.getFeesPaid etc
        karina.payFees(5000);
        System.out.println("Total fees paid by " + karina.getName() + ":\t" +karina.getFeesPaid());
        karina.payFees(4000);
        System.out.println("Total fees paid by " + karina.getName() + ":\t" +karina.getFeesPaid());
        System.out.println("Total fees paid by " + maija.getName() + ":\t" +maija.getFeesPaid());

        //adding karina to school "nyu"
        nyu.addStudent(karina);
        nyu.addStudent(maija);

        //Loops through the arrayList of students returned from nyu.getStudents and prints the student name in the console
        for (Student student: nyu.getStudents()) {
            System.out.println("Student name: " + student.getName());
        }

        maija.payFees(10000);

        System.out.println("Total money earned by NYU is: " + nyu.getTotalMoneyEarned());

        Teacher david = new Teacher(101, "David", 1000);
        Teacher zino = new Teacher(1012, "Zino", 1500);

        david.receiveSalary();
        zino.receiveSalary();

        System.out.println("\nTotal salary received by David is: " + david.getSalaryEarned()) ;
        System.out.println("Total money spent by the school: " + nyu.getTotalMoneySpent());

        System.out.println("\nSchool balance is: " + nyu.getBalance());

    }
}
*/
