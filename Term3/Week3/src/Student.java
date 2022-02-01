public class Student {
    private String  name;
    private int  idNumber;

    public Student(String name, int idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }


    @Override
    public String toString() {
        return "\n\n Student: " +
                "name: '" + name + '\'' +
                ", idNumber: " + idNumber+"\n";
    }

}
