import java.util.*;

public class Block {
    ArrayList<SingleClass> classes;


    public Block() {
        classes = new ArrayList<>();
    }

    public Block(ArrayList<SingleClass> classes) {
        this.classes = classes;
    }

    /**
     * 获取
     * @return classes
     */
    public ArrayList<SingleClass> getClasses() {
        return classes;
    }

    /**
     * 设置
     * @param classes
     */
    public void setClasses(ArrayList<SingleClass> classes) {
        this.classes = classes;
    }

    public void addClass(SingleClass c){
        classes.add(c);
    }

    public String toString() {
        return "Block{classes = " + classes + "}";
    }
}