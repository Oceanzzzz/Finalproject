package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;
import javafx.animation.Animation.*;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;


public class Main extends Application {

    public  static AnchorPane root = new AnchorPane();
    FileOutputStream fos=null;
    public static boolean choseformation=true;
    public static boolean firstshowleft=false;
    public static boolean firstshowright=false;
    @Override
    public void init() throws  Exception
    {
        super.init();
        Pictures.initimages();
        Battleground.init();
        Formation formation=new Formation();
        //formation.singlelinearry();
        //formation.heyiarry();
        //formation.setgrandpa();
        //formation.setsnake();

        formation.setgrandpa();
        formation.setsnake();
    }
    public void start(Stage primaryStage) throws Exception {
        //BorderPane root1 = new BorderPane();
        root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
        ImageView imageView = new ImageView();
        imageView.setImage(Pictures.pic_background);
        //root1.setCenter(imageView);
        imageView.setFitHeight(900);
        imageView.setFitWidth(1500);
        root.getChildren().add(imageView);

        /*for(int i=0;i <Battleground.Maxcalabashbrothers+Formation.numbers+3;i++)
            root.getChildren().add(Formation.beengs[i].imageView);
            */
        primaryStage.setTitle("葫芦娃大战蝎子精");
        primaryStage.setScene(new Scene(root, 1500, 900));
        primaryStage.show();

        /*TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000), Battleground.scorpion.imageView);
        translateTransition.setFromY(0);
        translateTransition.setToY(-76);
        //translateTransition.setCycleCount(4);
        //translateTransition.setAutoReverse(false);
        translateTransition.play();
        */
        root.requestFocus();
        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(Creature.isreplay);
                if (event.getCode() == KeyCode.SPACE&&!Creature.isbattling&&!Creature.isreplay&&firstshowright&&firstshowleft&&!Creature.isend) {
                    Creature.isbattling = true;
                    System.out.println("hello");
                    for (int i = 0; i < Battleground.Maxcalabashbrothers; i++) {
                        Battleground.calabashbrothers[i].start();
                    }
                    Battleground.grandpa.start();
                    Battleground.scorpion.start();
                    Battleground.snake.start();
                    for (int i = 0; i < Formation.numbers; i++) {
                        Battleground.followers[i].start();
                        System.out.println(Battleground.followers[i].NO);
                    }

                    // Battleground.calabashbrothers[0].start();
                }
                if (event.getCode() == KeyCode.S) {
                    if (Creature.isend && !Creature.isreplay && !Creature.isbattling) {
                        FileChooser fileChooser = new FileChooser();
                        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                        fileChooser.getExtensionFilters().add(extFilter);
                        fileChooser.setTitle("Open Resource File");


                        Stage s = new Stage();
                        //fileChooser.showOpenDialog(s);
                        File file = fileChooser.showSaveDialog(s);
                        //System.out.println(file);

                        BufferedWriter fos;
                        if (file == null)
                            return;
                        if (file.exists()) {//文件已存在，则删除覆盖文件
                            file.delete();
                        }


                        try {
                            FileWriter fw = new FileWriter(file.getAbsoluteFile());
                            fos = new BufferedWriter(fw);
                            fos.write(Creature.replayformation[0] + " "+Creature.replayformation[1]+"\r\n");
                            for (int i = 0; i < Creature.replaycount; i++) {
                                for (int j = 0; j < 5; j++) {
                                    fos.write(Creature.replay[i][j] + " ");
                                }
                                fos.write("\r\n");
                            }
                            fos.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String exportFilePath = file.getAbsolutePath();
                        System.out.println("导出文件的路径" + exportFilePath);
                    }
                }
                if (event.getCode() == KeyCode.L && !Creature.isreplay && !Creature.isbattling) {

                    FileChooser fileChooser = new FileChooser();
                    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                    fileChooser.getExtensionFilters().add(extFilter);
                    Stage s = new Stage();
                    String result = "";
                    File file = fileChooser.showOpenDialog(s);
                    BufferedReader reader = null;
                    if (file.exists()) {
                        if(Creature.round!=0) {
                            for (int i = 0; i < Battleground.Maxcalabashbrothers + Formation.numbers + 3; i++)
                                root.getChildren().removeAll(Formation.beengs[i].imageView);
                        }
                        System.out.print(Creature.round);
                        System.out.print(root.getChildren());
                        primaryStage.show();

                        Followers.begin = 10;
                        Battleground.init();
                        //Formation formation = new Formation();
                        //formation.singlelinearry();
                        //formation.heyiarry();
                        //formation.setgrandpa();
                        //formation.setsnake();
                        //formation.setviews();
                        /*for (int i = 0; i < Battleground.Maxcalabashbrothers + Formation.numbers + 3; i++)
                            root.getChildren().add(Formation.beengs[i].imageView);
                            */

                        //primaryStage.show();

                        try {
                            reader = new BufferedReader(new FileReader(file));
                            String isreader = null;
                            boolean flag=false;
                            while ((isreader = reader.readLine()) != null) {
                                String[] arr = isreader.split("\\s+");
                                if(!flag) {
                                    for (int i = 0; i < 2; i++)
                                        Creature.replayformation[i] = Integer.parseInt(arr[i]);
                                    flag=true;
                                }
                                else {
                                    for (int i = 0; i < 5; i++)
                                        Creature.replay[Creature.replaycount][i] = Integer.parseInt(arr[i]);
                                    Creature.replaycount++;
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

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
                        /*for (int i = 0; i < Battleground.Maxcalabashbrothers + Formation.numbers + 3; i++)
                            System.out.println(Formation.beengs[i].px + " " + Formation.beengs[i].py);
                            */
                        Creature.isreplay = true;
                        Creature.isend = false;
                        System.out.println(Creature.replaycount);
                        Replayer replayer = new Replayer();
                        replayer.getinformation(root);
                        replayer.start();

                        //for(int i=0;i<Creature.replaycount;i++)
                        //for(int j=0;j<5;j++)
                        //       System.out.print(Creature.replay[i][j]);

                    } else {
                        System.out.println("找不到指定文件");
                    }

                }
                if (event.getCode() == KeyCode.TAB) {
                    choseformation = !choseformation;
                }
                //System.out.println(event.getCode().ordinal());
                if(event.getCode()==KeyCode.ENTER)
                {
                    if(Creature.round!=0&&!Creature.isbattling&&!Creature.isreplay)
                    {
                        Creature.isend=false;
                        for (int i = 0; i < Battleground.Maxcalabashbrothers + Formation.numbers + 3; i++)
                            root.getChildren().removeAll(Formation.beengs[i].imageView);
                        Followers.begin = 10;
                        Battleground.init();
                        firstshowleft=false;
                        firstshowright=false;
                        choseformation=true;
                        Creature.round=0;
                    }

                }
                if (event.getCode().ordinal() >= 25 && event.getCode().ordinal() <= 29) {
                    int turn = event.getCode().ordinal() - 25;
                    System.out.println(turn);
                    if (firstshowleft) {
                        if (choseformation) {
                            for (int i = 0; i < 8; i++)
                                root.getChildren().remove(Formation.beengs[i].imageView);
                        }
                    }
                    if (firstshowright) {
                        if (!choseformation) {
                            for (int i = 8; i < Battleground.Maxcalabashbrothers + Formation.numbers + 3; i++)
                                root.getChildren().remove(Formation.beengs[i].imageView);
                        }
                    }
                    //System.out.println(root.getChildren());
                    Formation formation = new Formation();
                    switch (turn) {
                        case 0:
                            formation.singlelinearry(choseformation);
                            break;
                        case 1:
                            formation.heyiarry(choseformation);
                            break;
                        case 2:
                            formation.yanxianarry(choseformation);
                            break;
                        case 3:
                            formation.fangtongarray(choseformation);
                            break;
                        case 4:
                            formation.fengshiarray(choseformation);
                    }
                    if(!Creature.isreplay) {
                        if (choseformation)
                            Creature.replayformation[0] = turn;
                        else
                            Creature.replayformation[1]=turn;
                    }
                    if (choseformation) {
                        formation.setleftviews();
                        for (int i = 0; i < 8; i++)
                            root.getChildren().add(Formation.beengs[i].imageView);
                        if (!firstshowleft)
                            firstshowleft = true;
                    } else {
                        formation.setrightviews();
                        for (int i = 8; i < Battleground.Maxcalabashbrothers + Formation.numbers + 3; i++)
                            root.getChildren().add(Formation.beengs[i].imageView);
                        if (!firstshowright)
                            firstshowright = true;
                    }


                }
                root.requestFocus();

            }


        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
