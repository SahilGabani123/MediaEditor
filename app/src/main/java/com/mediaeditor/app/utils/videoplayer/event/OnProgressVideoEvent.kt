package com.mediaeditor.app.utils.videoplayer.event

interface OnProgressVideoEvent {

    fun updateProgress(time: Float, max: Long, scale: Long)
}
