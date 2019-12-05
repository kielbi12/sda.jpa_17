package io.kielbi.sda.sda.jpa_17.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity

public class Project extends AbstractEntity<Long> {



    @Column(unique = true, nullable = false, length = 31)
    private String type;

    @Column(unique = true, nullable = false, length = 255)
    private String name;

    @Column(unique = true, nullable = false, length = 255)
    private String client;

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", version=" + version +
                ", client='" + client + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getClient() {
        return client;
    }

}