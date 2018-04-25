import java.util.*;
import java.io.*;

public class Driver {
    public static void main (String[] args) throws IOException {
        
        SearchEngine se = new SearchEngine();
        String[] files = {"texts/a_midsummer_nights_dream.txt", "texts/macbeth.txt", "texts/romeo_and_juliet.txt"};
        HashMap<String, ArrayList<Entry>> map = new HashMap<>();
        Scanner scan = new Scanner(System.in);
    
        for(int i = 0; i < 3; i++) {
            map = se.createIndex(map, files[i]);
        }
        
        System.out.println("Welcome to the Shakespearean Index. Please enter a word you wish to look up.");
        
        String word = scan.next();
        
        if(!map.containsKey(word)) {
            System.out.println("That word does not appear in any of the plays.");
        } else {
            se.printIndices(map, word);
        }
    }
}