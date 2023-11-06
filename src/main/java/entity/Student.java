package entity;

import jakarta.persistence.*;

import java.text.Normalizer;
import java.util.Collection;
import java.util.Objects;
import java.util.regex.Pattern;

@Entity
public class Student {
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "studentByStudentId")
    private Collection<CourseStudent> courseStudentsById;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    private String generateStudentEmail(String name, String studentID) {
        name = convertToEnglish(name);
        String[] arr = name.split(" ");
        StringBuilder username = new StringBuilder(arr[arr.length - 1]);
        for(int i =0;i< arr.length-1;i++){
            username.append(arr[i].charAt(0));
        }
        return username+ studentID + "@fpt.edu.vn";
    }
    private String convertToEnglish(String vietnameseWord) {
        // Remove diacritics (accents) using Normalizer
        String normalized = Normalizer.normalize(vietnameseWord, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String englishEquivalent = pattern.matcher(normalized).replaceAll("");

        // Convert to lowercase (optional)
        englishEquivalent = englishEquivalent.toLowerCase();

        return englishEquivalent;
    }
    public void setEmail() {
        this.email = generateStudentEmail(getName(),getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public Collection<CourseStudent> getCourseStudentsById() {
        return courseStudentsById;
    }

    public void setCourseStudentsById(Collection<CourseStudent> courseStudentsById) {
        this.courseStudentsById = courseStudentsById;
    }
}
