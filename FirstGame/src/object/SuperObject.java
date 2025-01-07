package object;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;


    public void draw(Graphics2D g2, GamePanel gP) {

        int screenX = worldX - gP.player.worldX + gP.player.screenX;
        int screenY = worldY - gP.player.worldY + gP.player.screenY;

        if( worldX + gP.tileSize > gP.player.worldX - gP.player.screenX
                && worldX - gP.tileSize < gP.player.worldX + gP.player.screenX
                && worldY + gP.tileSize > gP.player.worldY - gP.player.screenY
                && worldY - gP.tileSize < gP.player.worldY + gP.player.screenY ) {

            g2.drawImage(image, screenX, screenY, gP.tileSize, gP.tileSize, null);

        }


    }


}
