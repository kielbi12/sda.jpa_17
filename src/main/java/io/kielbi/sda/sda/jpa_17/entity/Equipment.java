package io.kielbi.sda.sda.jpa_17.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity // ta encja nie potrzebuje aktualizacji, wobec czego vervion nie jest potrzebna, w domu dorobic dwie klasy abstrakcyjne rozdzielające tę zaleznosc
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"code", "type"})
)
public class Equipment extends AbstractEntity<Long> {


    @Column(nullable = false, updatable = false)
    private String type;

    @Column(nullable = false, updatable = false)
    private String code;

    @JsonBackReference
    @ManyToOne
    private Employee employee;

    @Override
    public String toString() {
        return "Equipment{" +
                "type='" + type + '\'' +
                ", code='" + code + '\'' +
                ", id=" + id +
                ", version=" + version +
                '}';
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipment)) return false;
        if (!super.equals(o)) return false;
        Equipment equipment = (Equipment) o;
        return type.equals(equipment.type) &&
                code.equals(equipment.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, code);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
