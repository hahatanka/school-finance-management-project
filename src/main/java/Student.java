public class Student {
    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private int totalFees;

    //Create Student constructor to create a new student object with the provided values when initializing
    //Each students school fees is 30 000usd
    Student(int id, String name, int grade){
    this.id = id;
    this.name = name;
    this.grade = grade;
    this.feesPaid = 0;
    totalFees = 30000;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    public void payFees(int feeToPay){
        //Add fees to the total amount of fees paid every time the method is called
        //"this" keyword refers to the current object
       this.feesPaid += feeToPay; // equals to this.feesPaid = this.feesPaid + feeToPay;
         School.updateTotalMoneyEarned(feeToPay);
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int getId() {
        return id;
    }


    //returns the total fees paid by current student
    public int getFeesPaid() {
        return feesPaid;
    }

    public int getTotalFees() {
        return totalFees;
    }

    public String toString() {
        return "Student ID: " + id +
        "\nName: " + name +
        "\nGrade: " + grade +
        "\n--------------------------------";
    }

    //+=
//    public static void main(String[] args) {
//        int num = 4;
//        num += 2; //will add 2 to initial value. Result 6
//    }
}
