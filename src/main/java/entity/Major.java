package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Major {
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "majorByMajorId")
    private Collection<CourseMajor> courseMajorsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Major major = (Major) o;

        if (id != null ? !id.equals(major.id) : major.id != null) return false;
        if (name != null ? !name.equals(major.name) : major.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<CourseMajor> getCourseMajorsById() {
        return courseMajorsById;
    }

    public void setCourseMajorsById(Collection<CourseMajor> courseMajorsById) {
        this.courseMajorsById = courseMajorsById;
    }
}
