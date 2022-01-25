import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Student {
    //Class Properties Declared
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
        this.userName = generateUsername(name, studentNumber);
    }

    private String generateUsername(String name, int studentNumber) {
        String username = "";
        username += name.charAt(0);
        int index = name.lastIndexOf(" ");
        String sName = name.substring(index + 1);
        if(sName != null){
            if(sName.length() <= 4){
                username += sName;
            }else {
                username += sName.substring(0,4);
            }
        }
        username += (studentNumber+"").substring(0,3);
        return username.toLowerCase();
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
}
