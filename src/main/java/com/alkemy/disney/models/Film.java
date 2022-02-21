package com.alkemy.disney.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String img;
    private String title;
    private LocalDate creationDate;
    private Byte qualification; // from 1 to 5

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "characters")
    private List<Character> character;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gender_id")
    private Gender gender;

    public Film() {}

    public Film(String img, String title, LocalDate creationDate, Byte qualification) {
        this.img = img;
        this.title = title;
        this.creationDate = creationDate;
        this.qualification = qualification;
    }

    public Long getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Byte getQualification() {
        return qualification;
    }

    public void setQualification(Byte qualification) {
        this.qualification = qualification;
    }

    @JsonIgnore
    public List<Character> getCharacter() {
        return character;
    }

    public void setCharacter(List<Character> character) {
        this.character = character;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Film{");
        sb.append("id=").append(id);
        sb.append(", img='").append(img).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", creationDate=").append(creationDate);
        sb.append(", qualification=").append(qualification);
        sb.append('}');
        return sb.toString();
    }
}
