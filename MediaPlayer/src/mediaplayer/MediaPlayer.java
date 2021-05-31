package mediaplayer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MediaPlayer extends Application {
    private GroupLayout bodyLayout;
    @Override
    public void start(Stage stage) throws Exception {
        JFrame frm = new JFrame();
        JPanel body = new JPanel();
        JFXPanel panel = new JFXPanel();
        initBody(body,panel,1600,845);
        frm.add(body);
        frm.setBounds(0, 0, 1600, 900);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setBackground(new Color(0, 0, 0));

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("MediaPlayer.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root);
                panel.setScene(scene);
            }
        });
    }
    public void initBody(JPanel body, JFXPanel bodyContent, int width, int height) {
        bodyLayout = new GroupLayout(body);
        body.setLayout(bodyLayout);
        body.setBackground(new Color(36, 36, 36));
        setBodyLayoutGroup(body, bodyContent, width, height);
    }

    private void setBodyLayoutGroup(JPanel body, JFXPanel bodyContent, int width, int height) {

        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(bodyLayout.createSequentialGroup().addComponent(bodyContent,
                        GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)));
        bodyLayout.setVerticalGroup(bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
                GroupLayout.Alignment.TRAILING,
                bodyLayout.createSequentialGroup().addGap(0, 0, 0).addComponent(bodyContent,
                        GroupLayout.PREFERRED_SIZE, height, GroupLayout.PREFERRED_SIZE)));
    }
    public static void main(String[] args) {
        launch(args);
    }


}
