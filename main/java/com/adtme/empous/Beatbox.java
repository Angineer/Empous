package main.java.com.adtme.empous;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class Beatbox {
	private static Clip clip;
	
	public static void main(String args[]){
		AudioInputStream ain;
        try {
        	ain = AudioSystem.getAudioInputStream(new File("C:\\Users\\Andy2\\javawork\\workspace\\Learning Java\\src\\empous\\resources\\audio\\sample.wav"));
            DataLine.Info info =
                new DataLine.Info(Clip.class,ain.getFormat( ));
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(ain);
        } catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		clip.start();
	}
	
}
