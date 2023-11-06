package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Course_major", schema = "dbo", catalog = "ESMS_v3")
@IdClass(CourseMajorPK.class)
public class CourseMajor {
    @Id
    @Column(name = "Major_id")
    private String majorId;
    @Id
    @Column(name = "Course_id")
    private String courseId;
    @ManyToOne
    @JoinColumn(name = "Major_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Major majorByMajorId;
    @ManyToOne
    @JoinColumn(name = "Course_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Course courseByCourseId;

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

        CourseMajor that = (CourseMajor) o;

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

    public Major getMajorByMajorId() {
        return majorByMajorId;
    }

    public void setMajorByMajorId(Major majorByMajorId) {
        this.majorByMajorId = majorByMajorId;
    }

    public Course getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(Course courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }
}
