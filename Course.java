import java.util.ArrayList;

public class Course {
    private String code;
    private String name;
    private int primary;
    private int alternate;
    private int maxEnrollment;
    private int section;
    private ArrayList<SingleClass> classes;
    private ArrayList<Course> simultaneousCourses;
    private ArrayList<Course> prerequiredCourses;

    public Course(String code, String name, int primary, int alternate, int maxEnrollment, int section) {
        this.code = code;
        this.name = name;
        this.primary = primary;
        this.alternate = alternate;
        this.maxEnrollment = maxEnrollment;
        this.section = section;
        this.classes = new ArrayList<>();
        this.simultaneousCourses = new ArrayList<>();
        this.prerequiredCourses = new ArrayList<>();
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

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public ArrayList<SingleClass> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<SingleClass> classes) {
        this.classes = classes;
    }

    public ArrayList<Course> getSimultaneousCourses() {
        return simultaneousCourses;
    }

    public void setSimultaneousCourses(ArrayList<Course> simultaneousCourses) {
        this.simultaneousCourses = simultaneousCourses;
    }

    public ArrayList<Course> getPrerequiredCourses() {
        return prerequiredCourses;
    }

    public void setPrerequiredCourses(ArrayList<Course> prerequiredCourses) {
        this.prerequiredCourses = prerequiredCourses;
    }
}
