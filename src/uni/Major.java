package uni;

import base.Person;

import java.util.ArrayList;

public class Major {
    public int id;
    public static ArrayList<Major> majorList = new ArrayList<>();
    public String name;
    public final int capacity;
    public int numberOfstudents;


    public Major(String name, int capacity) {
        this.id = majorList.size() + 10;
        this.capacity = capacity;
        this.name = name;
        this.numberOfstudents = 0;
        majorList.add(this);
    }

    public static Major findById(int majorID){
        for (Major major : majorList) {
            if (major.id == majorID) {
                return major;
            }
        }
        return null;
    }

    public void addStudent() {
        if (this.numberOfstudents < this.capacity) {
            this.numberOfstudents++;
        } else {
            System.out.println("ظرفیت رشته پر است.");
        }
    }
}

