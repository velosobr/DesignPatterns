fun main(args: Array<String>) {
    println("Hello World!")


    println("Program arguments: ${args.joinToString()}")

    // Uso:
    MediaPlayer.play()  // Output: Iniciando a reprodução da mídia.
    MediaPlayer.pause() // Output: A reprodução da mídia já está pausada.
    MediaPlayer.play()  // Output: Retomando a reprodução da mídia.
    MediaPlayer.stop()  // Output: Parando a reprodução da mídia.

}

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

