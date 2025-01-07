package object;

import javax.imageio.ImageIO;
import java.io.IOException;

//credits:
//key sprite from: https://opengameart.org/content/rpg-items-0
//made by LUNARSIGNALS

public class OBJ_Key extends SuperObject{


    public OBJ_Key(){


        name = "Key";
        try{
            image = ImageIO.read(getClass().getClassLoader().getResource("object/key.png"));

        }
        catch(IOException e){
            e.printStackTrace();

        }

    }
}
