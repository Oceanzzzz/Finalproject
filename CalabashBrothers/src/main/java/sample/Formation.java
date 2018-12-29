package sample;

public class Formation {
    public static int numbers;
    public static Creature[] beengs = new Creature[Battleground.Maxfollowers + Battleground.Maxcalabashbrothers + 3];

    public void setleftviews() {
        for (int i = 0; i < Battleground.Maxcalabashbrothers; i++) {
            Battleground.calabashbrothers[i].image = Pictures.pic_creaturs.get(i);
            Battleground.calabashbrothers[i].setImageView(Battleground.calabashbrothers[i].image);
            beengs[i] = Battleground.calabashbrothers[i];
        }
        Battleground.grandpa.image = Pictures.pic_creaturs.get(7);
        Battleground.grandpa.setImageView(Battleground.grandpa.image);
        beengs[7] = Battleground.grandpa;

    }

    public void setrightviews() {
        Battleground.scorpion.image = Pictures.pic_creaturs.get(8);
        Battleground.scorpion.setImageView(Battleground.scorpion.image);
        beengs[8] = Battleground.scorpion;
        Battleground.snake.image = Pictures.pic_creaturs.get(9);
        Battleground.snake.setImageView(Battleground.snake.image);
        beengs[9] = Battleground.snake;
        for (int i = 0; i < numbers; i++) {
            Battleground.followers[i].image = Pictures.pic_creaturs.get(10);
            Battleground.followers[i].setImageView(Battleground.followers[i].image);
            beengs[i + 10] = Battleground.followers[i];
        }
    }

    public void setgrandpa() {
        Battleground.ground[4][0] = Battleground.grandpa;
        Battleground.grandpa.setPx(4);
        Battleground.grandpa.setPy(0);
    }

    public void setsnake() {
        Battleground.ground[4][14] = Battleground.snake;
        Battleground.snake.setPx(4);
        Battleground.snake.setPy(14);
    }

