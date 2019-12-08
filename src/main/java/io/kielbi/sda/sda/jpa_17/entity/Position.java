package io.kielbi.sda.sda.jpa_17.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@ToString
public class Position extends AbstractEntity<Long> {


    @Column(unique = true, nullable = false, length = 64)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
