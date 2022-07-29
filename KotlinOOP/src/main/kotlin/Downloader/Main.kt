package Downloader

class FileDownload(private val file: String) : Downloader {
    override fun download() {
        println("$file download")
    }
}

class FilePlayer(private val file: String) : Player {
    override fun play() {
        println("$file playing")
    }
}

class MediaFile(
    private val downloader: Downloader,
    private val player: Player
) : Downloader by downloader, Player by player

fun main() {
    val file = "test.mkv"
    val media = MediaFile(FileDownload(file), FilePlayer(file))
    media.download()
    media.play()
}