package entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class CourseMajorPK implements Serializable {
    @Column(name = "Major_id")
    @Id
   
    private String majorId;
    @Column(name = "Course_id")
    @Id
   
    private String courseId;

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseMajorPK that = (CourseMajorPK) o;

        if (majorId != null ? !majorId.equals(that.majorId) : that.majorId != null) return false;
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = majorId != null ? majorId.hashCode() : 0;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        return result;
    }
}
