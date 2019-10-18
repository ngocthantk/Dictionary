package btl;

import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.lang.String;

public class DictionaryCommandline extends DictionaryManagement{

    public static void dictionaryBasic() {
        insertFromCommandline();
        showAllWords();
    }

    public static void dictionarySearcher() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[.........] Enter your English word to seach ");
        String scWord = sc.nextLine();
        int count = 1;
        System.out.println("No \t\t | English \t\t\t    | Vietnamese");
        for (int i = 0 ; i < dt.arrWord.size() ; i++){
            if (dt.arrWord.get(i).getWord_target().length() < scWord.length()){
                continue;
            }
            if (dt.arrWord.get(i).getWord_target().substring(0,scWord.length()).equals(scWord)){
                String inWord = count + "\t\t | " + dt.arrWord.get(i).getWord_target();
                for (int k = 0; k < 20 - dt.arrWord.get(i).getWord_target().length(); k++){
                    inWord += " ";
                }
                inWord += "\t| " + dt.arrWord.get(i).getWord_explain();
                System.out.println(inWord);
                count++;
            }
        }
    }
}
