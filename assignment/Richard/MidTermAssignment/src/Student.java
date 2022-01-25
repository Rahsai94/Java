import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Student {

    private String name;
    private String department;
    private int age;
    private String userName;
    private int studentNumber;
    private boolean fullTime;

    public List<Grade> grades = new ArrayList<>();

    public Student(String name, String department, int age, int studentNumber, boolean fullTime) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.studentNumber = studentNumber;
        this.fullTime = fullTime;
        this.userName = userName(name, studentNumber);
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

    private String userName(String name, int studentNumber){
        String uname = name.charAt(0)+"";
        int in = name.lastIndexOf(" ");
        String lastName = name.substring(in+1);
        if(lastName != null){
            if(lastName.length() <= 4){
                uname += lastName;
            }else {
                uname += lastName.substring(0,4);
            }
        }
        uname += (studentNumber+"").substring(0,3);
        return uname.toLowerCase();
    }
}
