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

    public int hasKey = 0;

    public Player(GamePanel gP, KeyHandler keyH) {
        this.gP = gP;
        this.keyH = keyH;

        screenX = gP.screenWidth / 2 - gP.tileSize / 2;
        screenY = gP.screenHeight / 2 - gP.tileSize / 2;

        solidArea = new Rectangle(8, 16, 32, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        worldX = gP.tileSize * 23;
        worldY = gP.tileSize * 21;
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
            }
            else if(keyH.downPressed == true) {
                direction = "down";
            }
            else if(keyH.leftPressed == true) {
                direction = "left";
            }
            else if(keyH.rightPressed == true) {
                direction = "right";
            }

            //Check Tile collision
            collisionOn = false;
            gP.collisionChecker.checkTile(this);

            //check object collision
            int objectIndex = gP.collisionChecker.checkObject(this, true);
            pickUpObject(objectIndex);

            //If collision is false, player can move
            if(collisionOn == false) {
                switch (direction){
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;

                }
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

    public void pickUpObject(int index) {
        if(index != 999){

            String objectName = gP.obj[index].name;
            switch(objectName){
                case "Key":
                    gP.playSound(1);
                    hasKey++;
                    gP.obj[index] = null;
                    gP.ui.showMessage("You picked up a key!");

                    break;
                case "Door":
                    if(hasKey > 0){
                        gP.playSound(3);
                        hasKey--;
                        gP.obj[index] = null;
                        gP.ui.showMessage("You opened a door!");
                    }
                    else{
                        gP.ui.showMessage("You need a key!");
                    }

                    break;
                case "Chest":
                    gP.ui.gameFinished = true;
                    gP.ui.showMessage("You have found the chest!");
                    gP.stopMusic();
                    gP.playSound(4);
                    break;
                case "Boot":
                    gP.playSound(2);
                    speed += 2;
                    gP.obj[index] = null;
                    gP.ui.showMessage("The boots make you faster!");
                    break;
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
