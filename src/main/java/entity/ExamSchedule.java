package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Exam_schedule", schema = "dbo", catalog = "ESMS_v3")
public class ExamSchedule {
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "Room_id")
    private String roomId;
    @Basic
    @Column(name = "slot_id")
    private String slotId;
    @Basic
    @Column(name = "lecture_id")
    private String lectureId;
    @Basic
    @Column(name = "course_id")
    private String courseId;
    @Basic
    @Column(name = "student_id")
    private String studentId;
    @ManyToOne
    @JoinColumn(name = "Room_id", referencedColumnName = "Room",insertable = false,updatable = false)
    private Classroom classroomByRoomId;
    @ManyToOne
    @JoinColumn(name = "slot_id", referencedColumnName = "id",insertable = false,updatable = false)
    private ExamSlot examSlotBySlotId;
    @ManyToOne
    @JoinColumn(name = "lecture_id", referencedColumnName = "id",insertable = false,updatable = false)
    private Lecture lectureByLectureId;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "course_id", referencedColumnName = "Course_id",insertable = false,updatable = false), @JoinColumn(name = "student_id", referencedColumnName = "Student_ID",insertable = false,updatable = false)})
    private CourseStudent courseStudent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getLectureId() {
        return lectureId;
    }

    public void setLectureId(String lectureId) {
        this.lectureId = lectureId;
    }

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

        ExamSchedule that = (ExamSchedule) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;
        if (slotId != null ? !slotId.equals(that.slotId) : that.slotId != null) return false;
        if (lectureId != null ? !lectureId.equals(that.lectureId) : that.lectureId != null) return false;
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        result = 31 * result + (slotId != null ? slotId.hashCode() : 0);
        result = 31 * result + (lectureId != null ? lectureId.hashCode() : 0);
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        return result;
    }

    public Classroom getClassroomByRoomId() {
        return classroomByRoomId;
    }

    public void setClassroomByRoomId(Classroom classroomByRoomId) {
        this.classroomByRoomId = classroomByRoomId;
    }

    public ExamSlot getExamSlotBySlotId() {
        return examSlotBySlotId;
    }

    public void setExamSlotBySlotId(ExamSlot examSlotBySlotId) {
        this.examSlotBySlotId = examSlotBySlotId;
    }

    public Lecture getLectureByLectureId() {
        return lectureByLectureId;
    }

    public void setLectureByLectureId(Lecture lectureByLectureId) {
        this.lectureByLectureId = lectureByLectureId;
    }

    public CourseStudent getCourseStudent() {
        return courseStudent;
    }

    public void setCourseStudent(CourseStudent courseStudent) {
        this.courseStudent = courseStudent;
    }
}
