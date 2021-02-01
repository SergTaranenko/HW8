package Homework8;


import java.io.*;
import java.util.Random;

public class Main {
       static String ABC = "book";
       static Random rnd = new Random();

    public static void main(String[] args) throws IOException {
        InputStream in;
        OutputStream out;

        String s = "Hello world!";
        FileOutputStream text1 = new FileOutputStream("text1.txt", true);
        for (int i = 0; i < 8; i++) {
            text1.write(s.getBytes());
        }
        text1.close();
        createFile("text2.txt",createString(100));
        glueFiles (new String[]{"text1.txt","text2.txt"},"text3.txt");
    }
    public static void glueFiles(String[] names, String distinationName){
        try{
            FileOutputStream fos = new FileOutputStream(distinationName);
            for (String name: names){
                FileInputStream fis = new FileInputStream(name);
                int i;
                do {
                    i = fis.read();
                    if(i != -1){
                        fos.write(i);
                    }
                }while (i != -1);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String createString(int len){
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++){
            sb.append(ABC.charAt(rnd.nextInt(ABC.length())));
        }
        return sb.toString();
    }

    public static void createFile(String fileName, String text){
        try{
            PrintWriter pw = new PrintWriter(fileName);
            pw.write(text);
            pw.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }


}
