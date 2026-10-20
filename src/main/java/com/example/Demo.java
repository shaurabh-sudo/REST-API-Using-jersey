package com.example;

import jakarta.xml.bind.annotation.XmlRootElement;

public @XmlRootElement
class Demo {
   private int marks;
   private String name;
   private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "marks=" + marks +
                ", name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }
}
