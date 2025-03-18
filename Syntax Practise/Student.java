import java.util.Objects;

public class Student implements Comparable<Student>{

    public int id;
    public String name;

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Student other){
        return this.id - other.id;
    } 


    @Override
    public int hashCode(){
        return Objects.hash(id, name);
    }

    @Override 
    public String toString(){
        return "Student: " + id + " " + name;
    }
}