/* Code adopted from Advanced Data Structures by Robert Lafore */
package coc.cs282;

public class HuffmanNode {
    int frequency;
    char data;
    int asciiCode;
    HuffmanNode leftChild;
    HuffmanNode rightChild;
    
    public HuffmanNode(int frequency, char data) {
        this.frequency = frequency;
        this.data = data;
        this.asciiCode = (int)data;
    }
    
    public int getKey() {
        return frequency;
    }
    
    public void display() {
        System.out.println("[" + frequency + ", " + data + "]");
    }
}
