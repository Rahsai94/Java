
public class Tax {
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public double calculateTax(){

        double tax = 0;

        if (salary >= 50000) {
            double reduced_salary = salary - 50000;
            salary -= reduced_salary;
            tax += reduced_salary * 0.4;
        }

        if (salary >= 30000) {
            double reduced_salary = salary - 30000;
            salary -= reduced_salary;
            tax += reduced_salary * 0.2;
        }

        if (salary >= 15000) {
            double reduced_salary= salary - 15000;
            salary -= reduced_salary;
            tax += reduced_salary * 0.05;
        }

        return tax;
    }
}
