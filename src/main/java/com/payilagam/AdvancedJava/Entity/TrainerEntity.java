package com.payilagam.AdvancedJava.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="trainer_details")
public class TrainerEntity {

    @Id
    @Column(name="trainer_id")
    private int id;
    @Column (name="trainer_name", nullable=false)
    private String name;
    @Column(name="trainer_subject", nullable=false)
    private String subject;
    @Column(name="trainer_experience")
    private int experience;

    public TrainerEntity() {
    }


    public TrainerEntity(int id, String name, String subject, int experience) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.experience = experience;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }

}
