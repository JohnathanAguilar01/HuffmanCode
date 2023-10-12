package coc.cs282;

public class HuffmanCode {
    int asciiFrequency[];
    int charAmount;
    HuffmanTree tree;
    String encodedText;
    String[] codeTable = new String[256];
    String x;


    public void GetFrequency(String txt){
        asciiFrequency = new int[256];
        charAmount = 0;

        for (int i = 0; i < txt.length(); i++){
            if(asciiFrequency[txt.charAt(i)]++ == 0){
              charAmount++;
            }
        }
    }

    public void encode(){
        HuffmanPriorityQ que = new HuffmanPriorityQ(charAmount);

        for (int i = 0; i < 256; i++) {
            if (asciiFrequency[i] != 0) {
                HuffmanNode x = new HuffmanNode(asciiFrequency[i], (char) i);
                que.insert(x);
            }
        }
        tree = new HuffmanTree(que);
        MakeCodeTable(tree.root, x);
    }
    public void MakeCodeTable(HuffmanNode node, String code) {

        if (node == null){
            return;
        }
        if(node.rightChild == null && node.leftChild == null){
            codeTable[node.asciiCode - 1] = code;
        }
        if(code == null){
            code = "0";
        }else {
            code = code + "0";
        }
        MakeCodeTable(node.leftChild, code);
        code = code.substring(0, code.length() - 1);
        if(code == null){
            code = "1";
        }else {
            code = code + "1";
        }
        MakeCodeTable(node.rightChild, code);
        code = code.substring(0, code.length() - 1);

    }
    public void EncodeString(String txt){
        encodedText = codeTable[txt.charAt(0) - 1];

        for(int i = 0; i < txt.length(); i++){
            encodedText = encodedText + codeTable[txt.charAt(1) - 1];
        }

    }
    public void DecodeString(String encodedText){

    }
}
