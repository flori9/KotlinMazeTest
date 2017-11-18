class Cell(maze: Maze, val x: Int, val y: Int) {
    val leftCell by lazy {
        if (x == 0)
            null
        else
            maze.cells[x - 1][y]
    }
    val topCell by lazy {
        if (y == 0)
            null
        else
            maze.cells[x][y - 1]
    }
    val rightCell by lazy {
        if (x == maze.cells.size - 1)
            null
        else
            maze.cells[x + 1][y]
    }
    val bottomCell by lazy {
        if (y == maze.cells[x].size - 1)
            null
        else
            maze.cells[x][y + 1]
    }

    var hasLeftWall = false
    var hasTopWall = false
    var hasRightWall
        get() = rightCell?.hasLeftWall ?: true
        set(value) { rightCell?.hasLeftWall = value }
    var hasBottomWall
        get() = bottomCell?.hasTopWall ?: true
        set(value) { bottomCell?.hasTopWall = value }

    fun draw(drawer: Drawer) {
        if (hasLeftWall)
            drawer.horizontalWall(x, y)
        if (hasTopWall)
            drawer.verticalWall(x, y)
        if (hasRightWall && rightCell == null)
            drawer.horizontalWall(x + 1, y)
        if (hasBottomWall && bottomCell == null)
            drawer.verticalWall(x, y + 1)
    }
}