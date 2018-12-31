package sample;

import javafx.scene.layout.AnchorPane;

import java.awt.*;

public class Replayer extends Thread{
    public void getinformation(AnchorPane anchorPane)
    {
        Formation formation=new Formation();
        formation.setgrandpa();
        formation.setsnake();
        switch (Creature.replayformation[0])
        {
            case 0:formation.singlelinearry(true);break;
            case 1:formation.heyiarry(true);break;
            case 2:formation.yanxianarry(true);break;
            case 3:formation.fangtongarray(true);break;
            case 4 :formation.fengshiarray(true);break;
        }
        switch (Creature.replayformation[1])
        {
            case 0:formation.singlelinearry(false);break;
            case 1:formation.heyiarry(false);break;
            case 2:formation.yanxianarry(false);break;
            case 3:formation.fangtongarray(false);break;
            case 4:formation.fengshiarray(false);break;
        }
        formation.setleftviews();
        formation.setrightviews();
        for(int i=0;i<Battleground.Maxcalabashbrothers+Formation.numbers+3;i++)
        {
            anchorPane.getChildren().add(Formation.beengs[i].imageView);
        }
    }
    public  void run()
    {
       int pcount=Creature.replaycount;
       //System.out.println(Creature.replay[0][0]+"REPLY"+Creature.replay[0][1]);

       int i=0;
       while (i<pcount) {
          if(Creature.replay[i][1]==0)
              Formation.beengs[Creature.replay[i][0]].moveto(Creature.replay[i][2], Creature.replay[i][3]);
          else if(Creature.replay[i][1]==1)
          {
              Creature.replaycount=i;
              Formation.beengs[Creature.replay[i][0]].pk(Creature.replay[i][2], Creature.replay[i][3]);
          }
          try {
              sleep(200);
          }
          catch (InterruptedException e)
          {
              e.printStackTrace();
          }
          i++;
       }
       Creature.isreplay=false;
       Creature.replaycount=0;
       Creature.round++;
        /*
        for(int i=0;i<pcount;i++)
        {
            if(Creature.replay[i][1]==0) {
                System.out.println(Formation.beengs[Creature.replay[i][0]].NO);
                Formation.beengs[Creature.replay[i][0]].moveto(Creature.replay[i][2], Creature.replay[i][3]);


            }
            else if(Creature.replay[i][1]==1)
            {
                Creature.replaycount=i;
                Formation.beengs[Creature.replay[i][0]].pk(Creature.replay[i][2], Creature.replay[i][3]);

            }
        }
        */

    }

}
