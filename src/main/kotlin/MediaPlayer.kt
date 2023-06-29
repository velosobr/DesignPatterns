object MediaPlayer {
    private var state: MediaPlayerState = MediaPlayerState.StoppedState()

    fun changeState(newState: MediaPlayerState) {
        state = newState
    }

    fun play() {
        state.play()
    }

    fun pause() {
        state.pause()
    }

    fun stop() {
        state.stop()
    }
}