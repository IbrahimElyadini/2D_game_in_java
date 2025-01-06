package object;

import javax.imageio.ImageIO;
import java.io.IOException;

//credits:
//boot sprite from: https://opengameart.org/content/rpg-items-0
//made by LUNARSIGNALS

public class OBJ_Boot extends SuperObject{

    public OBJ_Boot(){

        name = "Boot";
        try{
            image = ImageIO.read(getClass().getClassLoader().getResource("object/boot.png"));

        }
        catch(IOException e){
            e.printStackTrace();

        }

    }

}
