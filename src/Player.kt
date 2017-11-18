class Player(private var onCell:Cell, private val color:String) {
    fun doInput(direction:Direction):Boolean {
        val previousCell = onCell
        onCell = when {
            direction == Direction.LEFT && !onCell.hasLeftWall -> onCell.leftCell
            direction == Direction.RIGHT && !onCell.hasRightWall -> onCell.rightCell
            direction == Direction.UP && !onCell.hasTopWall -> onCell.topCell
            direction == Direction.DOWN && !onCell.hasBottomWall -> onCell.bottomCell
            else -> null
        } ?: onCell
        return onCell == previousCell
    }

    fun draw(drawer: CanvasDrawer, isActive: Boolean) {
        drawer.cell(onCell.x, onCell.y, color, isActive)
    }
}