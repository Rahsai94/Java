import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {

    private static String[] parameters = new String[12];
    private static LinkedHashMap<Student, HashMap> attendance = new LinkedHashMap<>();

    public static void main(String[] args) {
            readData();
            System.out.println(attendance.toString());
    }



    private static void readData(){

        try{
            Scanner scanner = new Scanner(new FileReader("attendance.csv"));

            
            if(scanner.hasNextLine()){
                String line = scanner.nextLine().trim();
                parameters = line.split(",");
            }

            while (scanner.hasNextLine()){
                String line = scanner.nextLine().trim();
                String[] studentData = line.split(",");
                Student student = new Student(studentData[0],Integer.parseInt(studentData[1]));
                HashMap<String, String> studentAttendance = new HashMap<>();

                int absentAttendance = 0;
                int presentAttendance = 0;
                for(int i = 2; i < parameters.length; i++){
                    studentAttendance.put(parameters[i], studentData[i]);
                    if(studentData[i].equals("A")){
                        absentAttendance++;
                    }else {
                        presentAttendance++;
                    }


                }
                String average = ((presentAttendance)*10)+"%";
                studentAttendance.put("Average",average);

                if(absentAttendance >= 4){
                    System.out.println(student.getIdNumber() + " "+student.getName()+" Has Missed more than 4 classes");
                }

                attendance.put(student, studentAttendance);
            }
        }catch (FileNotFoundException ignored){
            System.out.println("File is not Found");
        }
    }
}
