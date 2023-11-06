package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Course {
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "Hour")
    private Float hour;
    @OneToMany(mappedBy = "courseByCourseId")
    private Collection<CourseMajor> courseMajorsById;
    @OneToMany(mappedBy = "courseByCourseId")
    private Collection<CourseSmemeter> courseSmemetersById;
    @OneToMany(mappedBy = "courseByCourseId")
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

    public Float getHour() {
        return hour;
    }

    public void setHour(Float hour) {
        this.hour = hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (id != null ? !id.equals(course.id) : course.id != null) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        if (hour != null ? !hour.equals(course.hour) : course.hour != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (hour != null ? hour.hashCode() : 0);
        return result;
    }

    public Collection<CourseMajor> getCourseMajorsById() {
        return courseMajorsById;
    }

    public void setCourseMajorsById(Collection<CourseMajor> courseMajorsById) {
        this.courseMajorsById = courseMajorsById;
    }

    public Collection<CourseSmemeter> getCourseSmemetersById() {
        return courseSmemetersById;
    }

    public void setCourseSmemetersById(Collection<CourseSmemeter> courseSmemetersById) {
        this.courseSmemetersById = courseSmemetersById;
    }

    public Collection<CourseStudent> getCourseStudentsById() {
        return courseStudentsById;
    }

    public void setCourseStudentsById(Collection<CourseStudent> courseStudentsById) {
        this.courseStudentsById = courseStudentsById;
    }
}
