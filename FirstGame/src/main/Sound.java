package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

//Sound credits:
//Main theme : https://opengameart.org/content/blue-sky
//by Alex McCulloch.
//
//rpg sound pack : https://opengameart.org/content/rpg-sound-pack
//by artisticdude
//
//level up : https://opengameart.org/content/power-up-level-up-beansjam
//by Quitschie
//
//fanfare: https://opengameart.org/content/8bit-fanfare-jingle-the-lick
//by Haley Halcyon

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound() {


        soundURL[0] = getClass().getClassLoader().getResource("sound/blue_sky.wav");
        soundURL[1] = getClass().getClassLoader().getResource("sound/coin.wav");
        soundURL[2] = getClass().getClassLoader().getResource("sound/powerup.wav");
        soundURL[3] = getClass().getClassLoader().getResource("sound/unlock.wav");
        soundURL[4] = getClass().getClassLoader().getResource("sound/fanfare.wav");

    }

    public void setFile(int index){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[index]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }

}
