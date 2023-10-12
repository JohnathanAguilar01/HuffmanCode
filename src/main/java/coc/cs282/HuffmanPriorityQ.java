/* Code adopted from Advanced Data Structures by Robert Lafore */
package coc.cs282;

public class HuffmanPriorityQ {
    //  Todo: Declare the array to store the queue data
    HuffmanNode data[];
    
    //  Todo: Declare the variables to maintain the queue
    int numValidValues;
    
    //  Todo: Implement the constructor
    public HuffmanPriorityQ(int maxSize) {
        data = new HuffmanNode[maxSize];
        numValidValues = 0;
    }

    //  Todo: insert the passed value in the queue
    public void insert(HuffmanNode item) {
        if (isFull()) {
            throw new IndexOutOfBoundsException();
        }
        
        int i;
        for(i=numValidValues-1; i >= 0; i--) {
            if (data[i].frequency < item.frequency) {
                data[i+1] = data[i];
            } else {
                break;
            }
        }
        
        data[i+1] = item;
        numValidValues++;
    }

    //  Todo: Remove the minimum item
    public HuffmanNode remove() {
        if (numValidValues == 0) {
            throw new IndexOutOfBoundsException();
        }
                
        return data[--numValidValues];
    }

    //  Todo: return the minimum item without removing
    public HuffmanNode peekMin() {
        if (numValidValues == 0) {
            throw new IndexOutOfBoundsException();
        }
        
        return data[numValidValues - 1];
    }

    // Todo: Implement
    public boolean isEmpty() {
        if (numValidValues == 0) {
            return true;
        } else {
            return false;
        }
    }
    // Todo: Implement
    public boolean isFull() {
        return numValidValues == data.length;
    }

}
