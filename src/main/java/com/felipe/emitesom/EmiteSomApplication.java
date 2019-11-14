package com.felipe.emitesom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

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
        try {
            tocaSom();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "OK";
	}

    public void tocaSom() throws Exception {
        // Carrega o arquivo de áudio (não funciona com .mp3, só .wav)
        URL oUrl = new URL("https://www.dropbox.com/s/xf7jhrzovq8wt09/beep-02.wav?dl=1");
        Clip oClip = AudioSystem.getClip();
        AudioInputStream oStream = AudioSystem.getAudioInputStream(oUrl);
        oClip.open(oStream);

        oClip.loop(0); // Toca uma vez


        // Para a execução (senão o programa termina antes de ouvir o som)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }
 }
