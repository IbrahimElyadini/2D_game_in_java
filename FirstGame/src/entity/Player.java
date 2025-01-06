package entity;
import main.GamePanel;
import main.KeyHandler;
import tile.Tile;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gP;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gP, KeyHandler keyH) {
        this.gP = gP;
        this.keyH = keyH;

        screenX = gP.screenWidth / 2 - gP.tileSize / 2;
        screenY = gP.screenHeight / 2 - gP.tileSize / 2;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        worldX = gP.tileSize * 25;
        worldY = gP.tileSize * 25;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){

        //character sprites taken from: https://opengameart.org/content/overhead-action-rpg-hero
        //made by LUNARSIGNALS
        try{
            up1 = ImageIO.read(getClass().getClassLoader().getResource("player/player_up1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResource("player/player_up2.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResource("player/player_down1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResource("player/player_down2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResource("player/player_left1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResource("player/player_left2.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResource("player/player_right1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResource("player/player_right2.png"));
        }
        catch(IOException e){
            System.out.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void update() {
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {

            if(keyH.upPressed == true) {
                direction = "up";
                worldY -= speed;
            }
            else if(keyH.downPressed == true) {
                direction = "down";
                worldY += speed;
            }
            else if(keyH.leftPressed == true) {
                direction = "left";
                worldX -= speed;
            }
            else if(keyH.rightPressed == true) {
                direction = "right";
                worldX += speed;
            }
            spriteCounter++;
            if(spriteCounter > 12) {
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

        }

    }

    public void draw(Graphics2D g2) {


        BufferedImage image = null;

        switch(direction) {
            case "up":
                if(spriteNum == 1)
                    image = up1;
                else if(spriteNum == 2)
                    image = up2;
                break;
            case "down":
                if(spriteNum == 1)
                    image = down1;
                else if(spriteNum == 2)
                    image = down2;
                break;
            case "left":
                if(spriteNum == 1)
                    image = left1;
                else if(spriteNum == 2)
                    image = left2;
                break;
            case "right":
                if(spriteNum == 1)
                    image = right1;
                else if(spriteNum == 2)
                    image = right2;
                break;
        }
        g2.drawImage(image, screenX, screenY, gP.tileSize, gP.tileSize, null);

    }


}
