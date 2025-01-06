package main;
import entity.Entity;

public class CollisionChecker {

    GamePanel gP;
    public CollisionChecker(GamePanel gP) {
        this.gP = gP;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gP.tileSize;
        int entityRightCol = entityRightWorldX / gP.tileSize;
        int entityTopRow = entityTopWorldY / gP.tileSize;
        int entityBottomRow = entityBottomWorldY / gP.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction){
            case "up":
                entityTopRow = ( entityTopWorldY - entity.speed ) / gP.tileSize;
                tileNum1 = gP.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gP.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(gP.tileM.tile[tileNum1].collision == true || gP.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = ( entityBottomWorldY + entity.speed ) / gP.tileSize;
                tileNum1 = gP.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gP.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gP.tileM.tile[tileNum1].collision == true || gP.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = ( entityLeftWorldX - entity.speed ) / gP.tileSize;
                tileNum1 = gP.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gP.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(gP.tileM.tile[tileNum1].collision == true || gP.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = ( entityRightWorldX + entity.speed ) / gP.tileSize;
                tileNum1 = gP.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gP.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gP.tileM.tile[tileNum1].collision == true || gP.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
        }

    }
}
