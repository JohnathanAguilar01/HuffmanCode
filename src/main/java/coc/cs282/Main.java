package coc.cs282;

public class Main {
    public static void main(String[] args) {
        String text;
        text = "hello world";
        HuffmanCode one = new HuffmanCode();
        one.GetFrequency(text);
        one.encode();
        //one.tree.print();
        one.EncodeString(text);
        System.out.println(one.encodedText);


    }
}