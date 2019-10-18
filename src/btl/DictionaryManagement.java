package btl;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;

public class DictionaryManagement {
    public static Dictionary dt = new Dictionary();
    public  static void  insertFromCommandline(){
        Scanner sc = new Scanner(System.in);
        int nWord = sc.nextInt();
        sc.nextLine();
        for (int i = 0 ; i < nWord; i++) {
            Word w = new Word();
            String word_target = sc.nextLine();
            w.setWord_target(word_target);
            String word_explain = sc.nextLine();
            w.setWord_explain(word_explain);
            dt.arrWord.add(w);
        }
    }

    public static void showAllWords() {
        System.out.println("-------------------------------------------");
        System.out.println("No \t\t | English \t\t\t    | Vietnamese");
        for (int i = 0; i < dt.arrWord.size(); i++) {
            String showWord = (i + 1) + "\t\t | " + dt.arrWord.get(i).getWord_target();
            for (int j = 0; j < 20 - dt.arrWord.get(i).getWord_target().length(); j++)
                showWord += " ";
            showWord += " | " + dt.arrWord.get(i).getWord_explain();
            System.out.println(showWord);
        }

        System.out.println("-------------------------------------------");
    }

    public static void insertFromFile() {
        File file = new File("dictionaries.txt");
        try(Scanner inFile = new Scanner(file)){
            while(inFile.hasNext()){
                Word w = new Word();
                String wordFile = inFile.nextLine();
                String word_target = wordFile.substring(0,wordFile.indexOf(" "));
                w.setWord_target(word_target);
                String word_explain = wordFile.substring(wordFile.indexOf(" ") + 1);
                w.setWord_explain(word_explain);
                dt.arrWord.add(w);
            }
        } catch (Exception e){
            System.out.println("erorr");
        }
    }

    public static void dictionaryLookup() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[.......] Enter your english word");
        String en = sc.nextLine();
        for (int i = 0; i < dt.arrWord.size() ; i++){
            if (dt.arrWord.get(i).getWord_target().equals(en)){
                String showWord = (i + 1) + "\t\t | " + dt.arrWord.get(i).getWord_target();
                for (int j = 0; j < 20 - dt.arrWord.get(i).getWord_target().length(); j++)
                    showWord += " ";
                showWord += " | " + dt.arrWord.get(i).getWord_explain();
                System.out.println(showWord);
                break;
            }
        }
    }

    public static void dictionaryAdvanced() {
        insertFromFile();
        showAllWords();
        dictionaryLookup();
    }

    public static void dictionaryInsert() {
        Scanner sc = new Scanner(System.in);
        Word w = new Word();
        System.out.println("[..........] Enter your english words ");
        String en = sc.nextLine();
        w.setWord_target(en);
        System.out.println("[..........} Enter your vietnamese words");
        String vn = sc.nextLine();
        w.setWord_explain(vn);
        dt.arrWord.add(w);
        System.out.println("DONE !!!!!!");
    }

    public static void dictionaryRepair() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[.......] Enter your english word");
        String en = sc.nextLine();
        for (int i = 0; i < dt.arrWord.size(); i++) {
            if (dt.arrWord.get(i).getWord_target().equals(en)) {
                String showWord = (i + 1) + "\t\t | " + dt.arrWord.get(i).getWord_target();
                for (int j = 0; j < 20 - dt.arrWord.get(i).getWord_target().length(); j++)
                    showWord += " ";
                showWord += " | " + dt.arrWord.get(i).getWord_explain();
                System.out.println(showWord);
                break;
            }
        }
        System.out.println("[.......] Enter your vietnamese word to repair");
        String vn = sc.nextLine();
        for (int i = 0; i < dt.arrWord.size(); i++) {
            if (dt.arrWord.get(i).getWord_target().equals(en)) {
                dt.arrWord.get(i).setWord_explain(vn);
            }
        }
        System.out.println("Done!!!!!");
    }

    public static void dictionaryDelete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("[.......] Enter your English word to delete");
        String en = sc.nextLine();
        for (int i = 0 ; i < dt.arrWord.size() ; i++){
            if (dt.arrWord.get(i).getWord_target().equals(en)) {
                dt.arrWord.remove(i);
                break;
            }
        }
        System.out.println("Done !!!");
    }

    public static void dictionaryExportToFile(){
        File file = new File("dictionaries.txt");
        try(FileOutputStream fos = new FileOutputStream(file)){
            PrintWriter pw = new PrintWriter(fos);
            for (int i = 0 ; i < dt.arrWord.size() ; i++){
                pw.print(dt.arrWord.get(i).getWord_target());
                pw.print(" ");
                pw.println(dt.arrWord.get(i).getWord_explain());
            }
            pw.close();
        } catch (Exception e){

        }
    }
}
