interface Drawer {
    fun clear()
    fun horizontalWall(x: Int, y: Int)
    fun verticalWall(x: Int, y: Int)
    fun cell(x: Int, y: Int, color: String, isActive: Boolean = true)
}