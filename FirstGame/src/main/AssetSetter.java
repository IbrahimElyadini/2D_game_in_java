package main;

import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_Boot;

public class AssetSetter {
    GamePanel gP;
    public AssetSetter(GamePanel gP) {
        this.gP = gP;
    }

    public void setObject() {
        gP.obj[0] = new OBJ_Key();
        gP.obj[0].worldX = 23 * gP.tileSize;
        gP.obj[0].worldY = 7 * gP.tileSize;

        gP.obj[1] = new OBJ_Key();
        gP.obj[1].worldX = 23 * gP.tileSize;
        gP.obj[1].worldY = 40 * gP.tileSize;

        gP.obj[2] = new OBJ_Key();
        gP.obj[2].worldX = 37 * gP.tileSize;
        gP.obj[2].worldY = 7 * gP.tileSize;

        gP.obj[3] = new OBJ_Door();
        gP.obj[3].worldX = 10 * gP.tileSize;
        gP.obj[3].worldY = 11 * gP.tileSize;

        gP.obj[4] = new OBJ_Door();
        gP.obj[4].worldX = 8 * gP.tileSize;
        gP.obj[4].worldY = 28 * gP.tileSize;

        gP.obj[5] = new OBJ_Door();
        gP.obj[5].worldX = 12 * gP.tileSize;
        gP.obj[5].worldY = 22 * gP.tileSize;

        gP.obj[6] = new OBJ_Chest();
        gP.obj[6].worldX = 10 * gP.tileSize;
        gP.obj[6].worldY = 7 * gP.tileSize;

        gP.obj[7] = new OBJ_Boot();
        gP.obj[7].worldX = 37 * gP.tileSize;
        gP.obj[7].worldY = 42 * gP.tileSize;

    }

}
