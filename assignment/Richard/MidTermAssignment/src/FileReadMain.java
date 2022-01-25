import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FileReadMain {

    private static  File freqFile = new File("frequencies.txt");

    static {

        try{

            if(freqFile.exists()){
                freqFile.delete();
                freqFile.createNewFile();
            }else {
                freqFile.createNewFile();
            }

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    private static List<String> totalWords = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        File f = new File("Metamorphosis.txt");

        printStats(f);
    }
    private static void printStats(File f) throws IOException {

        String line;
        int characters = 0;
        int words = 0;
        int sentences = 0;
        int paragraphs = 0;

        //Scanner scanner =  new Scanner(new FileInputStream(new File("Metamorphosis.txt")));

        Scanner scanner = new Scanner(new FileReader("Metamorphosis.txt"));

        try{
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                if (line.equals("")){
                    paragraphs ++;
                } else {
                    characters += line.length();

                    String[] wordsArr = line.split("\\s");
                    words += wordsArr.length;

                    for (int i = 0; i < wordsArr.length; i++) {
                        totalWords.add(wordsArr[i]);
                    }

                    String[] sen = line.split("[:.?!]+");
                    sentences += sen.length;

                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        if(paragraphs != 0){
            paragraphs++;
        }

        System.out.println(characters);
        System.out.println(paragraphs);
        System.out.println(sentences);
        System.out.println(words);

        Counter<String> counter = new Counter<>();
        for(String s: totalWords){
            counter.count(s);
        }

        counter.printGFre(totalWords);





    }
}



class Counter<T> {

    FileWriter fileWriter = new FileWriter("frequencies.txt", true);

    private final HashMap<T, Integer> map = new HashMap<>();

    Counter() throws IOException {
    }

    public int get(T key){
        final Integer n = map.get(key);
        return n == null ? 0 : n;
    }

    public void count(T key){
        map.put(key, get(key)+1);
    }

    public void printGFre(List<String> l) throws IOException {
        for(String s: l){
            System.out.println(s + "  :  "+map.get(s));
            fileWriter.write(s + "  :  "+map.get(s)+"\n");
        }
    }
}
