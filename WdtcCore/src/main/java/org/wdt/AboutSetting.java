package org.wdt;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.wdt.platform.PlatformUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class AboutSetting {
    private static final Logger logmaker = Logger.getLogger(AboutSetting.class);

    public static File GetSettingFile() {
        return new File(System.getProperty("user.home") + "\\.wdtc\\setting\\setting.json");
    }

    public static boolean GetBmclSwitch() {
        boolean bmcl = false;
        try {
            bmcl = PlatformUtils.FileToJSONObject(GetSettingFile()).getBoolean("bmcl");
        } catch (IOException e) {
            logmaker.error("* 错误:", e);
        }
        return bmcl;
    }

    public static boolean GetLogSwitch() {
        boolean log = false;
        try {
            log = PlatformUtils.FileToJSONObject(GetSettingFile()).getBoolean("log");
        } catch (IOException e) {
            logmaker.error("* 错误:", e);
        }
        return log;
    }

    public static boolean GetLlvmpipeSwitch() {
        boolean LlvmpipeLoader = false;
        try {
            LlvmpipeLoader = PlatformUtils.FileToJSONObject(GetSettingFile()).getBoolean("llvmpipe-loader");
        } catch (IOException e) {
            logmaker.error("* 错误:", e);
        }
        return LlvmpipeLoader;
    }

    public static boolean GetZHCNSwitch() {
        boolean ZHCN = false;
        try {
            ZHCN = PlatformUtils.FileToJSONObject(GetSettingFile()).getBoolean("ZH-CN");
        } catch (IOException e) {
            logmaker.error("* 错误:", e);
        }
        return ZHCN;
    }

    public static void GenerateSettingFile() throws IOException {
        String readme = IOUtils.toString(requireNonNull(AboutSetting.class.getResourceAsStream("/readme.txt")), StandardCharsets.UTF_8);
        File writeReadme = new File(FilePath.getWdtcConfig() + "/readme.txt");
        FileUtils.writeStringToFile(writeReadme, readme);
        if (PlatformUtils.FileExistenceAndSize(GetSettingFile())) {
            Map<String, Object> ObjectMap = new HashMap<>();
            ObjectMap.put("bmcl", false);
            ObjectMap.put("log", false);
            ObjectMap.put("llvmpipe-loader", false);
            ObjectMap.put("DefaultGamePath", System.getProperty("user.dir"));
            ObjectMap.put("JavaPath", new ArrayList<>());
            ObjectMap.put("ZH-CN", true);
            FileUtils.writeStringToFile(GetSettingFile(), JSONObject.toJSONString(ObjectMap), "UTF-8");
        }
    }

    public static String GetDefaultGamePath() throws IOException {
        return PlatformUtils.FileToJSONObject(GetSettingFile()).getString("DefaultGamePath");
    }

    public static JSONObject SettingObject() throws IOException {
        return PlatformUtils.FileToJSONObject(GetSettingFile());
    }

    public static JSONArray JavaList() throws IOException {
        return SettingObject().getJSONArray("JavaPath");
    }

    public static String UserName() throws IOException {
        return UserSetting().getString("userName");
    }

    public static JSONObject UserSetting() throws IOException {
        return PlatformUtils.FileToJSONObject(FilePath.getUsersJson());
    }

    public static String GetUserType() throws IOException {
        return UserSetting().getString("type");
    }

    public static Thread RunGetJavaHome() {
        try {
            if (PlatformUtils.FileExistenceAndSize(FilePath.getJavaHomeJarFile())) {
                InputStream inputStream = AboutSetting.class.getResourceAsStream("/WdtcGetJavaHome.jar");
                FileOutputStream outputStream = new FileOutputStream(FilePath.getJavaHomeJarFile());
                IOUtils.copy(requireNonNull(inputStream), outputStream);
            }
        } catch (IOException e) {
            logmaker.error("* 错误:", e);
        }
        String CommandLine = GetJavaPath.GetRunJavaHome() + " -jar " + FilePath.getJavaHomeJarFile();
        return new Thread(() -> {
            logmaker.info("* Command Line:" + CommandLine);
            try {
                Process process = Runtime.getRuntime().exec("cmd.exe /c" + CommandLine);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    logmaker.info(line);
                }
            } catch (IOException e) {
                logmaker.error(e);
            }
        }, "Found Java");

    }
}