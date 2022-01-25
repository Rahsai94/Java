import java.io.FileReader;
import java.util.*;

public class CollectionExample {

    private  String[] files = {"catFemale.txt","catMale.txt","dogFemale.txt","dogMale.text"};
    // Set of the
    ArrayList<HashSet> names = new ArrayList<>();

    

    public TreeSet<String> mergeCatsName(){
        TreeSet<String> cats = new TreeSet<String>(names.get(0));
        cats.addAll(names.get(1));
        return cats;
    }

//    public TreeSet<String> mergeDogsName(){
//        TreeSet<String> dogs = new TreeSet<>(names.get(2));
//
//
//    }
    public  CollectionExample(){
        try{

            for (int i = 0; i < files.length; i++) {
                Scanner scanner = new Scanner(new FileReader(files[i]));
                HashSet<String> treeSet = new HashSet<>();
                while (scanner.hasNextLine()){
                    String line = scanner.nextLine().trim();
                    treeSet.add(line);
                }
                names.add(treeSet);

            }

        }catch (Exception ignored){

        }

        System.out.println(names.toString());
    }
    public static void main(String[] args) {
            CollectionExample collectionExample = new CollectionExample();
            System.out.println(collectionExample.mergeCatsName().toString());
    }
}
