package src.common;

import java.util.Objects;

public class Course {
    private int id;
    private String name;

    public Course(String name){
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Course course = (Course) object;
        return id == course.id && java.util.Objects.equals(name, course.name);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name);
    }
}