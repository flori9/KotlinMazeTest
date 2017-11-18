class Maze {
    val width = 5
    val height = 7
    val cells: Array<Array<Cell>> = Array(width, { i -> Array(height, { j ->
            Cell(this, i, j).apply {
                if (i == 0) hasLeftWall = true
                if (j == 0) hasTopWall = true
            }
        })
    })
    var players: Array<Player> = arrayOf(Player(cells[0][0], "red"),
            Player(cells[width - 1][height - 1], "blue"))
    var currentPlayer = 0

    init {
        cells[0][0].hasRightWall = true
        cells[0][1].hasRightWall = true
        cells[1][1].hasRightWall = true
    }

    fun draw(drawer: CanvasDrawer) {
        drawer.clear()
        players.forEach { it.draw(drawer, players[currentPlayer] == it) }
        cells.forEach { it.forEach { it.draw(drawer) } }
    }

    fun onInput(direction:Direction) {
        if (! players[currentPlayer].doInput(direction))
            currentPlayer = (currentPlayer + 1) % players.size
    }
}