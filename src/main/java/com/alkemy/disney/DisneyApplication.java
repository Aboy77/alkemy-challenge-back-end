package com.alkemy.disney;

import com.alkemy.disney.models.Character;
import com.alkemy.disney.models.Film;
import com.alkemy.disney.models.Gender;
import com.alkemy.disney.models.Users;
import com.alkemy.disney.repositories.CharacterRepository;
import com.alkemy.disney.repositories.FilmRepository;
import com.alkemy.disney.repositories.GenderRepository;
import com.alkemy.disney.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class DisneyApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(DisneyApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(UserRepository userRepository, CharacterRepository characterRepository, FilmRepository filmRepository, GenderRepository genderRepository) {
		return (args) -> {
			// class
			Users users = new Users("briancuenca200@gmail.com", passwordEncoder.encode("1234"));
			Character character = new Character("/img", "Mickey",  (short) 22, "10kg", "A mouse walking in the park");
			Film film = new Film("/img", "The mouse", LocalDate.now(), (byte) 5);
			Film film2 = new Film("/img", "The monster house", LocalDate.now(), (byte) 4);
			Gender gender = new Gender("Animation", "/img/filmlogo");

			// relational
			character.addFilm(film);
			character.addFilm(film2);
			gender.addFilm(film);
			gender.addFilm(film2);

			// repository
			userRepository.save(users);
			characterRepository.save(character);
			genderRepository.save(gender);
			filmRepository.save(film);
			filmRepository.save(film2);
		};
	}
}
