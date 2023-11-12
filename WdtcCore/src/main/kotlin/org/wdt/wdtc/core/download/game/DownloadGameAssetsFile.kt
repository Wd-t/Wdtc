package org.wdt.wdtc.core.download.game

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import org.wdt.utils.gson.getJsonObject
import org.wdt.utils.gson.parseObject
import org.wdt.utils.gson.readFileToJsonObject
import org.wdt.utils.io.isFileNotExistsAndIsNotSameSize
import org.wdt.wdtc.core.download.SpeedOfProgress
import org.wdt.wdtc.core.download.infterface.DownloadSourceInterface
import org.wdt.wdtc.core.game.Launcher
import org.wdt.wdtc.core.manger.DownloadSourceManger.downloadSource
import org.wdt.wdtc.core.utils.DownloadUtils.Companion.isDownloadProcess
import org.wdt.wdtc.core.utils.DownloadUtils.Companion.startDownloadTask
import org.wdt.wdtc.core.utils.ThreadUtils.startThread
import org.wdt.wdtc.core.utils.WdtcLogger.getWdtcLogger
import java.io.File
import java.net.URL

open class DownloadGameAssetsFile(val launcher: Launcher) {
  private val logmaker = DownloadGameAssetsFile::class.java.getWdtcLogger()
  fun startDownloadAssetsFiles() {
    val list: Map<String, JsonElement> =
      launcher.gameAssetsListJson.readFileToJsonObject().getJsonObject("objects").asMap()
    val progress = SpeedOfProgress(list.size)
    for (key in list.keys) {
      val data: AssetsFileData = list[key]!!.asJsonObject.parseObject()
      if (isDownloadProcess) return
      if (File(launcher.gameObjects, data.hashSplicing).isFileNotExistsAndIsNotSameSize(data.size.toLong())) {
        val task = DownloadGameAssetsFileTask(launcher, data, progress)
        task.startThread()
      } else {
        progress.countDown()
      }
    }
    progress.await()
  }

  class AssetsFileData {
    @SerializedName("hash")
    val hash: String? = null

    @SerializedName("size")
    val size = 0
    val hashSplicing: String
      get() = "$hashHead/$hash"
    val hashHead: String
      get() = hash!!.substring(0, 2)
  }

  class DownloadGameAssetsFileTask(
    private val launcher: Launcher,
    private val data: AssetsFileData,
    private val progress: SpeedOfProgress
  ) : Thread() {
    private val source: DownloadSourceInterface = downloadSource

    override fun run() {
      val hashFile = File(launcher.gameObjects, data.hashSplicing)
      val hashUrl = URL(source.assetsUrl + data.hashSplicing)
      startDownloadTask(hashUrl, hashFile)
      synchronized(this) { progress.countDown() }
    }
  }
}
