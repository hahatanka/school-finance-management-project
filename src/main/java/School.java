import java.util.ArrayList;

public class School {
    public ArrayList<Teacher> teachers;
    public ArrayList<Student> students;
    private static int totalMoneyEarned;
    private static int totalMoneySpent;

    School() {
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        totalMoneySpent = 0;
        totalMoneyEarned = 0;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Student findStudentByID(int studentId) {
        for (Student student : students)
            if (studentId == student.getId()) {
                return student;
            }
        return null;
    }



    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    //Method adding a teacher to the list of teachers
    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    //method for adding students
    public void addStudent(Student student) {
        this.students.add(student);
    }

    //update total money earned
    //a static keyword indicates that the member belongs to the type inself and not the instance of that type
    //only one instance of the static member is created which is shared among all instances of a class
    //to call a static method you use
    public static void updateTotalMoneyEarned(int moneyEarned) {
        totalMoneyEarned += moneyEarned;
    }

    //update total money spent
    public static void updateTotalMoneySpent(int moneySpent) {
        totalMoneySpent += moneySpent;
    }

    //get balance
    public int getBalance() {
        return totalMoneyEarned - totalMoneySpent;
    }


}


