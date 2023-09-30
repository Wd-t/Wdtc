package org.wdt.wdtc;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.wdt.utils.io.FileUtils;
import org.wdt.wdtc.manger.SettingManger;
import org.wdt.wdtc.manger.VMManger;
import org.wdt.wdtc.ui.Consoler;
import org.wdt.wdtc.ui.ErrorWindow;
import org.wdt.wdtc.ui.HomeWindow;
import org.wdt.wdtc.ui.WindwosSize;
import org.wdt.wdtc.utils.DownloadUtils;
import org.wdt.wdtc.utils.PlatformUtils;
import org.wdt.wdtc.utils.WdtcLogger;

import java.io.IOException;

public class AppMain extends Application {
    private static final Logger logmaker = WdtcLogger.getLogger(AppMain.class);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage MainStage) {
        try {
            WindwosSize size = new WindwosSize(MainStage);
            if (PlatformUtils.isOnline()) {
                MainStage.setTitle(Consoler.getWindowsTitle());
            } else {
                MainStage.setTitle(Consoler.getWindowsTitle("无网络"));
                logmaker.warn("* 当前无网络连接,下载功能无法正常使用!");
            }
            MainStage.setMinWidth(WindwosSize.WindowsWidht);
            MainStage.setMinHeight(WindwosSize.WindowsHeight);
            size.SettingSize();
            MainStage.getIcons().add(new Image("ico.jpg"));
            MainStage.setResizable(VMManger.isChangeWindowsSize());
            HomeWindow win = new HomeWindow();
            win.setHome(MainStage);
            MainStage.show();
            logmaker.info("Window Show");
            MainStage.setOnCloseRequest(windowEvent -> {
                logmaker.info(size);
                SettingManger.Setting setting = SettingManger.getSetting();
                setting.setWindowsWidth(MainStage.getWidth()).setWindowsHeight(MainStage.getHeight());
                try {
                    FileUtils.touch(DownloadUtils.StopProcess);
                } catch (IOException e) {
                    logmaker.error(WdtcLogger.getErrorMessage(e));
                }
                SettingManger.putSettingToFile(setting);
                Platform.exit();
                logmaker.info("======= Wdtc Stop ========");
            });
        } catch (Exception e) {
            ErrorWindow.setErrorWin(e);
        }
    }
}
