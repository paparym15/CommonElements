package com.one.testnotifications

import android.util.Log

class MediaPlayer(val player: Player, val downloader: Downloader): Player by player, Downloader by downloader {

    override fun download() {
        downloader.download()
    }

    override fun play() {
        player.play()
    }

}

class DownloaderImpl(): Downloader {
    override fun download() {
        Log.d("-->", "downloading")
    }

}

class PlayerImpl: Player {
    override fun play() {
        Log.d("-->", "playing")
    }

}