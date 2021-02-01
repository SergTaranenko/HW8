package Homework8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Search {
    public static void main(String[] args) {
        serchFile("text3.txt","Hello");

    }
    public static void serchFile(String fileName, String word){
        try{
            FileInputStream fis = new FileInputStream(fileName);
            int symbol = 0;
            int index = 0;
            byte[] wordBytes = word.getBytes();
            do{
                symbol = fis.read();
                if (wordBytes[index] == symbol){
                    index++;
                    if (index == wordBytes.length){
                        System.out.println("Слово найдено.");
                        break;
                    }
                }else{
                    index = 0;
                }
            }while (symbol != -1);


        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}