    public void clearleft() {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j <= 7; j++)
                Battleground.ground[i][j] = null;
    }

    public void clearright() {
        for (int i = 0; i < 9; i++)
            for (int j = 8; j < 15; j++)
                Battleground.ground[i][j] = null;
    }

    public void singlelinearry(boolean direction) {
        if (direction) {
            clearleft();
            setgrandpa();
            for (int i = 0; i < 7; i++) {
                Battleground.ground[1 + i][2] = Battleground.calabashbrothers[i];
                Battleground.calabashbrothers[i].setPx(1 + i);
                Battleground.calabashbrothers[i].setPy(2);
                System.out.println(Battleground.calabashbrothers[i].getPx());
            }
        } else {
            clearright();
            setsnake();
            numbers = 6;
            for (int i = 0; i < numbers + 1; i++) {
                if (i < 3) {
                    Battleground.ground[i + 1][11] = Battleground.followers[i];
                    Battleground.followers[i].setPx(i + 1);
                    Battleground.followers[i].setPy(11);
                }
                if (i == 3) {
                    Battleground.ground[i + 1][11] = Battleground.scorpion;
                    Battleground.scorpion.setPx(i + 1);
                    Battleground.scorpion.setPy(11);
                }
                if (i > 3) {
                    Battleground.ground[i + 1][11] = Battleground.followers[i - 1];
                    Battleground.followers[i - 1].setPx(i + 1);
                    Battleground.followers[i - 1].setPy(11);
                }
            }
        }
    }

    public void heyiarry(boolean direction) {
        if (direction) {
            clearleft();
            setgrandpa();
            int[][] loc = new int[][]{{4, 4}, {3, 3}, {5, 3}, {2, 2}, {6, 2}, {1, 1}, {7, 1}};
            for (int i = 0; i < Battleground.Maxcalabashbrothers; i++) {
                Battleground.ground[loc[i][0]][loc[i][1]] = Battleground.calabashbrothers[i];
                Battleground.calabashbrothers[i].setPx(loc[i][0]);
                Battleground.calabashbrothers[i].setPy(loc[i][1]);
            }

        }
        if (!direction) {
            clearright();
            setsnake();
            numbers = 6;
            int[][] loc = new int[][]{{3, 10}, {2, 11}, {1, 12}, {5, 10}, {6, 11}, {7, 12}};
            Battleground.ground[4][9] = Battleground.scorpion;
            Battleground.scorpion.setPx(4);
            Battleground.scorpion.setPy(9);
            for (int i = 0; i < numbers; i++) {
                Battleground.ground[loc[i][0]][loc[i][1]] = Battleground.followers[i];
                Battleground.followers[i].setPx(loc[i][0]);
                Battleground.followers[i].setPy(loc[i][1]);
                System.out.println(Battleground.followers[i].getPx());
            }
        /*
        Battleground.ground[5][10]=Battleground.followers[0];
        Battleground.ground[4][11]=Battleground.followers[1];
        Battleground.ground[3][12]=Battleground.followers[2];
        Battleground.ground[7][10]=Battleground.followers[3];
        Battleground.ground[8][11]=Battleground.followers[4];
        Battleground.ground[9][12]=Battleground.followers[5];
        */
        }
    }

    public void yanxianarry(boolean direction) {
        if (direction) {
            clearleft();
            setgrandpa();
            int[][] loc = new int[][]{{4, 4}, {3, 3}, {2, 2}, {1, 1}, {5, 5}, {6, 6}, {7, 7}};
            for (int i = 0; i < Battleground.Maxcalabashbrothers; i++) {
                Battleground.ground[loc[i][0]][loc[i][1]] = Battleground.calabashbrothers[i];
                Battleground.calabashbrothers[i].setPx(loc[i][0]);
                Battleground.calabashbrothers[i].setPy(loc[i][1]);
            }
        } else {
            clearright();
            setsnake();
            numbers = 6;
            int[][] loc = new int[][]{{3, 10}, {2, 9}, {1, 8}, {5, 12}, {6, 13}, {7, 14}};
            Battleground.ground[4][11] = Battleground.scorpion;
            Battleground.scorpion.setPx(4);
            Battleground.scorpion.setPy(11);
            for (int i = 0; i < numbers; i++) {
                Battleground.ground[loc[i][0]][loc[i][1]] = Battleground.followers[i];
                Battleground.followers[i].setPx(loc[i][0]);
                Battleground.followers[i].setPy(loc[i][1]);
                System.out.println(Battleground.followers[i].getPx());
            }
        }
    }

    public void fangtongarray(boolean direction) {
        if (direction) {
            clearleft();
            setgrandpa();
            int[][] loc = new int[][]{{4, 4}, {3, 3}, {2, 2}, {3,1}, {5, 3}, {6, 2}, {5, 1}};
            for (int i = 0; i < Battleground.Maxcalabashbrothers; i++) {
                Battleground.ground[loc[i][0]][loc[i][1]] = Battleground.calabashbrothers[i];
                Battleground.calabashbrothers[i].setPx(loc[i][0]);
                Battleground.calabashbrothers[i].setPy(loc[i][1]);
            }
        } else {
            clearright();
            setsnake();
            numbers = 6;
            int[][] loc = new int[][]{{3, 11}, {2, 12}, {3, 13}, {5, 11}, {6, 12}, {5, 13}};
            Battleground.ground[4][10] = Battleground.scorpion;
            Battleground.scorpion.setPx(4);
            Battleground.scorpion.setPy(10);
            for (int i = 0; i < numbers; i++) {
                Battleground.ground[loc[i][0]][loc[i][1]] = Battleground.followers[i];
                Battleground.followers[i].setPx(loc[i][0]);
                Battleground.followers[i].setPy(loc[i][1]);
                System.out.println(Battleground.followers[i].getPx());
            }
        }

    }
    public  void fengshiarray(boolean direction)
    {
        if (direction) {
            clearleft();
            setgrandpa();
            int[][] loc = new int[][]{{4, 4}, {3, 3}, {2, 2}, {5,3}, {6, 2}, {4, 3}, {4, 2}};
            for (int i = 0; i < Battleground.Maxcalabashbrothers; i++) {
                Battleground.ground[loc[i][0]][loc[i][1]] = Battleground.calabashbrothers[i];
                Battleground.calabashbrothers[i].setPx(loc[i][0]);
                Battleground.calabashbrothers[i].setPy(loc[i][1]);
            }
        } else {
            clearright();
            setsnake();
            numbers = 7;
            int[][] loc = new int[][]{{3, 11}, {2, 12}, {5, 11}, {6, 12}, {4, 11}, {4, 12},{4,13}};
            Battleground.ground[4][10] = Battleground.scorpion;
            Battleground.scorpion.setPx(4);
            Battleground.scorpion.setPy(10);
            for (int i = 0; i < numbers; i++) {
                Battleground.ground[loc[i][0]][loc[i][1]] = Battleground.followers[i];
                Battleground.followers[i].setPx(loc[i][0]);
                Battleground.followers[i].setPy(loc[i][1]);
                System.out.println(Battleground.followers[i].getPx());
            }
        }
    }
}
   /* public void heyiarry(Creature []creature,Battleground battleground)
    {
        battleground.getlocationinformation()[6][9]=creature[8].tip;
        battleground.getlocationinformation()[5][10]=creature[10].tip;
        battleground.getlocationinformation()[4][11]=creature[10].tip;
        battleground.getlocationinformation()[3][12]=creature[10].tip;
        battleground.getlocationinformation()[7][10]=creature[10].tip;
        battleground.getlocationinformation()[8][11]=creature[10].tip;
        battleground.getlocationinformation()[9][12]=creature[10].tip;

    }


    public  void hengearry(Creature []creature,Battleground battleground)
    {
        battleground.getlocationinformation()[6][9]=creature[8].tip;
        battleground.getlocationinformation()[5][10]=creature[10].tip;
        battleground.getlocationinformation()[4][9]=creature[10].tip;
        battleground.getlocationinformation()[3][10]=creature[10].tip;
        battleground.getlocationinformation()[7][10]=creature[10].tip;
        battleground.getlocationinformation()[8][9]=creature[10].tip;
        battleground.getlocationinformation()[9][10]=creature[10].tip;
    }
    public  void yulinarray(Creature []creature,Battleground battleground)
    {
        battleground.getlocationinformation()[6][9]=creature[8].tip;
        battleground.getlocationinformation()[5][10]=creature[10].tip;
        battleground.getlocationinformation()[6][10]=creature[10].tip;
        battleground.getlocationinformation()[7][10]=creature[10].tip;
        battleground.getlocationinformation()[4][11]=creature[10].tip;
        battleground.getlocationinformation()[5][11]=creature[10].tip;
        battleground.getlocationinformation()[6][11]=creature[10].tip;
        battleground.getlocationinformation()[7][11]=creature[10].tip;
        battleground.getlocationinformation()[8][11]=creature[10].tip;
        battleground.getlocationinformation()[6][12]=creature[10].tip;
    }

    public void fangtongarray(Creature []creature,Battleground battleground)
    {
        battleground.getlocationinformation()[6][9]=creature[8].tip;
        battleground.getlocationinformation()[5][10]=creature[10].tip;
        battleground.getlocationinformation()[4][11]=creature[10].tip;
        battleground.getlocationinformation()[7][10]=creature[10].tip;
        battleground.getlocationinformation()[8][11]=creature[10].tip;
        battleground.getlocationinformation()[7][12]=creature[10].tip;
        battleground.getlocationinformation()[7][12]=creature[10].tip;
        battleground.getlocationinformation()[6][13]=creature[10].tip;
    }
    public  void yanyuearray(Creature []creature,Battleground battleground)
    {
        battleground.getlocationinformation()[6][9]=creature[8].tip;
        battleground.getlocationinformation()[6][8]=creature[10].tip;
        battleground.getlocationinformation()[6][10]=creature[10].tip;
        battleground.getlocationinformation()[7][9]=creature[10].tip;
        battleground.getlocationinformation()[7][8]=creature[10].tip;
        battleground.getlocationinformation()[7][10]=creature[10].tip;
        battleground.getlocationinformation()[5][9]=creature[10].tip;
        battleground.getlocationinformation()[5][8]=creature[10].tip;
        battleground.getlocationinformation()[5][10]=creature[10].tip;
        battleground.getlocationinformation()[4][10]=creature[10].tip;
        battleground.getlocationinformation()[8][10]=creature[10].tip;
        battleground.getlocationinformation()[3][11]=creature[10].tip;
        battleground.getlocationinformation()[4][11]=creature[10].tip;
        battleground.getlocationinformation()[8][11]=creature[10].tip;
        battleground.getlocationinformation()[9][11]=creature[10].tip;
    }
    public  void fengshiarray(Creature []creature,Battleground battleground)
    {
        battleground.getlocationinformation()[6][9]=creature[8].tip;
        for(int i=1;i<=3;i++)
        {
            battleground.getlocationinformation()[i+6][i+9]=creature[10].tip;
            battleground.getlocationinformation()[6-i][i+9]=creature[10].tip;
        }
        for(int i=1;i<=5;i++)
        {
            battleground.getlocationinformation()[6][i+9]=creature[10].tip;
        }
    }
    public  void setgrandpa(Creature []creature,Battleground battleground)
    {
        battleground.getlocationinformation()[6][0]=creature[7].tip;
    }
    public  void setsnake(Creature []creature,Battleground battleground)
    {
        battleground.getlocationinformation()[6][14]=creature[9].tip;
    }
}
*/