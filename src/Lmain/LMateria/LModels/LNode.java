package Lmain.LMateria.LModels;

public class LNode {


    private int value;
    private LNode left;
    private LNode right;

    public LNode (int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LNode getLeft() {
        return left;
    }

    public void setLeft(LNode left) {
        this.left = left;
    }

    public LNode getRight() {
        return right;
    }

    public void setRight(LNode right) {
        this.right = right;
    }

    
}
