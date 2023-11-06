package entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Exam_slot", schema = "dbo", catalog = "ESMS_v3")
public class ExamSlot {
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "Date")
    private String date;
    @Basic
    @Column(name = "Time")
    private String time;
    @Basic
    @Column(name = "Hour")
    private Float hour;
    @OneToMany(mappedBy = "examSlotBySlotId")
    private Collection<ExamSchedule> examSchedulesById;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
        ExamSlot examSlot = (ExamSlot) o;
        return Objects.equals(id, examSlot.id);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (hour != null ? hour.hashCode() : 0);
        return result;
    }

    public Collection<ExamSchedule> getExamSchedulesById() {
        return examSchedulesById;
    }

    public void setExamSchedulesById(Collection<ExamSchedule> examSchedulesById) {
        this.examSchedulesById = examSchedulesById;
    }
}
