@echo off
cd E:\Wdtc\.minecraft\
"F:\jdk\Zulu\zulu-20\bin\java.exe" -Dlog4j.configurationFile=E:\Wdtc\.minecraft\versions\1.19.4\log4j2.xml -Xmx1024M -Dminecraft.client.jar=E:\Wdtc\.minecraft\versions\1.19.4\1.19.4.jar -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -XX:G1NewSizePercent=20 -XX:G1ReservePercent=20 -XX:MaxGCPauseMillis=50 -XX:G1HeapRegionSize=32m -XX:HeapDumpPath=MojangTricksIntelDriversForPerformance_javaw.exe_minecraft.exe.heapdump -Djava.library.path=E:\Wdtc\.minecraft\versions\1.19.4\natives-windows-x86_64 -Dminecraft.launcher.brand=Wdtc -Dminecraft.launcher.version=1.0.0-demo -cp E:\Wdtc\.minecraft\libraries\com\github\oshi\oshi-core\6.2.2\oshi-core-6.2.2.jar;E:\Wdtc\.minecraft\libraries\com\google\code\gson\gson\2.10\gson-2.10.jar;E:\Wdtc\.minecraft\libraries\com\google\guava\failureaccess\1.0.1\failureaccess-1.0.1.jar;E:\Wdtc\.minecraft\libraries\com\google\guava\guava\31.1-jre\guava-31.1-jre.jar;E:\Wdtc\.minecraft\libraries\com\ibm\icu\icu4j\71.1\icu4j-71.1.jar;E:\Wdtc\.minecraft\libraries\com\mojang\authlib\3.18.38\authlib-3.18.38.jar;E:\Wdtc\.minecraft\libraries\com\mojang\blocklist\1.0.10\blocklist-1.0.10.jar;E:\Wdtc\.minecraft\libraries\com\mojang\brigadier\1.0.18\brigadier-1.0.18.jar;E:\Wdtc\.minecraft\libraries\com\mojang\datafixerupper\6.0.6\datafixerupper-6.0.6.jar;E:\Wdtc\.minecraft\libraries\com\mojang\logging\1.1.1\logging-1.1.1.jar;E:\Wdtc\.minecraft\libraries\com\mojang\patchy\2.2.10\patchy-2.2.10.jar;E:\Wdtc\.minecraft\libraries\com\mojang\text2speech\1.16.7\text2speech-1.16.7.jar;E:\Wdtc\.minecraft\libraries\commons-codec\commons-codec\1.15\commons-codec-1.15.jar;E:\Wdtc\.minecraft\libraries\commons-io\commons-io\2.11.0\commons-io-2.11.0.jar;E:\Wdtc\.minecraft\libraries\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;E:\Wdtc\.minecraft\libraries\io\netty\netty-buffer\4.1.82.Final\netty-buffer-4.1.82.Final.jar;E:\Wdtc\.minecraft\libraries\io\netty\netty-codec\4.1.82.Final\netty-codec-4.1.82.Final.jar;E:\Wdtc\.minecraft\libraries\io\netty\netty-common\4.1.82.Final\netty-common-4.1.82.Final.jar;E:\Wdtc\.minecraft\libraries\io\netty\netty-handler\4.1.82.Final\netty-handler-4.1.82.Final.jar;E:\Wdtc\.minecraft\libraries\io\netty\netty-resolver\4.1.82.Final\netty-resolver-4.1.82.Final.jar;E:\Wdtc\.minecraft\libraries\io\netty\netty-transport-classes-epoll\4.1.82.Final\netty-transport-classes-epoll-4.1.82.Final.jar;E:\Wdtc\.minecraft\libraries\io\netty\netty-transport-native-unix-common\4.1.82.Final\netty-transport-native-unix-common-4.1.82.Final.jar;E:\Wdtc\.minecraft\libraries\io\netty\netty-transport\4.1.82.Final\netty-transport-4.1.82.Final.jar;E:\Wdtc\.minecraft\libraries\it\unimi\dsi\fastutil\8.5.9\fastutil-8.5.9.jar;E:\Wdtc\.minecraft\libraries\net\java\dev\jna\jna-platform\5.12.1\jna-platform-5.12.1.jar;E:\Wdtc\.minecraft\libraries\net\java\dev\jna\jna\5.12.1\jna-5.12.1.jar;E:\Wdtc\.minecraft\libraries\net\sf\jopt-simple\jopt-simple\5.0.4\jopt-simple-5.0.4.jar;E:\Wdtc\.minecraft\libraries\org\apache\commons\commons-compress\1.21\commons-compress-1.21.jar;E:\Wdtc\.minecraft\libraries\org\apache\commons\commons-lang3\3.12.0\commons-lang3-3.12.0.jar;E:\Wdtc\.minecraft\libraries\org\apache\httpcomponents\httpclient\4.5.13\httpclient-4.5.13.jar;E:\Wdtc\.minecraft\libraries\org\apache\httpcomponents\httpcore\4.4.15\httpcore-4.4.15.jar;E:\Wdtc\.minecraft\libraries\org\apache\logging\log4j\log4j-api\2.19.0\log4j-api-2.19.0.jar;E:\Wdtc\.minecraft\libraries\org\apache\logging\log4j\log4j-core\2.19.0\log4j-core-2.19.0.jar;E:\Wdtc\.minecraft\libraries\org\apache\logging\log4j\log4j-slf4j2-impl\2.19.0\log4j-slf4j2-impl-2.19.0.jar;E:\Wdtc\.minecraft\libraries\org\joml\joml\1.10.5\joml-1.10.5.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-glfw\3.3.1\lwjgl-glfw-3.3.1.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-glfw\3.3.1\lwjgl-glfw-3.3.1-natives-windows.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-glfw\3.3.1\lwjgl-glfw-3.3.1-natives-windows-arm64.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-glfw\3.3.1\lwjgl-glfw-3.3.1-natives-windows-x86.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-jemalloc\3.3.1\lwjgl-jemalloc-3.3.1.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-jemalloc\3.3.1\lwjgl-jemalloc-3.3.1-natives-windows.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-jemalloc\3.3.1\lwjgl-jemalloc-3.3.1-natives-windows-arm64.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-jemalloc\3.3.1\lwjgl-jemalloc-3.3.1-natives-windows-x86.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-openal\3.3.1\lwjgl-openal-3.3.1.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-openal\3.3.1\lwjgl-openal-3.3.1-natives-windows.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-openal\3.3.1\lwjgl-openal-3.3.1-natives-windows-arm64.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-openal\3.3.1\lwjgl-openal-3.3.1-natives-windows-x86.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-opengl\3.3.1\lwjgl-opengl-3.3.1.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-opengl\3.3.1\lwjgl-opengl-3.3.1-natives-windows.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-opengl\3.3.1\lwjgl-opengl-3.3.1-natives-windows-arm64.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-opengl\3.3.1\lwjgl-opengl-3.3.1-natives-windows-x86.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-stb\3.3.1\lwjgl-stb-3.3.1.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-stb\3.3.1\lwjgl-stb-3.3.1-natives-windows.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-stb\3.3.1\lwjgl-stb-3.3.1-natives-windows-arm64.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-stb\3.3.1\lwjgl-stb-3.3.1-natives-windows-x86.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-tinyfd\3.3.1\lwjgl-tinyfd-3.3.1.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-tinyfd\3.3.1\lwjgl-tinyfd-3.3.1-natives-windows.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-tinyfd\3.3.1\lwjgl-tinyfd-3.3.1-natives-windows-arm64.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl-tinyfd\3.3.1\lwjgl-tinyfd-3.3.1-natives-windows-x86.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl\3.3.1\lwjgl-3.3.1.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl\3.3.1\lwjgl-3.3.1-natives-windows.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl\3.3.1\lwjgl-3.3.1-natives-windows-arm64.jar;E:\Wdtc\.minecraft\libraries\org\lwjgl\lwjgl\3.3.1\lwjgl-3.3.1-natives-windows-x86.jar;E:\Wdtc\.minecraft\libraries\org\slf4j\slf4j-api\2.0.1\slf4j-api-2.0.1.jar;E:\Wdtc\.minecraft\versions\1.19.4\1.19.4.jar net.minecraft.client.main.Main --username Wd_t --version 1.19.4 --gameDir E:\Wdtc\.minecraft\ --assetsDir E:\Wdtc\.minecraft\assets\ --assetIndex 3 --uuid 96b3384f4bd94acfb43b96168258a8b8 --accessToken ${auth_access_token} --clientId ${clientid} --xuid ${auth_xuid} --userType legacy --versionType Wdtc-dome