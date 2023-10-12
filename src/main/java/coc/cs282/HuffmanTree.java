package coc.cs282;

public class HuffmanTree {
    HuffmanPriorityQ que;
    HuffmanNode root;
    HuffmanTree(HuffmanPriorityQ item){
        que = item;
        this.MakeTree();
    }

    public void MakeTree(){
        HuffmanNode parent;
        HuffmanNode leftChild;
        HuffmanNode rightChild;

        while(!que.isEmpty()){
            leftChild = que.remove();
            rightChild = que.remove();
            parent = new HuffmanNode(leftChild.frequency + rightChild.frequency,'n');
            parent.leftChild = leftChild;
            parent.rightChild = rightChild;
            if(que.numValidValues > 0) {
                que.insert(parent);
            }
            if(que.numValidValues == 0){
                root = parent;
            }
        }
    }

    private void PrintTraverseNodes(StringBuilder sb, String padding, String pointer,
                                    HuffmanNode node, boolean hasRightSibling) {

        if (node == null)
            return;

        sb.append("\n");
        sb.append(padding);
        sb.append(pointer);
        sb.append(node.frequency);

        StringBuilder pb = new StringBuilder(padding);
        if (hasRightSibling)
            pb.append("|  ");
        else
            pb.append("   ");

        String p = pb.toString();
        String pntr = "|--";
        PrintTraverseNodes(sb, p, pntr, node.leftChild, node.rightChild != null);
        PrintTraverseNodes(sb, p, pntr, node.rightChild, false);
    }

    private String traversePreOrder(HuffmanNode root) {
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();
        sb.append(root.frequency);

        String pointerRight = "---";
        String pointerLeft = "|--";

        PrintTraverseNodes(sb, "", pointerLeft, root.leftChild, root.rightChild != null);
        PrintTraverseNodes(sb, "", pointerRight, root.rightChild, false);

        return sb.toString();
    }
    public void print() {
        String s = traversePreOrder(root);
        System.out.println(s);
    }

}
