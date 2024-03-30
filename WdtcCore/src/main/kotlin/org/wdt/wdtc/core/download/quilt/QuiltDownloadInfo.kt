package org.wdt.wdtc.core.download.quilt

import com.google.gson.annotations.JsonAdapter
import org.wdt.utils.gson.readFileToClass
import org.wdt.wdtc.core.download.infterface.ModDownloadInfoInterface
import org.wdt.wdtc.core.download.infterface.ModInstallTaskInterface
import org.wdt.wdtc.core.download.infterface.VersionsJsonObjectInterface
import org.wdt.wdtc.core.game.Version
import org.wdt.wdtc.core.game.serializeGameRuntimeDependencyGsonBuilder
import org.wdt.wdtc.core.manger.officialDownloadSource
import org.wdt.wdtc.core.manger.wdtcCache
import org.wdt.wdtc.core.utils.KindOfMod
import org.wdt.wdtc.core.utils.gson.DownloadInfoTypeAdapter
import java.io.File

@JsonAdapter(DownloadInfoTypeAdapter::class)
open class QuiltDownloadInfo(
  protected val version: Version,
  override val modVersion: String
) : ModDownloadInfoInterface {
  constructor(version: Version, versionsJsonObjectInterface: VersionsJsonObjectInterface) :
	  this(version, versionsJsonObjectInterface.versionNumber)
	
	
	private val libraryListUrl = "${officialDownloadSource.quiltMetaUrl}v3/versions/loader/%s/%s/profile/json"
	
	val quiltVersionJson: File
    get() = File(wdtcCache, "${version.versionNumber}-quilt-$modVersion.json")
	
	val quiltVersionJsonUrl: String
    get() = libraryListUrl.format(version.versionNumber, modVersion)
	
	val quiltProfileJsonObject: QuiltProfileJsonObject
		get() = quiltVersionJson.readFileToClass(serializeGameRuntimeDependencyGsonBuilder)
  override val modInstallTask: ModInstallTaskInterface
    get() = QuiltInstallTask(version, modVersion)
  override val modKind: KindOfMod
    get() = KindOfMod.QUILT

  override fun toString(): String {
    return "QuiltDownloadInfo(modVersion='$modVersion')"
  }
	
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is QuiltDownloadInfo) return false
		
		if (modVersion != other.modVersion) return false
		
		return true
	}
	
	override fun hashCode(): Int {
		return modVersion.hashCode()
	}
	
	
}
