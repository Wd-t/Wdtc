package org.wdt.WdtcUI;

import com.jfoenix.controls.JFXButton;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.wdt.Launcher;
import org.wdt.download.SelectGameVersion;
import org.wdt.platform.Starter;

import java.io.IOException;


public class DownloadGameWin {
    private final Launcher launcher;

    public DownloadGameWin(Launcher launcher) {
        this.launcher = launcher;
    }

    public void setDownGameWin(Stage MainStage) {
        MainStage.setTitle("Wdtc - " + Starter.getLauncherVersion() + " - 下载游戏");
        Pane pane = new Pane();
        JFXButton back = new JFXButton("返回");
        back.setOnAction(event -> HomeWin.setHome(MainStage));
        back.setStyle("-fx-border-color: #000000");
        TextField textField = new TextField();
        textField.setPromptText("三个阶段");
        textField.setLayoutX(218.0);
        textField.setLayoutY(320.0);
        Label time = new Label("下载时间不会太长");
        Label status_bar = new Label("下面是状态栏");
        time.setLayoutX(241.0);
        time.setLayoutY(160.0);
        status_bar.setLayoutX(253.0);
        status_bar.setLayoutY(305.0);
        Button bmclHome = new Button("BMCLAPI");
        bmclHome.setLayoutX(531.0);
        bmclHome.setOnAction(event -> {
            try {
                Runtime.getRuntime().exec("cmd.exe /C start https://bmclapidoc.bangbang93.com/");
            } catch (IOException | RuntimeException exception) {
                ErrorWin.setErrorWin(exception);
            }
        });
        Label read_bmcl = new Label("国内快速下载源→");
        read_bmcl.setLayoutX(429.0);
        read_bmcl.setLayoutY(4.0);
        if (launcher.bmclapi()) {
            textField.setText("BMCLAPI下载加速已开启");
        } else {
            textField.setText(launcher.getVersion() + "开始下载");
        }
        Thread thread = new Thread(() -> {
            try {
                new SelectGameVersion(launcher, textField).DownloadGame();

            } catch (Exception e) {
                ErrorWin.setErrorWin(e);
            }
        });
        thread.start();
        pane.setBackground(Consoler.getBackground());
        pane.getChildren().addAll(back, textField, time, status_bar, bmclHome, read_bmcl);
        Scene down_scene = new Scene(pane);
        MainStage.setScene(down_scene);
    }
}
