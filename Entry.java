import java.util.*;
import java.io.*;

public class Entry {

    private String play;
    private String actScene;
    private String character;
    private String line;
    
    public Entry() {
            play = "";
            actScene = "";
            character = "Character";
            line = "";
    }
    
    public String getPlay() {
        return play;
    }
    
    public String getActScene() {
        return actScene;
    }
    
    public String getChar() {
        return character;
    }
    
    public String getLine() {
        return line;
    }
    
    public void setPlay(String word) {
        play = word;
    }
    
    public void setActScene(String word) {
        actScene = word;
    }

    public void setChar(String word) {
        character = word;
    }
    
    public void setLine(String val) {
        line = val;
    }
    
    public String toString() {
        return getPlay() + "\n" + getActScene() + "\n" + getChar() + "\n" + getLine();
    }
}