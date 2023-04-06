public class Course {
    private int id;
    private string name;

    public Course(String name){
        this.name = name;
    }

    public getId(){
        return id;
    }

    public setId(){
        this.id = id;
    }

    public getName(){
        return name;
    }

    public setName(){
        this.name = name;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Couse couse = (Couse) object;
        return id == couse.id && java.util.Objects.equals(name, couse.name);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name);
    }
}