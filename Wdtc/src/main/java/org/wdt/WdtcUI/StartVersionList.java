package org.wdt.WdtcUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.wdt.FilePath;
import org.wdt.WdtcDownload.GetGamePath;
import org.wdt.WdtcLauncher.Launcher;
import org.wdt.WdtcUI.users.ReadUserList;

import java.io.File;
import java.io.IOException;

public class StartVersionList {
    private static final Stage stage = new Stage();

    private static final VBox V_BOX = new VBox();
    private static final ScrollPane SCROLL_PANE = new ScrollPane();
    private static final Scene SCENE = new Scene(SCROLL_PANE);
    private static final Logger logmaker = Logger.getLogger(StartVersionList.class);
    private static Label start_label;
    private static TextField textField;

    public StartVersionList(Label start_label, TextField textField) {
        StartVersionList.start_label = start_label;
        StartVersionList.textField = textField;
    }

    public void getStartList() {
        logmaker.info("* 开始加载版本列表");
        File version_path = new File(GetGamePath.getGameVersionPath());
        File[] files = version_path.listFiles();
        //foreach遍历数组
        try {
            for (File file2 : files) {
                Button button = new Button(file2.getName());
                V_BOX.getChildren().add(button);
                button.setMaxSize(100, 50);
                button.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                    V_BOX.getChildren().clear();
                    stage.close();
                    try {
                        if (ReadUserList.SetUserJson()) {
                            start_label.setText("\t\t\t\t开始启动");
                            logmaker.info("* 开始启动");
                            new Thread(() -> {
                                try {
                                    new Launcher(file2.getName());
                                } catch (IOException | InterruptedException | RuntimeException e) {
                                    e.printStackTrace();
                                }
                            }).start();
                            textField.setText(FilePath.getStarterBat().getCanonicalPath());
                        }
                    } catch (IOException e) {
                        ErrorWin.setErrorWin(e);
                    }

                });
            }
            SCROLL_PANE.setContent(V_BOX);
            stage.setHeight(500);
            stage.setWidth(500);
            stage.getIcons().add(new Image("ico.jpg"));
            stage.setTitle("Start Version List");
            stage.setScene(SCENE);
            stage.setResizable(false);
            logmaker.info("* 版本列表加载成功");
            stage.show();
            stage.setOnCloseRequest(windowEvent -> V_BOX.getChildren().clear());
        } catch (NullPointerException e) {
            Label label = new Label("您没有游戏版本,请去下载");
            Pane pane = new Pane();
            pane.prefHeight(400.0);
            pane.prefWidth(600.0);
            label.setLayoutX(217.0);
            label.setLayoutY(193.0);
            pane.getChildren().add(label);
            Scene scene = new Scene(pane, 600, 400);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.getIcons().add(new Image("/ico.jpg"));
            stage.setTitle("版本文件夹为空");
            stage.show();
            logmaker.error("* 版本文件夹为空");
        }
    }
}
