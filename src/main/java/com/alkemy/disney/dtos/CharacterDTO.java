package com.alkemy.disney.dtos;

import com.alkemy.disney.models.Character;
import com.alkemy.disney.models.Film;

import java.util.List;

public class CharacterDTO {
    private Long id;
    private String img;
    private String name;
    private Short age;
    private String weight;
    private String story;
    private List<Film> films;

    public CharacterDTO() {}

    public CharacterDTO(Character character) {
        this.id = character.getId();
        this.img = character.getImg();
        this.name = character.getName();
        this.age = character.getAge();
        this.weight = character.getWeight();
        this.story = character.getStory();
        this.films = character.getFilms();
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
}
