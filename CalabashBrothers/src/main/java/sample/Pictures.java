package sample;
import javafx.scene.image.Image;
import java.awt.*;
import java.util.ArrayList;
public class Pictures {
    Pictures(){
    };
    public static ArrayList<Image> pic_creaturs = new ArrayList<>();
    public static ArrayList<Image> pic_creaturs_death = new ArrayList<>();
    public static Image pic_background =new Image("images/1.jpg");
    public final static String[] names = {"huluwa1","huluwa2","huluwa3","huluwa4",

            "huluwa5","huluwa6","huluwa7","grandpa",

            "scorption","snake", "followers"};

    public static void initimages()
    {
        for(String x:names) {

            pic_creaturs.add(new Image("images/"+x+".png"));
            pic_creaturs_death.add(new Image("images/"+x+"death.png"));
        }

    }
}
