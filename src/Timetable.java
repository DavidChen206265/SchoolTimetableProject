public class Timetable {

    private Block[] blocks;

    public Timetable() {
        blocks = new Block[8];
        for (int i = 0; i < blocks.length; i++) {
            blocks[i] = new Block(i);
        }
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