package coc.cs282;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text;
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Enter a string: ");
        text = sc.nextLine();
        HuffmanCode one = new HuffmanCode();
        System.out.println("Encoded Message:");
        one.EncodeTxt(text);
        System.out.println("Decoded Message:");
        one.DecodeTxt();
    }
}