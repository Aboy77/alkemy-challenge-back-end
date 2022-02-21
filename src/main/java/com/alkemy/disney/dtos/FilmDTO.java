package com.alkemy.disney.dtos;

import com.alkemy.disney.models.Character;
import com.alkemy.disney.models.Film;
import com.alkemy.disney.models.Gender;

import java.time.LocalDate;
import java.util.List;

public class FilmDTO {
    private Long id;
    private String img;
    private String title;
    private LocalDate creationDate;
    private Byte qualification;
    private List<Character> characters;
    private Gender gender;

    public FilmDTO() {}

    public FilmDTO(Film film) {
        this.id = film.getId();
        this.img = film.getImg();
        this.title = film.getTitle();
        this.creationDate = film.getCreationDate();
        this.qualification = film.getQualification();
        this.characters = film.getCharacter();
        this.gender = film.getGender();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
