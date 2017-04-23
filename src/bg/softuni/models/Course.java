package bg.softuni.models;

import bg.softuni.exceptions.InvalidStringException;
import bg.softuni.interfaces.Courseble;
import bg.softuni.exceptions.DuplicateEntryInStructureException;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Course implements Courseble {

    private String name;
    private LinkedHashMap<String, Student> studentsByName;

    public Course(String name) {
        this.setName(name);
        this.studentsByName = new LinkedHashMap<>();
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public Map<String, Student> getStudentsByName() {
        return Collections.unmodifiableMap(this.studentsByName);
    }

    private void setName(String name) {
        if (name == null || name.equals("")){
            throw new InvalidStringException();
        }
        this.name = name;
    }

    @Override
    public void enrollStudent(Student student){
        if (this.studentsByName.containsKey(student.getUserName())){
            throw new DuplicateEntryInStructureException(student.getUserName(), this.name);
        }
        this.studentsByName.put(student.getUserName(), student);
    }

    @Override
    public int compareTo(Course o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
