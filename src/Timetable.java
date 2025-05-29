import java.util.ArrayList;

public class Timetable {

    private Block[] blocks;
    private ArrayList<SingleClass> allClasses;

    public Timetable(ArrayList<SingleClass> allClasses) {
        blocks = new Block[8];
        this.allClasses = allClasses;
        for (int i = 0; i < blocks.length; i++) {
            blocks[i] = new Block(i);
        }
    }

    public ArrayList<SingleClass> getAllClasses() {
        return allClasses;
    }

    public Timetable(Block[] blocks) {
        this.blocks = blocks;
    }

    public Block[] getBlocks() {
        return blocks;
    }

    public void setBlocks(Block[] blocks) {
        this.blocks = blocks;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < blocks.length; i++) {
            str += i + "\n";
            str += blocks[i] + "\n\n";
        }
        return str;
    }
}