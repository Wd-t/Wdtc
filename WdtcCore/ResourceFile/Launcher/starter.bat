@echo off
cd E:\Wdtc\.minecraft\
"F:\jdk\Liberica JDK\LibericaJDK-20-Full\bin\java.exe" -Dlog4j.configurationFile=E:\Wdtc\.minecraft\versions\1.17.1\log4j2.xml -Xmx1024M -Dminecraft.client.jar=E:\Wdtc\.minecraft\versions\1.17.1\1.17.1.jar -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -XX:G1NewSizePercent=20 -XX:G1ReservePercent=20 -XX:MaxGCPauseMillis=50 -XX:G1HeapRegionSize=32m -XX:HeapDumpPath=MojangTricksIntelDriversForPerformance_javaw.exe_minecraft.exe.heapdump -Djava.library.path=E:\Wdtc\.minecraft\versions\1.17.1\natives-windows-x86_64 -Dminecraft.launcher.brand=Wdtc -Dminecraft.launcher.version=1.0.0-demo -cp E:\Wdtc\.minecraft\libraries\com\mojang\blocklist\1.0.5\blocklist-1.0.5.jar;E:\Wdtc\.minecraft\libraries\com\mojang\patchy\2.1.6\patchy-2.1.6.jar;E:\Wdtc\.minecraft\libraries\com\github\oshi\oshi-core\5.7.5\oshi-core-5.7.5.jar;E:\Wdtc\.minecraft\libraries\net\java\dev\jna\jna\5.8.0\jna-5.8.0.jar;E:\Wdtc\.minecraft\libraries\net\java\dev\jna\jna-platform\5.8.0\jna-platform-5.8.0.jar;E:\Wdtc\.minecraft\libraries\org\slf4j\slf4j-api\1.8.0-beta4\slf4j-api-1.8.0-beta4.jar;E:\Wdtc\.minecraft\libraries\org\apache\logging\log4j\log4j-slf4j18-impl\2.14.1\log4j-slf4j18-impl-2.14.1.jar;E:\Wdtc\.minecraft\libraries\com\ibm\icu\icu4j\66.1\icu4j-66.1.jar;E:\Wdtc\.minecraft\libraries\com\mojang\javabridge\1.1.23\javabridge-1.1.23.jar;E:\Wdtc\.minecraft\libraries\net\sf\jopt-simple\jopt-simple\5.0.3\jopt-simple-5.0.3.jar;E:\Wdtc\.minecraft\libraries\io\netty\netty-all\4.1.25.Final\netty-all-4.1.25.Final.jar;E:\Wdtc\.minecraft\libraries\com\google\guava\guava\21.0\guava-21.0.jar;E:\Wdtc\.minecraft\libraries\org\apache\commons\commons-lang3\3.5\commons-lang3-3.5.jar;E:\Wdtc\.minecraft\libraries\commons-io\commons-io\2.5\commons-io-2.5.jar;E:\Wdtc\.minecraft\libraries\commons-codec\commons-codec\1.10\commons-codec-1.10.jar;E:\Wdtc\.minecraft\libraries\net\java\jinput\jinput\2.0.5\jinput-2.0.5.jar;E:\Wdtc\.minecraft\libraries\net\java\jutils\jutils\1.0.0\jutils-1.0.0.jar;E:\Wdtc\.minecraft\libraries\com\mojang\brigadier\1.0.18\brigadier-1.0.18.jar;E:\Wdtc\.minecraft\libraries\com\mojang\datafixerupper\4.0.26\datafixerupper-4.0.26.jar;E:\Wdtc\.minecraft\libraries\com\google\code\gson\gson\2.8.0\gson-2.8.0.jar;E:\Wdtc\.minecraft\libraries\com\mojang\authlib\2.3.31\authlib-2.3.31.jar;E:\Wdtc\.minecraft\libraries\org\apache\commons\commons-compress\1.8.1\commons-compress-1.8.1.jar;E:\Wdtc\.minecraft\libraries\org\apache\httpcomponents\httpclient\4.3.3\httpclient-4.3.3.jar;E:\Wdtc\.minecraft\libraries\commons-logging\commons-logging\1.1.3\commons-logging-1.1.3.jar;E:\Wdtc\.minecraft\libraries\org\apache\httpcomponents\httpcore\4.3.2\httpcore-4.3.2.jar;E:\Wdtc\.minecraft\libraries\it\unimi\dsi\fastutil\8.2.1\fastutil-8.2.1.jar;E:\Wdtc\.minecraft\libraries\org\apache\logging\log4j\log4j-api\2.14.1\log4j-api-2.14.1.jar;E:\Wdtc\.minecraft\libraries\org\apache\logging\log4j\log4j-core\2.14.1\log4j-core-2.14.1.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl\3.2.2\lwjgl-3.2.2.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-jemalloc\3.2.2\lwjgl-jemalloc-3.2.2.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-openal\3.2.2\lwjgl-openal-3.2.2.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-opengl\3.2.2\lwjgl-opengl-3.2.2.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-glfw\3.2.2\lwjgl-glfw-3.2.2.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-stb\3.2.2\lwjgl-stb-3.2.2.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-tinyfd\3.2.2\lwjgl-tinyfd-3.2.2.jar;E:\Wdtc\.minecraft\libraries\com\mojang\text2speech\1.11.3\text2speech-1.11.3.jar;E:\Wdtc\.minecraft\versions\1.17.1\1.17.1.jar net.minecraft.client.main.Main --username zhu --version 1.17.1 --gameDir E:\Wdtc\.minecraft\ --assetsDir E:\Wdtc\.minecraft\assets\ --assetIndex 1.17 --uuid bd448629aef040afa69e85e1a9d0e3db --accessToken ${auth_access_token} --clientId ${clientid} --xuid ${auth_xuid} --userType legacy --versionType Wdtc-dome