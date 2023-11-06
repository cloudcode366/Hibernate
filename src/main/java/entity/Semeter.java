package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Semeter {
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "Name")
    private String name;
    @OneToMany(mappedBy = "semeterBySemeterId")
    private Collection<CourseSmemeter> courseSmemetersById;

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

        Semeter semeter = (Semeter) o;

        if (id != null ? !id.equals(semeter.id) : semeter.id != null) return false;
        if (name != null ? !name.equals(semeter.name) : semeter.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<CourseSmemeter> getCourseSmemetersById() {
        return courseSmemetersById;
    }

    public void setCourseSmemetersById(Collection<CourseSmemeter> courseSmemetersById) {
        this.courseSmemetersById = courseSmemetersById;
    }
}
