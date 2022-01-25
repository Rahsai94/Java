import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Felix");
        arrayList.add("Tom");
        arrayList.add("CrookShanks");



        arrayList.add(1, "Salem");

        System.out.println(arrayList.toString());
        System.out.println(arrayList.get(2));
    }
}
