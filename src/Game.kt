import kotlin.browser.window

fun main(args: Array<String>) {
    window.addEventListener("load", { Game() })
}

class Game {
    private val maze: Maze = Maze()
    private val drawSystem: CanvasDrawer = CanvasDrawer(maze.width, maze.height)

    init {
        KeyboardInputHandler({ onInput(it) })
        draw()
    }

    private fun onInput(direction:Direction) {
        maze.onInput(direction)
        draw()
    }

    private fun draw() {
        maze.draw(drawSystem)
    }
}