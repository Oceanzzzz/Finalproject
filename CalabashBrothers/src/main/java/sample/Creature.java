package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.*;
import java.awt.*;
import java.lang.Math;
import java.util.Random;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

class   Creature extends Thread {
    public int NO;
    public boolean isalive;
    public int px;
    public int py;
    public boolean function;
    public ImageView imageView;
    public Image image;
    public static boolean isend=false;
    public static String a = new String("A");
    public static int turn = 0;
    public static int [][]replay;
    public static int []replayformation;
    public static int replaycount=0;
    public static boolean isreplay=false;
    public static boolean isbattling=false;
    public static int round=0;
    public static Label label;
    public static int [][]direction=new int [][] {{1,0},{0,1},{-1,0},{0,-1}};
    //public static int vx;
    //public static int vy;
    Creature() {
        px = -1;
        py = -1;
        imageView = null;
        image = null;
        isalive = true;
    }

    public void moveto(int tx, int ty) {
        if (!isreplay) {

            replay[replaycount][0] = turn;
            replay[replaycount][1] = 0;
            replay[replaycount][2] = tx;
            replay[replaycount][3] = ty;
            replay[replaycount][4] = 0;
            replaycount++;
        }

        int x=px,y=py;

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(200),imageView);
        Battleground.ground[tx][ty]=Battleground.ground[px][py];
        Battleground.ground[px][py]=null;
        //System.out.println(rytovy());
        //System.out.println(imageView.getLayoutY());
        translateTransition.setFromX(rytovy()-imageView.getLayoutX());
        translateTransition.setToX(rytovy()-imageView.getLayoutX()+76*(ty-y));
        translateTransition.setFromY(rxtovx()-imageView.getLayoutY());
        translateTransition.setToY(rxtovx()-imageView.getLayoutY()+76*(tx-x));
        px = tx;
        py = ty;
        translateTransition.play();

    }

    public int getPx() {
        return px;
    }

    public int getPy() {
        return py;
    }

    public int getNO() {
        return NO;
    }

    public void setPx(int x) {
        px = x;
    }

    public void setPy(int y) {
        py = y;
    }

    public void setxy(int x, int y) {
        px = x;
        py = y;
    }

    public void setImageView(Image image) {
        imageView = new ImageView(image);
        imageView.setFitWidth(76);
        imageView.setFitHeight(76);
        imageView.setLayoutX(rytovy());
        imageView.setLayoutY(rxtovx());
    }

    public int rxtovx() {
        return (128 + 76 * px);
    }

    public int rytovy() {
        return (240 + 76 * py);
    }
    public void isinbattle() {
       /* while (turn<Battleground.Maxcalabashbrothers + Formation.numbers + 3)
        {
        if (turn < 7) {
            while (Battleground.calabashbrothers[turn].isalive == false && turn < 7)
                turn=(turn+1)%(Battleground.Maxcalabashbrothers+Formation.numbers+3);
            if (turn != 7)
                return;
        }
        if (turn == 7) {
            if (Battleground.grandpa.isalive == false)
                turn=(turn+1)%(Battleground.Maxcalabashbrothers+Formation.numbers+3);
            else
                return;
        }

        if (turn == 8) {
            if (Battleground.scorpion.isalive == false)
                turn=(turn+1)%(Battleground.Maxcalabashbrothers+Formation.numbers+3);
            else
                return;
        }
        if (turn == 9) {
            if (Battleground.snake.isalive == false)
                turn=(turn+1)%(Battleground.Maxcalabashbrothers+Formation.numbers+3);
            else
                return;
        }
        if (turn >= 10) {
            while (turn < 10 + Formation.numbers && Battleground.followers[turn - 10].isalive == false) {
                turn=(turn+1)%(Battleground.Maxcalabashbrothers+Formation.numbers+3);
                if(turn==0)
                    break;
            }
            if (turn!=0)
               return;

        }
        }
        */
       while (turn<Battleground.Maxcalabashbrothers + Formation.numbers + 3&&Formation.beengs[turn].isalive==false)
       {
               turn=(turn+1)%(Battleground.Maxcalabashbrothers+Formation.numbers+3);

       }
    }
    public void isend()
    {
        int count=0,count1=0;
        for(int i=0;i<Battleground.Maxcalabashbrothers + Formation.numbers + 3;i++)
        {
            if(Formation.beengs[i].function)
            {
                if(Formation.beengs[i].isalive)
                    count++;
            }
            else
            {
               if(Formation.beengs[i].isalive)
                   count1++;
            }
        }
        if(count==0||count1==0)
        {
            isend=true;
            isbattling=false;
            round++;
           /* if(count==0)
                label=new Label("CalabashBrothers Win!!");
            if(count1==0)
                label=new Label("CalabashBrothers Win!!");
            label.setLayoutX(650);
            label.setLayoutY(300);
            label.setScaleX(3);
            label.setScaleY(3);
            label.setBackground(new Background(new BackgroundFill(new Color(0.5,0.5,0.5,0.5),null,null)));
            Main.root.getChildren().add(label);
            */
        }
    }
    public void pk(int dx,int dy)
    {
        Random random=new Random();
        int x2 = random.nextInt(2);
        if (!isreplay) {

            replay[replaycount][0] = turn;
            replay[replaycount][1] = 1;
            replay[replaycount][2] = dx;
            replay[replaycount][3] = dy;
            replay[replaycount][4]=x2;
            replaycount++;
        }
        if(isreplay)
            x2=replay[replaycount][4];
        if (x2 == 0) {
            isalive = false;
            if (NO >= 10)
                imageView.setImage(Pictures.pic_creaturs_death.get(10));
            else
                imageView.setImage(Pictures.pic_creaturs_death.get(NO));
            Battleground.ground[px][py] = null;
            System.out.println(Battleground.ground[dx][dy].NO + "BEATEN" + NO);
        }
        if (x2 == 1) {
            Battleground.ground[dx][dy].isalive = false;
            if(Battleground.ground[dx][dy].NO>=10)
                Battleground.ground[dx][dy].imageView.setImage(Pictures.pic_creaturs_death.get(10));
            else
            Battleground.ground[dx][dy].imageView.setImage(Pictures.pic_creaturs_death.get(Battleground.ground[dx][dy].NO));
            System.out.println(NO + "BEATEN" + Battleground.ground[dx][dy].NO);
            Battleground.ground[dx][dy] = null;

        }
    }
    public void randmove() {
        Random random = new Random();
        int x1 = random.nextInt(4);
        System.out.println(x1);
        if (x1 == 0 && px - 1 >= 0) {
            if (Battleground.ground[px - 1][py] == null) {
                //System.out.println(px-1);
                moveto(px - 1, py);
            } else if (Battleground.ground[px - 1][py].function != function) {
                pk(px - 1, py);

            }

        }
        if (x1 == 1 && py + 1 <= 14) {
            if (Battleground.ground[px][py + 1] == null) {
                System.out.println(py + 1);
                moveto(px, py + 1);
            } else if (Battleground.ground[px][py + 1].function != function) {
                pk(px, py + 1);

            }
        }
        if (x1 == 2 && px + 1 <= 8) {
            if (Battleground.ground[px + 1][py] == null) {
                System.out.println(px + 1);
                moveto(px + 1, py);

            } else if (Battleground.ground[px + 1][py].function != function) {
                pk(px + 1, py);

            }
        }
        if (x1 == 3 && py - 1 >= 0) {
            if (Battleground.ground[px][py - 1] == null) {
                System.out.println(py - 1);
                moveto(px, py - 1);

            } else if (Battleground.ground[px][py - 1].function != function) {
                pk(px, py - 1);
            }

        }
    }

    public void run() {


        while (isalive&&!isend) {
            synchronized (a) {

                isinbattle();

                while (NO != turn) {
                    try {
                        a.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                /*if(isalive==false)
                {
                    turn=(turn+1)%(Battleground.Maxcalabashbrothers+Formation.numbers+3);
                    a.notifyAll();
                }
                */
                isend();
                if (isend) {
                    return;
                }
                if (!isalive) {
                    turn = (turn + 1) % (Battleground.Maxcalabashbrothers + Formation.numbers + 3);
                    isinbattle();
                    a.notifyAll();
                    return;
                }
                Random random = new Random();
                System.out.println(Thread.currentThread().getName());
                int y1=random.nextInt(2);
                if(y1==0)
                    randmove();
                else {
                    if (function == false) {
                        int count = 0, sum = 30;
                        for (int i = 0; i < Battleground.Maxcalabashbrothers + 1; i++) {
                            if (Formation.beengs[i].isalive) {
                                if (sum > java.lang.Math.abs(Formation.beengs[i].px - px) + java.lang.Math.abs(Formation.beengs[i].py - py)) {
                                    sum = java.lang.Math.abs(Formation.beengs[i].px - px) + java.lang.Math.abs(Formation.beengs[i].py - py);
                                    count = i;
                                }
                            }
                        }
                        System.out.println("sum=" + sum);
                        System.out.println("count=" + count);
                        if (sum == 1) {
                            int dx = Formation.beengs[count].px, dy = Formation.beengs[count].py;
                            System.out.println("dx=" + dx);
                            System.out.println("dy=" + dy);
                            System.out.println("px=" + px);
                            System.out.println("py=" + py);
                            pk(dx, dy);

                        } else if (sum > 1) {
                            if (java.lang.Math.abs(Formation.beengs[count].px - px) >= java.lang.Math.abs(Formation.beengs[count].py - py)) {
                                if (Formation.beengs[count].px - px > 0) {
                                    if (Battleground.ground[px + 1][py] == null) {
                                        moveto(px + 1, py);
                                    }
                                } else {
                                    if (Battleground.ground[px - 1][py] == null) {
                                        moveto(px - 1, py);
                                    }
                                }
                            } else {
                                if (Formation.beengs[count].py - py > 0) {
                                    if (Battleground.ground[px][py + 1] == null) {
                                        moveto(px, py + 1);
                                    }
                                } else {
                                    if (Battleground.ground[px][py - 1] == null) {
                                        moveto(px, py - 1);
                                    }
                                }
                            }
                        }

                    } else {
                        int count = 0, sum = 30;
                        for (int i = 8; i < Battleground.Maxcalabashbrothers + Formation.numbers + 3; i++) {
                            if (Formation.beengs[i].isalive) {
                                if (sum > java.lang.Math.abs(Formation.beengs[i].px - px) + java.lang.Math.abs(Formation.beengs[i].py - py)) {
                                    sum = java.lang.Math.abs(Formation.beengs[i].px - px) + java.lang.Math.abs(Formation.beengs[i].py - py);
                                    count = i;
                                }
                            }
                        }
                        System.out.println("sum=" + sum);
                        if (sum == 1) {
                            int dx = Formation.beengs[count].px, dy = Formation.beengs[count].py;
                            pk(dx, dy);
                        } else if (sum > 1) {
                            if (java.lang.Math.abs(Formation.beengs[count].px - px) >= java.lang.Math.abs(Formation.beengs[count].py - py)) {
                                if (Formation.beengs[count].px - px > 0) {
                                    if (Battleground.ground[px + 1][py] == null) {
                                        moveto(px + 1, py);
                                    }
                                } else {
                                    if (Battleground.ground[px - 1][py] == null) {
                                        moveto(px - 1, py);
                                    }
                                }
                            } else {
                                if (Formation.beengs[count].py - py > 0) {
                                    if (Battleground.ground[px][py + 1] == null) {
                                        moveto(px, py + 1);
                                    }
                                } else {
                                    if (Battleground.ground[px][py - 1] == null) {
                                        moveto(px, py - 1);
                                    }
                                }
                            }
                        }
                    }
                }


                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println("hello");
                //System.out.println(px);
                //System.out.println(py);
                //System.out.println(Battleground.ground[px][py].px);
                //System.out.println(Battleground.ground[px][py].py);
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 15; j++) {
                        if (Battleground.ground[i][j] != null) {
                            if (Battleground.ground[i][j].function)
                                System.out.print("1");
                            else
                                System.out.print("2");
                        } else
                            System.out.print("0");
                    }
                    System.out.println();
                }
                System.out.print(Formation.beengs[NO].px + "   " + Formation.beengs[NO].py);
                //System.out.println(Formation.numbers);
                turn = (turn + 1) % (Battleground.Maxcalabashbrothers + Formation.numbers + 3);
                //System.out.println(imageView.getLayoutX());
                //System.out.println(imageView.getLayoutY());
                //imageView.setLayoutX(rytovy());
                //imageView.setLayoutY(rxtovx());
                isinbattle();
                a.notifyAll();

            }
        }
    }

}


class Calabashbrothers extends Creature {
    public hulubrother calabashbrother;

    enum hulubrother {
        one("老大", "红色"),
        two("老二", "橙色"),
        three("老三", "黄色"),
        four("老四", "绿色"),
        five("老五", "青色"),
        six("老六", "蓝色"),
        seven("老七", "紫色");
        private final String name;
        private final String colour;

        hulubrother(String name, String colour) {
            this.name = name;
            this.colour = colour;
        }
    }

    Calabashbrothers(hulubrother calabashbrother) {
        this.calabashbrother = calabashbrother;
        NO = calabashbrother.ordinal();
        function=true;
    }
}
class Grandpa extends Creature {
    public  void cheerup()
    {return;}
    Grandpa()
    {
        NO=7;
        function=true;
    }
}

class Scorpion extends Creature{
    Scorpion()
    {
        NO=8;
        function=false;
    }
}
class Snake extends Creature{
    Snake()
    {
        NO=9;
        function=false;
    }
}
class Followers extends Creature{
   public static int begin=10;
    Followers()
    {
        NO=begin;
        begin++;
        function=false;
    }
}
