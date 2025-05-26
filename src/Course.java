import java.util.ArrayList;

public class Course {
    private String code;
    private String name;
    private int primary;
    private int alternate;
    private int maxEnrollment;
    private int sections;
    private ArrayList<SingleClass> classes;
    private ArrayList<String> sequencingCourseCodeList;
    private ArrayList<String> blockingCourseCodeList;
    private ArrayList<Integer> waitlist;

    public Course() {
        classes = new ArrayList<>();
        sequencingCourseCodeList = new ArrayList<>();
        blockingCourseCodeList = new ArrayList<>();
    }

    public Course(String code, String name, int primary, int alternate, int maxEnrollment, int sections) {
        this.code = code;
        this.name = name;
        this.primary = primary;
        this.alternate = alternate;
        this.maxEnrollment = maxEnrollment;
        this.sections = sections;
        this.classes = new ArrayList<>();
        this.sequencingCourseCodeList = new ArrayList<>();
        this.blockingCourseCodeList = new ArrayList<>();
        this.waitlist = new ArrayList<>();
    }

    public Course(String code, String name, int primary, int alternate, int maxEnrollment, int sections, ArrayList<SingleClass> classes, ArrayList<String> sequencingCourseCodeList, ArrayList<String> blockingCourseCodeList, ArrayList<Integer> waitlist) {
        this.code = code;
        this.name = name;
        this.primary = primary;
        this.alternate = alternate;
        this.maxEnrollment = maxEnrollment;
        this.sections = sections;
        this.classes = classes;
        this.sequencingCourseCodeList = sequencingCourseCodeList;
        this.blockingCourseCodeList = blockingCourseCodeList;
        this.waitlist = waitlist;
    }

    public void updateWaitlist() {
        for (int i = waitlist.size() - 1; i >= 0; i--) {
            if (waitlist.get(i) == -1) waitlist.remove(i);
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrimary() {
        return primary;
    }

    public void setPrimary(int primary) {
        this.primary = primary;
    }

    public int getAlternate() {
        return alternate;
    }

    public void setAlternate(int alternate) {
        this.alternate = alternate;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public int getSections() {
        return sections;
    }

    public void setSections(int sections) {
        this.sections = sections;
    }

    public ArrayList<SingleClass> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<SingleClass> classes) {
        this.classes = classes;
    }

    public void addClass(SingleClass c) {
        classes.add(c);
    }

    public ArrayList<String> getSequencingCourseCodeList() {
        return sequencingCourseCodeList;
    }

    public void setSequencingCourseCodeList(ArrayList<String> sequencingCourseCodeList) {
        this.sequencingCourseCodeList = sequencingCourseCodeList;
    }

    public void addSequencingCourse(String c) {
        sequencingCourseCodeList.add(c);
    }

    public ArrayList<String> getBlockingCourseCodeList() {
        return blockingCourseCodeList;
    }

    public void setBlockingCourseCodeList(ArrayList<String> blockingCourseCodeList) {
        this.blockingCourseCodeList = blockingCourseCodeList;
    }

    public void addBlockingCourse(String c) {
        blockingCourseCodeList.add(c);
    }

    public ArrayList<Integer> getWaitlist() {
        return waitlist;
    }

    public void setWaitlist(ArrayList<Integer> waitlist) {
        this.waitlist = waitlist;
    }

    public void addWaitingStudent(int id, boolean isPrioritized) {
        if (isPrioritized) waitlist.addFirst(id);
        else waitlist.addLast(id);
    }

    public String toString() {
        return "Course{code = " + code + ", name = " + name + ", primary = " + primary + ", alternate = " + alternate + ", maxEnrollment = " + maxEnrollment + ", sections = " + sections + ", classes = " + classes + ", sequencingCourseCodeList = " + sequencingCourseCodeList + ", blockingCourseCodeList = " + blockingCourseCodeList + ", waitlist = " + waitlist + "}";
    }
}