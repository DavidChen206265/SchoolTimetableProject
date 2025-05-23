import sun.jvm.hotspot.opto.Block;

import java.util.*;

public class Timetable {

    private Block[8] blocks;

    public Timetable() {
        blocks = new Block[8];
    }

    public void addBlock(Block b, int i) {
        if(i >= 0 && i <= 7) {
            blocks[i] = b;
        } else {
            System.out.println("There is no block " + i);
        }
    }

    public String toString() {
        return "Timetable{}";
    }






}