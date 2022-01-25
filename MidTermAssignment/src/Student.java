import java.util.ArrayList;
import java.util.Locale;

public class Student {

//    Declare the Class properties of Student
    private String name;
    private String department;
    private int age;
    private String userName;
    private int studentNumber;
    private boolean fullTime;

    public ArrayList<Grade> grades = new ArrayList<Grade>();


//    Define the Parameter constructor of Student
    public Student(String name, String department, int age,  int studentNumber, boolean fullTime) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.studentNumber = studentNumber;
        this.fullTime = fullTime;
        this.userName = generateUsername(name, studentNumber);
    }



//
    private String generateUsername(String name, int studentNumber){

        String userName = "";

        userName += name.charAt(0)+"";

        int  index = name.lastIndexOf(' ');

        String lname = name.substring(index + 1);

        if(lname != null){
            if(lname.length() <= 4){
                userName += lname;
            }else {
                userName += lname.substring(0, 4);
            }
        }

        userName += (studentNumber+"").substring(0,3);

        return userName.toLowerCase(Locale.ROOT);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", userName='" + userName + '\'' +
                ", studentNumber=" + studentNumber +
                ", fullTime=" + fullTime +
                ", grades=" + grades.toString() +
                '}';
    }
}
