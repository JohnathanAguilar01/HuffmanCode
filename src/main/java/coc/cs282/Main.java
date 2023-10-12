package coc.cs282;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text;
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Enter a string: ");
        text = sc.nextLine();
        HuffmanCode one = new HuffmanCode();
        one.EncodeTxt(text);
        one.DecodeTxt();
        if (one.decodedText == text){
            System.out.println("sucseccsss");
        }
    }
}