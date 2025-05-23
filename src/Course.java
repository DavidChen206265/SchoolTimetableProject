import java.sql.Array;
import java.util.ArrayList;

public class Course {
    String code;
    String name;
    int primary;
    int alternate;
    int maxEnrollment;
    int sections;
    ArrayList<SingleClass> classes;
    ArrayList<Course> simultaneousCourses;
    ArrayList<Course> prerequiredCourses;


    public Course() {
        classes = new ArrayList<SingleClass>();
        simultaneousCourses = new ArrayList<Course>();
        prerequiredCourses = new ArrayList<Course>();
    }

    public Course(String code, String name, int primary, int alternate, int maxEnrollment, int sections, ArrayList<SingleClass> classes, ArrayList<Course> simultaneousCourses, ArrayList<Course> prerequiredCourses) {
        this.code = code;
        this.name = name;
        this.primary = primary;
        this.alternate = alternate;
        this.maxEnrollment = maxEnrollment;
        this.sections = sections;
        this.classes = classes;
        this.simultaneousCourses = simultaneousCourses;
        this.prerequiredCourses = prerequiredCourses;
    }

    /**
     * 获取
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return primary
     */
    public int getPrimary() {
        return primary;
    }

    /**
     * 设置
     * @param primary
     */
    public void setPrimary(int primary) {
        this.primary = primary;
    }

    /**
     * 获取
     * @return alternate
     */
    public int getAlternate() {
        return alternate;
    }

    /**
     * 设置
     * @param alternate
     */
    public void setAlternate(int alternate) {
        this.alternate = alternate;
    }

    /**
     * 获取
     * @return maxEnrollment
     */
    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    /**
     * 设置
     * @param maxEnrollment
     */
    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    /**
     * 获取
     * @return sections
     */
    public int getSections() {
        return sections;
    }

    /**
     * 设置
     * @param sections
     */
    public void setSections(int sections) {
        this.sections = sections;
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

    public void addClass(SingleClass c) {
        classes.add(c);
    }

    /**
     * 获取
     * @return simultaneousCourses
     */
    public ArrayList<Course> getSimultaneousCourses() {
        return simultaneousCourses;
    }

    /**
     * 设置
     * @param simultaneousCourses
     */
    public void setSimultaneousCourses(ArrayList<Course> simultaneousCourses) {
        this.simultaneousCourses = simultaneousCourses;
    }

    public void addSimultaneousCourse(Course c) {
        simultaneousCourses.add(c);
    }

    /**
     * 获取
     * @return prerequiredCourses
     */
    public ArrayList<Course> getPrerequiredCourses() {
        return prerequiredCourses;
    }

    /**
     * 设置
     * @param prerequiredCourses
     */
    public void setPrerequiredCourses(ArrayList<Course> prerequiredCourses) {
        this.prerequiredCourses = prerequiredCourses;
    }

    addPrerequiredCourse(Course c) {
        prerequiredCourses.add(c);
    }

    public String toString() {
        return "Course{code = " + code + ", name = " + name + ", primary = " + primary + ", alternate = " + alternate + ", maxEnrollment = " + maxEnrollment + ", sections = " + sections + ", classes = " + classes + ", simultaneousCourses = " + simultaneousCourses + ", prerequiredCourses = " + prerequiredCourses + "}";
    }
}