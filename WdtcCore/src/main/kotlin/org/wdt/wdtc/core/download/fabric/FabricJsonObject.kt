package org.wdt.wdtc.core.download.fabric

import com.google.gson.annotations.SerializedName
import org.wdt.wdtc.core.game.Arguments
import org.wdt.wdtc.core.game.GameRuntimeDependency
import org.wdt.wdtc.core.game.LibraryObject
import org.wdt.wdtc.core.manger.currentDownloadSource
import org.wdt.wdtc.core.utils.FileData
import org.wdt.wdtc.core.utils.toURL
import java.net.URL

class FabricProfileJsonObject(
	@field:SerializedName("id")
	val id: String,
	@field:SerializedName("arguments")
	val arguments: Arguments,
	@field:SerializedName("mainClass")
	val mainClass: String,
	@field:SerializedName("libraries")
	val libraries: List<FabricProfileLibraryObject>
)

class FabricProfileLibraryObject(
	@field:SerializedName("name")
	val libraryName: GameRuntimeDependency,
	@field:SerializedName("url")
	val url: URL
) : FileData {
	@field:SerializedName("md5")
	val md5: String? = null
	
	@field:SerializedName("sha1")
	override val sha1: String? = null
	
	@field:SerializedName("sha256")
	val sha256: String? = null
	
	@field:SerializedName("sha512")
	val sha512: String? = null
	
	@field:SerializedName("size")
	override val size: Long? = null
	
	fun toLibraryObject(): LibraryObject {
		return LibraryObject.getLibraryObject(libraryName.apply {
			libraryRepositoriesUrl = currentDownloadSource.fabricLibraryUrl.toURL()
		}, url)
	}
}