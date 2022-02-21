package com.alkemy.disney.dtos;

import com.alkemy.disney.models.Film;
import com.alkemy.disney.models.Gender;

import java.util.List;

public class GenderDTO {
    private Long id;
    private String name;
    private String img;
    private List<Film> films;

    public GenderDTO() {}

    public GenderDTO(Gender gender) {
        this.id = gender.getId();
        this.name = gender.getName();
        this.img = gender.getImg();
        this.films = gender.getFilms();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
