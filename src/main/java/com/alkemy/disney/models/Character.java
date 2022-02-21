package com.alkemy.disney.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "character")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "strategy", strategy = "native")
    private Long id;
    private String img;
    private String name;
    private Short age;
    private String weight;
    private String story;

    @ManyToMany(mappedBy = "character")
    private List<Film> films = new ArrayList<>();

    public Character() {}

    public Character(String img, String name, Short age, String weight, String story) {
        this.img = img;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.story = story;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void addFilm(Film film) {
        film.setCharacter(List.of(this));
        films.add(film);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Character{");
        sb.append("id=").append(id);
        sb.append(", img='").append(img).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", weight='").append(weight).append('\'');
        sb.append(", story='").append(story).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
