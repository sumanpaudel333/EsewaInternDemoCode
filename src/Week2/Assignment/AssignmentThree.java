package Week2.Assignment;

import java.util.*;

class SortedMapDemo implements Comparable<SortedMapDemo> {

    @Override
    public String toString() {
        return "SortedMapDemo{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    private String name;
    private int marks;

    public SortedMapDemo(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public int compareTo(SortedMapDemo o) {
        return this.getMarks()-o.marks;
    }
}

public class AssignmentThree {
    public static void main(String[] args) {
        SortedMap<String, Integer> studentRecord = new TreeMap<>();

        SortedMapDemo s1 = new SortedMapDemo("Suman", 67);
        SortedMapDemo s2 = new SortedMapDemo("Ram", 98);
        SortedMapDemo s3 = new SortedMapDemo("Shyam", 90);
        studentRecord.put(s1.getName(), s1.getMarks());
        studentRecord.put(s2.getName(), s2.getMarks());
        studentRecord.put(s3.getName(), s3.getMarks());
        System.out.println(studentRecord);

    }
}
