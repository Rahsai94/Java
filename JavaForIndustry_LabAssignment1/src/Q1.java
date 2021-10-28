import java.text.NumberFormat;

public class Q1 {
    public static void main(String[] args) {
        //write your code here to output the employee details
        int employee_id = 12345;
        String employee_name = "Jack Smith";
        int employee_age = 52;
        double salary = 27736.80;
        int yearsToRetirement = 66 - employee_age;;
        double hourlyRate = salary / (35 * 52);


//        For formatting the salary
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(true);

//        Display the Employee Information
        System.out.println("Employee Reference\n——————————————————-");
        System.out.println("ID Number: "+employee_id);
        System.out.println("Name: \""+employee_name+"\"");
        System.out.println("Age: "+employee_age+"\nSalary: "+numberFormat.format(salary));
        System.out.printf("Year of Retirement: "+yearsToRetirement+"\nHourly Rate: %.2f",hourlyRate);

    }
}
