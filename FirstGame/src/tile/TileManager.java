package tile;
import tile.*;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;


//credits:
// background tiles from: https://opengameart.org/content/lpc-16x16-tiles-extended
//by rubberduck
// background tiles from: https://opengameart.org/content/16x16-tiles
// by Ogrebane



public class TileManager {

    GamePanel gP;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gP) {

        this.gP = gP;
        tile = new Tile[10];
        mapTileNum = new int[gP.maxWorldCol][gP.maxWorldRow];
        getTileImage();
        loadMap("maps/map02.txt");

    }

    public void getTileImage(){

        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getClassLoader().getResource("tiles/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getClassLoader().getResource("tiles/wall.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getClassLoader().getResource("tiles/water.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getClassLoader().getResource("tiles/earth.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getClassLoader().getResource("tiles/tree.png"));

            tile[5]  = new Tile();
            tile[5].image = ImageIO.read(getClass().getClassLoader().getResource("tiles/sand.png"));


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void loadMap(String map){
        try{
            InputStream is = getClass().getClassLoader().getResourceAsStream(map);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gP.maxWorldCol && row < gP.maxWorldRow) {
                String line = br.readLine();

                while(col < gP.maxWorldCol){
                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;

                }
                if(col == gP.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics g2){

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gP.maxWorldCol && worldRow < gP.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gP.tileSize;
            int worldY = worldRow * gP.tileSize;
            int screenX = worldX - gP.player.worldX + gP.player.screenX;
            int screenY = worldY - gP.player.worldY + gP.player.screenY;


            g2.drawImage(tile[tileNum].image, screenX, screenY, gP.tileSize, gP.tileSize, null);
            worldCol++;

            if(worldCol == gP.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }

        }



    }

}
