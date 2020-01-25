import java.io.File;
import java.util.*;

public class Main {

    static Map<String, Integer> dict = new HashMap<>();

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        try {
            findFrequencies(args[0]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }

        System.out.printf("Time elapsed: %d milliseconds",
                System.currentTimeMillis() - start);

        /*for (Map.Entry<String, Integer> entry : dict.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }*/

    }

    public static void findFrequencies(String filepath) throws Exception {

        Scanner reader = new Scanner(new File(filepath));

        String word;
        while (reader.hasNext() && !(word =
            reader.next().toLowerCase()).isEmpty()) {

            try {
                int freq = dict.get(word);
                dict.put(word, freq + 1);
            } catch (Exception e) {
                dict.put(word, 1);
            }
        }
    }
}
