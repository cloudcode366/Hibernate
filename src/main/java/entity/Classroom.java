package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Classroom {
    @Id
    @Column(name = "Room")
    private String room;
    @OneToMany(mappedBy = "classroomByRoomId")
    private Collection<ExamSchedule> examSchedulesByRoom;

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Classroom classroom = (Classroom) o;

        if (room != null ? !room.equals(classroom.room) : classroom.room != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return room != null ? room.hashCode() : 0;
    }

    public Collection<ExamSchedule> getExamSchedulesByRoom() {
        return examSchedulesByRoom;
    }

    public void setExamSchedulesByRoom(Collection<ExamSchedule> examSchedulesByRoom) {
        this.examSchedulesByRoom = examSchedulesByRoom;
    }
}
