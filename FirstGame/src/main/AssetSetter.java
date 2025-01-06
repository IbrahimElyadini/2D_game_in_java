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
        gP.obj[0].worldX = 25 * gP.tileSize;
        gP.obj[0].worldY = 21 * gP.tileSize;

        gP.obj[1] = new OBJ_Key();
        gP.obj[1].worldX = 25 * gP.tileSize;
        gP.obj[1].worldY = 29 * gP.tileSize;

        gP.obj[2] = new OBJ_Door();
        gP.obj[2].worldX = 13 * gP.tileSize;
        gP.obj[2].worldY = 25 * gP.tileSize;

        gP.obj[3] = new OBJ_Door();
        gP.obj[3].worldX = 16 * gP.tileSize;
        gP.obj[3].worldY = 35 * gP.tileSize;

        gP.obj[4] = new OBJ_Chest();
        gP.obj[4].worldX = 25 * gP.tileSize;
        gP.obj[4].worldY = 28 * gP.tileSize;

        gP.obj[5] = new OBJ_Boot();
        gP.obj[5].worldX = 30 * gP.tileSize;
        gP.obj[5].worldY = 27 * gP.tileSize;

    }

}
