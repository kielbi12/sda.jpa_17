package io.kielbi.sda.sda.jpa_17.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity

public class Skill extends AbstractEntity<Long> {

    @Column(unique = true)
    private String name;

    public String getName() {
        return name;
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
