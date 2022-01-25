import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class StudentMain {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {


        Student student = new Student("Bert Smith", "Computing", 22, 12345, true);
        student.grades.add(new Grade("programming", 52));
        student.grades.add(new Grade("web dev", 63));
        student.grades.add(new Grade("maths", 76));
        student.grades.add(new Grade("algorithm", 68));
        students.add(student);

        student = new Student("Olivia Green", "Computing", 19, 23464, true);
        student.grades.add(new Grade("programming", 73));
        student.grades.add(new Grade("web dev", 82));
        student.grades.add(new Grade("maths", 72));
        student.grades.add(new Grade("algorithm", 66));
        students.add(student);

        student = new Student("Eloise Jones", "Computing", 18, 34744, true);
        student.grades.add(new Grade("programming", 65));
        student.grades.add(new Grade("web dev", 63));
        student.grades.add(new Grade("maths", 37));
        student.grades.add(new Grade("algorithm", 40));
        students.add(student);

        student = new Student("Ben Bird", "Computing", 42, 34834, true);
        student.grades.add(new Grade("programming", 55));
        student.grades.add(new Grade("web dev", 29));
        student.grades.add(new Grade("maths", 56));
        student.grades.add(new Grade("algorithm", 38));
        students.add(student);

        student = new Student("Karen Brown", "Computing", 25, 45632, true);
        student.grades.add(new Grade("programming", 62));
        student.grades.add(new Grade("web dev", 51));
        student.grades.add(new Grade("maths", 43));
        student.grades.add(new Grade("algorithm", 43));
        students.add(student);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Report of All Student\n2. Failed Student\n3.Average Grade\n4. Add Student\n5.Quit");

            try{
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("Report of all students");
                        for (int i = 0; i < students.size(); i++) {
                            System.out.println("Name = " + students.get(i).getName() +
                                    "\nUsername = " + students.get(i).getUserName() +
                                    "\nAge = " + students.get(i).getAge() +
                                    "\nDepartment = " + students.get(i).getDepartment() +
                                    "\nStudent number = " + students.get(i).getStudentNumber()
                                    + "\n\n"
                            );
                        }
                        break;
                    case 2:
                        System.out.println("Report of all students with a failed module");
                        for(Student stu: students){
                            System.out.println("Name of Student: "+stu.getName());
                            int c = 0;
                            for(Grade grade: stu.grades){
                                if(Grade.getLetterGrade(grade.getScore()) == 'F'){
                                    System.out.println(grade.getSubject());
                                    c++;
                                }
                            }
                            if(c == 0){
                                System.out.println("There is no Failed Modules");
                            }
                            System.out.println("\n");
                        }
                        break;
                    case 3:
                        System.out.println("Report of the average of students' grade");
                        for (int i = 0; i < students.size(); i++) {
                            int currentAverage = 0;
                            for(int h = 0; h < students.get(i).grades.size(); h++){
                                currentAverage += students.get(i).grades.get(h).getScore();
                            }

                            System.out.println(students.get(i).getName() + ": " + currentAverage/students.get(i).grades.size()+"\n");
                        }
                        break;
                    case 4:
                        System.out.println("Add a new student to the system");
                        System.out.println("Name");
                        Scanner scanner2 = new Scanner(System.in);

                        String name = scanner2.nextLine();

                        System.out.println("department");
                        String department = scanner2.nextLine();

                        System.out.println("age");
                        int age = scanner2.nextInt();

                        System.out.println("studnet number");
                        int studentNumber = scanner2.nextInt();

                        System.out.println("is full time?");
                        boolean fullTime = scanner2.nextBoolean();
                        Student tempStudent= new Student(name, department, age, studentNumber, fullTime);


                        System.out.println("--- Enter Grades ---");

                        System.out.println("Programming: ");
                        float programming = scanner2.nextFloat();
                        tempStudent.grades.add(new Grade("programming", programming));

                        System.out.println("Web Developemnt: ");
                        float webDev = scanner2.nextFloat();
                        tempStudent.grades.add(new Grade("web dev", webDev));

                        System.out.println("Math: ");
                        float math = scanner2.nextFloat();
                        tempStudent.grades.add(new Grade("maths", math));

                        System.out.println("Algorithms: ");
                        float algo = scanner2.nextFloat();
                        tempStudent.grades.add(new Grade("algorithms", algo));

                        students.add(tempStudent);

                        System.out.println(students.get(students.size() - 1).getName());
                        break;
                    case 5:
                        System.out.println("Exit");
                        return;
                    default:
                        System.out.println("Wrong Choice");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid Input");
                break;
            }
        }

    }
}
