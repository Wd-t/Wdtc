package org.wdt.wdtc.core.launch

import org.wdt.wdtc.core.auth.User.Companion.user
import org.wdt.wdtc.core.game.Launcher
import org.wdt.wdtc.core.game.config.GameConfig.Companion.gameConfig
import org.wdt.wdtc.core.manger.VMManger.launcherVersion
import java.io.IOException

class GameCLICommand(private val launcher: Launcher) : AbstractGameCommand() {
  @Throws(IOException::class)
  override fun getCommand(): StringBuilder {
    val gameConfig = launcher.gameConfig.config!!
    val versionJsonObject = launcher.gameVersionJsonObject
    nonBreakingSpace(versionJsonObject.mainClass!!)
    for (element in versionJsonObject.arguments?.gameList!!) {
      if (!element.isJsonObject) {
        nonBreakingSpace(replaceData(element.asString))
      }
    }
    nonBreakingSpace("--height")
    nonBreakingSpace(gameConfig.hight)
    nonBreakingSpace("--width")
    commandBuilder.append(gameConfig.width)
    return commandBuilder
  }

  private val dataMap
    get() = mutableMapOf(
      "\${auth_player_name}" to
          user.userName,
      "\${version_name}" to
          launcher.versionNumber,
      "\${game_directory}" to
          launcher.versionDirectory.canonicalPath,
      "\${assets_root}" to
          launcher.gameAssetsDirectory.canonicalPath,
      "\${assets_index_name}" to
          launcher.gameVersionJsonObject.assets,
      "\${auth_uuid}" to
          user.uuid,
      "\${auth_access_token}" to
          user.accessToken,
      "\${user_type}" to
          user.type.toString(),
      "\${version_type}" to
          "Wdtc-$launcherVersion"
    )


  @Throws(IOException::class)
  private fun replaceData(strs: String): String {
    var str = strs
    for (s in dataMap.keys) {
      str = str.replace(s, dataMap[s]!!)
    }
    return str
  }
}

