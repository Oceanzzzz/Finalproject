package sample;

import javafx.scene.image.Image;
import javafx.scene.image.*;

public class Battleground {
    public  static Creature [][]ground;
    public  static Calabashbrothers []calabashbrothers;
    public static int Maxcalabashbrothers=7;
    public  static Grandpa grandpa;
    public  static Scorpion scorpion;
    public  static Snake snake;
    public  static Followers []followers;
    public static int Maxfollowers=20;
    public static int maxlength=9;
    public static int maxheight=15;
    public  static void init() {
        ground = new Creature[maxlength][maxheight];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 15; j++)
                ground[i][j] = null;
        calabashbrothers = new Calabashbrothers[Maxcalabashbrothers];
        calabashbrothers[0] = new Calabashbrothers(Calabashbrothers.hulubrother.one);
        calabashbrothers[1] = new Calabashbrothers(Calabashbrothers.hulubrother.two);
        calabashbrothers[2] = new Calabashbrothers(Calabashbrothers.hulubrother.three);
        calabashbrothers[3] = new Calabashbrothers(Calabashbrothers.hulubrother.four);
        calabashbrothers[4] = new Calabashbrothers(Calabashbrothers.hulubrother.five);
        calabashbrothers[5] = new Calabashbrothers(Calabashbrothers.hulubrother.six);
        calabashbrothers[6] = new Calabashbrothers(Calabashbrothers.hulubrother.seven);

        Battleground.grandpa = new Grandpa();
        Battleground.scorpion = new Scorpion();
        Battleground.snake = new Snake();
        Battleground.followers = new Followers[Battleground.Maxfollowers];
        for (int i = 0; i < Battleground.Maxfollowers; i++) {
            Battleground.followers[i] = new Followers();
        }
        Creature.replay=new int[1000][5];
        Creature.replaycount=0;
        Creature.replayformation=new int[2];
        Formation.beengs=new Creature[Battleground.Maxfollowers + Battleground.Maxcalabashbrothers + 3];

    }


}
