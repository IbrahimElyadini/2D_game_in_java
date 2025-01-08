package main;

import object.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {

    GamePanel gP;
    Font arial_40, arial_80_bold;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gP) {
        this.gP = gP;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80_bold = new Font("Arial", Font.BOLD, 80);
        OBJ_Key key = new OBJ_Key();
        keyImage = key.image;
    }

    public void showMessage(String msg) {
        message = msg;
        messageOn = true;

    }
    public void draw(Graphics2D g2) {

        if(gameFinished == true) {

            g2.setFont(arial_40);
            g2.setColor(Color.white);

            String text;
            int textLength;
            int x;
            int y;

            text = "You found the treasure chest!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x = gP.screenWidth / 2 - textLength / 2;
            y = gP.screenHeight / 2 - (gP.tileSize * 3);
            g2.drawString(text,x,y);

            text = "Your time is : " + dFormat.format(playTime) + "!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x = gP.screenWidth / 2 - textLength / 2;
            y = gP.screenHeight / 2 + (gP.tileSize * 4);
            g2.drawString(text,x,y);



            g2.setFont(arial_80_bold);
            g2.setColor(Color.yellow);
            text = "Congratulations!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x = gP.screenWidth / 2 - textLength / 2;
            y = gP.screenHeight / 2 + (gP.tileSize * 2);
            g2.drawString(text,x,y);

            gP.gameThread = null;





        }
        else{
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(keyImage, gP.tileSize/2, gP.tileSize/2, gP.tileSize, gP.tileSize, null);
            g2.drawString("x " + gP.player.hasKey,74 ,65 );

            //Time
            playTime +=(double)1/60;
            g2.drawString("Time " + dFormat.format(playTime),gP.tileSize * 12 ,65 );

            //Message
            if(messageOn) {
                g2.setFont(g2.getFont().deriveFont(20f));
                g2.drawString(message, gP.tileSize/2 ,gP.tileSize/2 * 5);

                messageCounter++;
                if(messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }

        }


    }

}
