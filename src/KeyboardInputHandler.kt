import org.w3c.dom.events.KeyboardEvent
import kotlin.browser.document

class KeyboardInputHandler(private val onInput: (Direction) -> Unit) {
    init {
        document.body?.addEventListener("keydown", {
            if (it is KeyboardEvent) {
                when (it.which) {
                    37 -> onInput(Direction.LEFT)
                    38 -> onInput(Direction.UP)
                    39 -> onInput(Direction.RIGHT)
                    40 -> onInput(Direction.DOWN)
                }
            }
        })
    }
}