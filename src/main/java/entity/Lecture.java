package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Lecture {
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Email")
    private String email;
    @Basic
    @Column(name = "Phone")
    private String phone;
    @OneToMany(mappedBy = "lectureByLectureId")
    private Collection<ExamSchedule> examSchedulesById;

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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lecture lecture = (Lecture) o;

        if (id != null ? !id.equals(lecture.id) : lecture.id != null) return false;
        if (name != null ? !name.equals(lecture.name) : lecture.name != null) return false;
        if (email != null ? !email.equals(lecture.email) : lecture.email != null) return false;
        if (phone != null ? !phone.equals(lecture.phone) : lecture.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    public Collection<ExamSchedule> getExamSchedulesById() {
        return examSchedulesById;
    }

    public void setExamSchedulesById(Collection<ExamSchedule> examSchedulesById) {
        this.examSchedulesById = examSchedulesById;
    }
}
