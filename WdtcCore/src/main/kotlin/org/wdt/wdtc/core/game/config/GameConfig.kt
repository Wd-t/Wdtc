package org.wdt.wdtc.core.game.config

import org.wdt.utils.gson.Json
import org.wdt.utils.gson.readFileToClass
import org.wdt.utils.gson.writeObjectToFile
import org.wdt.utils.io.isFileNotExists
import org.wdt.wdtc.core.game.*
import org.wdt.wdtc.core.manger.GameDirectoryManger
import org.wdt.wdtc.core.utils.getExceptionMessage
import org.wdt.wdtc.core.utils.logmaker
import java.io.IOException

class GameConfig(private val launcher: Launcher) {
  val config: DefaultGameConfig.Config?
    get() = defaultGameConfig.config

  val defaultGameConfig: DefaultGameConfig
    get() = launcher.versionConfigFile.readFileToClass()
  val versionInfo: VersionInfo?
    get() = defaultGameConfig.info

  fun putConfigToFile(config: DefaultGameConfig) {
    launcher.versionConfigFile.writeObjectToFile(
      config, Json.getBuilder().setPrettyPrinting()
    )
  }
}

fun writeConfigJsonToAllVersion() {
  val gameDirectoryManger = GameDirectoryManger()
  if (gameDirectoryManger.isDownloadedGame) {
    gameDirectoryManger.getGameVersionList()?.forEach {
      val config = it.gameConfig
      if (it.versionConfigFile.isFileNotExists()) {
        it.writeConfigJson()
      } else {
        val gameConfig = config.defaultGameConfig
        gameConfig.info = config.versionInfo
        logmaker.info(gameConfig)
        config.putConfigToFile(gameConfig)
      }
    }
  } else {
    logmaker.warn("There are currently no game versions available")
  }
}

fun Launcher.writeConfigJson() {
  try {
    val config = DefaultGameConfig(this)
    this.versionConfigFile.writeObjectToFile(
      config, Json.getBuilder().setPrettyPrinting()
    )
    logmaker.info("${this.versionNumber} $config")
  } catch (e: IOException) {
    logmaker.error(e.getExceptionMessage())
  }
}

@Throws(IOException::class)
fun Launcher.ckeckVersionInfo() {
  val config = this.gameConfig.defaultGameConfig
  config.info = this.versionInfo
  this.versionConfigFile.writeObjectToFile(
    config, Json.getBuilder().setPrettyPrinting()
  )
  logmaker.info("${this.versionNumber} $config")
}

val Launcher.gameConfig: GameConfig
  get() = GameConfig(this)
