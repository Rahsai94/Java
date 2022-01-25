import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMain {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Student s = new Student("Bert Smith", "Computing", 22, 12345, true);
        s.grades.add(new Grade("programming", 52));
        s.grades.add(new Grade("web dev", 63));
        s.grades.add(new Grade("maths", 76));
        s.grades.add(new Grade("algorithm", 68));
        students.add(s);

        Student s01 = new Student("Olivia Green", "Computing", 19, 23464, true);
        s01.grades.add(new Grade("programming", 73));
        s01.grades.add(new Grade("web dev", 82));
        s01.grades.add(new Grade("maths", 72));
        s01.grades.add(new Grade("algorithm", 66));
        students.add(s01);

        Student s02 = new Student("Eloise Jones", "Computing", 18, 34744, true);
        s02.grades.add(new Grade("programming", 65));
        s02.grades.add(new Grade("web dev", 63));
        s02.grades.add(new Grade("maths", 37));
        s02.grades.add(new Grade("algorithm", 40));
        students.add(s02);

        Student s03 = new Student("Ben Bird", "Computing", 42, 34834, true);
        s03.grades.add(new Grade("programming", 55));
        s03.grades.add(new Grade("web dev", 29));
        s03.grades.add(new Grade("maths", 56));
        s03.grades.add(new Grade("algorithm", 38));
        students.add(s03);

        Student s04 = new Student("Karen Brown", "Computing", 25, 45632, true);
        s04.grades.add(new Grade("programming", 62));
        s04.grades.add(new Grade("web dev", 51));
        s04.grades.add(new Grade("maths", 43));
        s04.grades.add(new Grade("algorithm", 43));
        students.add(s04);


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Report of All Student\n2. Failed Student\n3.Average Grade\n4. Add Student\n5.Quit");

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
                    for (int i = 0; i < students.size(); i++) {
                        boolean hasFailed = false;
                        for (int j = 0; j < students.get(i).grades.size(); j++){
                            if (Grade.getLetterGrade(students.get(i).grades.get(j).getScore()) == 'F') {
                                hasFailed = true;
                                break;
                            }
                        }

                        if (hasFailed) {
                            System.out.println("Name = " + students.get(i).getName() +
                                    "\nUsername = " + students.get(i).getUserName() +
                                    "\nAge = " + students.get(i).getAge() +
                                    "\nDepartment = " + students.get(i).getDepartment() +
                                    "\nStudent number = " + students.get(i).getStudentNumber() +
                                    "\n\n");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Report of the average of students' grade");
                    for (int i = 0; i < students.size(); i++) {
                        int currentAverage = 0;
                        for(int h = 0; h < students.get(i).grades.size(); h++){
                            currentAverage += students.get(i).grades.get(h).getScore();
                        }

                        System.out.println(students.get(i).getName() + ": " + currentAverage);
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
                    Student student = new Student(name, department, age, studentNumber, fullTime);

                    students.add(student);

                    System.out.println(students.get(students.size() - 1).getName());
                    break;
                case 5:
                    System.out.println("Quitting");
                    return;
                default:
                    System.out.println();
            }
        }
    }
}
