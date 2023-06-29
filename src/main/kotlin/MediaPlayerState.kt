sealed class MediaPlayerState {
    abstract fun play()
    abstract fun pause()
    abstract fun stop()

    class PlayingState : MediaPlayerState() {
        override fun play() {
            println("A mídia já está sendo reproduzida.")
        }

        override fun pause() {
            println("Pausando a reprodução da mídia.")
            // Mudar para o estado PausedState
            MediaPlayer.changeState(PausedState())
        }

        override fun stop() {
            println("Parando a reprodução da mídia.")
            // Mudar para o estado StoppedState
            MediaPlayer.changeState(StoppedState())
        }
    }

    class PausedState : MediaPlayerState() {
        override fun play() {
            println("Retomando a reprodução da mídia.")
            // Mudar para o estado PlayingState
            MediaPlayer.changeState(PlayingState())
        }

        override fun pause() {
            println("A reprodução da mídia já está pausada.")
        }

        override fun stop() {
            println("Parando a reprodução da mídia.")
            // Mudar para o estado StoppedState
            MediaPlayer.changeState(StoppedState())
        }
    }

    class StoppedState : MediaPlayerState() {
        override fun play() {
            println("Iniciando a reprodução da mídia.")
            // Mudar para o estado PlayingState
            MediaPlayer.changeState(PlayingState())
        }

        override fun pause() {
            println("A reprodução da mídia está parada, não é possível pausar.")
        }

        override fun stop() {
            println("A reprodução da mídia já está parada.")
        }
    }
}