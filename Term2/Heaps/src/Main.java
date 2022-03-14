import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {

        Heap hp = new Heap(86241);
        for(int j = 0; j < 86241; j++){
            hp.insert(j);
        }
        System.out.println(hp.counter-1);


        List<Integer> source = new ArrayList<>(86241);
        for(int j = 0; j < 86241; j++){
            source.add(j);
        }

        Heap h = new Heap(source);
        System.out.println(h.counter);

    }
}
