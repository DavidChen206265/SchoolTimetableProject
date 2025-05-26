import java.util.*;

public class Block {
    int block;
    ArrayList<SingleClass> classes;

    public Block(int block) {
        this.block = block;
        classes = new ArrayList<>();
    }

    public Block(int block, ArrayList<SingleClass> classes) {
        this.block = block;
        this.classes = classes;
    }

    public ArrayList<SingleClass> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<SingleClass> classes) {
        this.classes = classes;
    }

    public void addClass(SingleClass c){
        classes.add(c);
        c.setBlock(block);
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public String toString() {
        return "Block{block = " + block + ", classes = " + classes + "}";
    }
}