package btl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        DictionaryCommandline dc = new DictionaryCommandline();
        dc.insertFromFile();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("0. Exit");
            System.out.println("1. Tra cứu");
            System.out.println("2. Thêm từ vào từ điển");
            System.out.println("3. Sửa nghĩa");
            System.out.println("4. Xóa từ trong từ điển");
            System.out.println("5. In ra từ điển");
            int choice = sc.nextInt();
            if (choice == 1){
                dc.dictionarySearcher();
            }
            else if (choice == 2){
                dc.dictionaryInsert();
                dc.dictionaryExportToFile();
            }

            else if (choice == 3){
                dc.dictionaryRepair();
                dc.dictionaryExportToFile();
            }
            else if (choice == 4){
                dc.dictionaryDelete();
                dc.dictionaryExportToFile();
            }
            else if (choice == 5){
                dc.showAllWords();
            }
            else if (choice == 0)
                break;
        }
    }
}
