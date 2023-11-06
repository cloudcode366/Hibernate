package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Course_smemeter", schema = "dbo", catalog = "ESMS_v3")
@IdClass(CourseSmemeterPK.class)
public class CourseSmemeter {
    @Id
    @Column(name = "Course_id")
    private String courseId;
    @Id
    @Column(name = "Semeter_id")
    private String semeterId;
    @ManyToOne
    @JoinColumn(name = "Course_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Course courseByCourseId;
    @ManyToOne
    @JoinColumn(name = "Semeter_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Semeter semeterBySemeterId;

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

        CourseSmemeter that = (CourseSmemeter) o;

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

    public Course getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(Course courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }

    public Semeter getSemeterBySemeterId() {
        return semeterBySemeterId;
    }

    public void setSemeterBySemeterId(Semeter semeterBySemeterId) {
        this.semeterBySemeterId = semeterBySemeterId;
    }
}
