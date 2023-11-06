package entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class CourseSmemeterPK implements Serializable {
    @Column(name = "Course_id")
    @Id
   
    private String courseId;
    @Column(name = "Semeter_id")
    @Id
   
    private String semeterId;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSemeterId() {
        return semeterId;
    }

    public void setSemeterId(String semeterId) {
        this.semeterId = semeterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseSmemeterPK that = (CourseSmemeterPK) o;

        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (semeterId != null ? !semeterId.equals(that.semeterId) : that.semeterId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (semeterId != null ? semeterId.hashCode() : 0);
        return result;
    }
}
