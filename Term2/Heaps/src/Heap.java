import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



class Heap {

    LinkedList<Integer> aa = new LinkedList<>();


    // public for JUnit testing purposes
    public ArrayList<Integer> array;
    public int heap_size;
    public int counter = 0;
    public Heap(int size) {
        // It creates the array for a heap of size n and updates the variable heap_size
        this.heap_size = size;
        this.array = new ArrayList<>(size);
        counter++;
        for (int i = 0; i < 200; i++) {
            aa.add(i);
        }
        System.out.println(aa);
    }

    public Heap(List<Integer> source) {
        this(source, false);
    }

    public Heap(List<Integer> source, boolean incremental){

        this.array = new ArrayList<>(source.size());
        this.heap_size = 0;

        if(incremental){
            heap_size = 0;
            for (int i = 0; i < source.size(); i ++){
                this.insert(source.get(i));
                counter++;
            }
            heap_size = array.size();
        }else{
            heap_size = 0;
            this.array = new ArrayList<Integer>(source.size());

            for (int i = 0; i < source.size(); i ++){
                array.add(source.get(i));
                counter++;
            }
            buildMaxHeap();
            heap_size = array.size();

        }
    }

    public static int parent(int index) {
        return (index-1)/2;
    }

    public static int left(int index) {
        return (2*index)+1;
    }

    public static int right(int index) {
        return (2*index)+2;
    }

    public void maxHeapify(int i) {
        int largest = i;
        int l = left(i);
        int r = right(i);


        if(l < this.heap_size && this.array.get(l) > this.array.get(largest)){
            largest = l;
        }

        if(r < this.heap_size && array.get(r) > array.get(largest)){
            largest = r;
        }

        if (largest != i) {
            int temp = array.get(i);
            array.set(i, array.get(largest));
            array.set(largest, temp);
            maxHeapify(largest);
            counter+=2;
        }

    }

    public void buildMaxHeap() {
        heap_size = array.size();
        int midpoint = array.size()/2;
        for(int j = midpoint; j >= 0; j--){
            maxHeapify(j);
        }
    }

    public void insert(Integer k) {
        array.add(k);
        counter++;

        int i = array.size()-1;
        int p = parent(i);

        while (i > 0 && array.get(i) > array.get(p)){
            counter++;
            int temp = array.get(i);
            array.set(i, array.get(p));
            array.set(p, temp);
            i = p;
            p = parent(i);
        }
//        while (pos > 0 && array.get(parent(pos)) < array.get(pos)) {
//            int temp = array.get(parent(pos));
//            int temp2 = array.get(pos);
//            array.set(temp, temp2);
//            array.set(temp2, temp);
//            pos = parent(pos);
//        }
    }

    public Integer maximum() {

        if(array.size() == 0){
            return  -1;
        }else {
            return array.get(0);
        }
//        int largest = array.get(0);
//        int result = 0;
//
//        for (int n = 0; n < heap_size; n++) {
//            if (array.get(n) > largest) {
//                result = n;
//            }
//        }
//
//        return result;
    }

    public Integer extractMax() {
        int max = array.get(0);
        array.set(0, array.get(array.size()-1));
        heap_size--;
        maxHeapify(0);
        return max;
    }



     public ArrayList<Integer> sort(){
        buildMaxHeap();
        for(int i = array.size()-1; i >= 0; i--){
            int temp = array.get(0);
            array.set(0, array.get(i));
            array.set(i, temp);
            heap_size--;
            maxHeapify(0);
        }
        return array;
     }
    public int INDEX_LARGEST_NODE(int i) {
        int largest = array.get(i+1);
        int result = i;

        for (int n = i+1; n < heap_size; n++) {
            if (array.get(n) > largest) {
                result = n;
            }
        }

        return result;
    }
}
