package org.pasut.games.war;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration //como agregue la dependencia web (tomcat + spring MVC), asume que estoy creando una aplicacion web 
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}