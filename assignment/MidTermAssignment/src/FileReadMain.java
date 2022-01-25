
import java.io.*;
import java.util.*;


public class FileReadMain {
    //Name of OutputFile
    private static final String FILE_LOGGER_NAME =  "frequencies.txt";

    private static File inputFile = new File("Metamorphosis.txt");

    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(inputFile);
            File outputFile = new File(FILE_LOGGER_NAME);
            if(outputFile.createNewFile()){
                System.out.println("Output File Created "+FILE_LOGGER_NAME);
            }else {
                outputFile.delete();
                outputFile.createNewFile();
                System.out.println("Output File Created "+FILE_LOGGER_NAME);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Main Function
    public static void main(String[] args){
        fileStatistics(scanner);
        calculateWordFrequency();
    }

    // Check the statistics of given text file
    private static void fileStatistics(Scanner scanner){
        String line;
        int wordCount = 0;
        int characterCount = 0;
        int paragraphCount = 0;
        int sentenceCount = 0;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.equals("")) {
                paragraphCount += 1;
            }
            else {
                characterCount += line.length();
                String[] words = line.split(" ");
                wordCount += words.length;
                String[] sentences = line.split("[!.?:]+");
                sentenceCount += sentences.length;
            }
        }

        if (sentenceCount != 0) {
            paragraphCount++;
        }

        System.out.println("********************************");
        System.out.println("Total word count = "+ wordCount+"\nTotal number of sentences = "+ sentenceCount+"\nTotal number of characters = "+ characterCount+"\nNumber of paragraphs = "+ paragraphCount);
    }


    // Calculate the frequency of words
    private static void calculateWordFrequency(){

        //Creates an Hash Map for storing the words and its count
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        String line;
        String words[] = null;
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Metamorphosis.txt"));
            while ((line = reader.readLine()) != null){
                line = line.toLowerCase();
                words = line.split("\\s");
                for (String read : words) {
                    String[] str = read.split("[’.!?]+");
                    if(str.length > 1){
                        Integer freq = wordCount.get(str[0]);
                        wordCount.put(str[0], (freq == null) ? 1 : freq + 1); //For Each word the count
                    }else {
                        Integer freq = wordCount.get(read);
                        wordCount.put(read, (freq == null) ? 1 : freq + 1); //For Each word the count
                    }
                }
            }
            reader.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Remove the curly Brackets and spaces
        String[] a = wordCount.toString().split("[{}]");
        String[] totalCount = Arrays.toString(a).split(" ");


        String[] strArr = new String[totalCount.length-2];
        int[] freqArr = new int[totalCount.length-2];


        //Write Word on new line
        for (int i = 2; i < totalCount.length; i++) {
            writeData(totalCount[i]+"\n");

            strArr[i-2] = totalCount[i].split("[=]")[0];
            freqArr[i-2] = Integer.parseInt(totalCount[i].replaceAll("\\D+",""));
//            System.out.println(strArr[i-2]);
//            System.out.println(freqArr[i-2]);
        }

        //Print HuffManCode
        Huffman huffman = new Huffman(strArr, freqArr);
        huffman.huffmanCode();







    }



    // Static Function to write Data into File
    private static void writeData(String data){
        try{
            FileWriter fileWriter = new FileWriter(FILE_LOGGER_NAME, true);

            fileWriter.write(data);

            fileWriter.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



}

