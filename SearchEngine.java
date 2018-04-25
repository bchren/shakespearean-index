import java.util.*;
import java.io.*;

public class SearchEngine {

    public HashMap<String, ArrayList<Entry>> createIndex(HashMap<String, ArrayList<Entry>> map, String inFile) throws IOException {
        
        Scanner file = new Scanner(new File(inFile));
        String title = file.nextLine();
        String curAct = "";
        String curScene = "";
        String speaker = "";
        
        while(file.hasNextLine()) {
            
            String raw = file.nextLine();
            String[] rawWords = raw.split("\\s+");
            String[] speakerLine = raw.split("\t");
            String line = raw.replaceAll("\t", " ");
            line = line.replaceAll("[^a-zA-Z | ']", "");
            line = line.toLowerCase();
            String[] words = line.split(" ");
            
            if(raw.contains("PROLOGUE")) {
                curAct = "Prologue";
                curScene = "";
            }
            if(raw.contains("ACT")) {
                curAct = "Act " + rawWords[1].toUpperCase() + ", ";
            }
            if(raw.contains("SCENE")) {
                curScene = "Scene " + rawWords[1].toUpperCase();
            }
            if(raw.contains("\t") && raw.charAt(0) != '\t') {
                speaker = speakerLine[0];
            }
            
            raw = raw.trim();

            for(int w = 0; w < words.length; w++) {
                
                if(words[w].length() > 3) {
                    if(!map.containsKey(words[w])) {
                        ArrayList<Entry> list = new ArrayList<Entry>();
                        Entry e = new Entry();
                        e.setPlay(title);
                        e.setActScene(curAct + "" + curScene);
                        e.setChar(speaker);
                        e.setLine(raw);
                        list.add(e);
                        map.put(words[w], list);
                    } else {
                        Entry e = new Entry();
                        e.setPlay(title);
                        e.setActScene(curAct + "" + curScene);
                        e.setChar(speaker);
                        e.setLine(raw);
                        map.get(words[w]).add(e);
                        map.put(words[w], map.get(words[w]));
                    }
                }
            }
        }
        return map;
    }


    public void printIndices(HashMap<String, ArrayList<Entry>> map, String key) {
        
        ArrayList<Entry> list = new ArrayList<Entry>();
        list = map.get(key);
        for(int i = 0; i < list.size(); i++) {
            System.out.println("Index " + (i+1) + ":");
            System.out.println(list.get(i).toString());
            System.out.println("--------------------");
        }
    }
}