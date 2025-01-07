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
    public int checkObject(Entity entity, boolean player) {

        int index = 999;

        for(int i = 0; i < gP.obj.length; i++){
            if(gP.obj[i] != null){
                //get entity solid area position
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                //get the object's solid area position
                gP.obj[i].solidArea.x = gP.obj[i].worldX + gP.obj[i].solidArea.x;
                gP.obj[i].solidArea.y = gP.obj[i].worldY + gP.obj[i].solidArea.y;

                switch(entity.direction){
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gP.obj[i].solidArea)){
                            if(gP.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;

                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gP.obj[i].solidArea)){
                            if(gP.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;

                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gP.obj[i].solidArea)){
                            if(gP.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;

                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gP.obj[i].solidArea)){
                            if(gP.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;

                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gP.obj[i].solidArea.x = gP.obj[i].solidAreaDefaultX;
                gP.obj[i].solidArea.y = gP.obj[i].solidAreaDefaultY;

            }
        }

        return index;
    }
}
