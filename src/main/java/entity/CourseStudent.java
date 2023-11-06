package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "Course_student", schema = "dbo", catalog = "ESMS_v3")
@IdClass(CourseStudentPK.class)
public class CourseStudent {
    @Id
    @Column(name = "Course_id")
    private String courseId;
    @Id
    @Column(name = "Student_ID")
    private String studentId;
    @ManyToOne
    @JoinColumn(name = "Course_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Course courseByCourseId;
    @ManyToOne
    @JoinColumn(name = "Student_ID", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Student studentByStudentId;
    @OneToMany(mappedBy = "courseStudent")
    private Collection<ExamSchedule> examSchedules;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseStudent that = (CourseStudent) o;

        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        return result;
    }

    public Course getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(Course courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }

    public Student getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(Student studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }

    public Collection<ExamSchedule> getExamSchedules() {
        return examSchedules;
    }

    public void setExamSchedules(Collection<ExamSchedule> examSchedules) {
        this.examSchedules = examSchedules;
    }
}
