package com.felipe.emitesom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.io.InputStream;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class EmiteSomApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmiteSomApplication.class, args);
	}

	@GetMapping
	public String emiteSom() {
		System.out.println("tocou");
		tocaSom();
		return "OK";
	}

	private void tocaSom() {
		// Carrega o arquivo de áudio (não funciona com .mp3, só .wav)
		String resource = "./cavalo.mp3";
		InputStream input = getClass().getResourceAsStream(resource);
		Clip oClip = null;
		try {
			oClip = AudioSystem.getClip();
		AudioInputStream audioInput = AudioSystem.getAudioInputStream(input);
		oClip.open(audioInput);

		oClip.loop(0); // Toca uma vez
		//clip.loop(Clip.LOOP_CONTINUOUSLY); // Toca continuamente (para o caso de músicas)

		} catch (Exception e) {
			e.printStackTrace();
		}
		// Para a execução (senão o programa termina antes de você ouvir o som)
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

			}
		});
	}
 }
