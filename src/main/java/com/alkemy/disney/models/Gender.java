package com.alkemy.disney.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String name;
    private String img;

    @OneToMany(mappedBy = "gender", fetch = FetchType.EAGER)
    private List<Film> films = new ArrayList<>();

    public Gender() {}

    public Gender(String name, String img) {
        this.name = name;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @JsonIgnore
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void addFilm(Film film) {
        film.setGender(this);
        films.add(film);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Gender{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", img='").append(img).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
