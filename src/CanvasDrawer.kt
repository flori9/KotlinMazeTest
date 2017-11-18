import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import kotlin.browser.document
import kotlin.js.Math

class CanvasDrawer(private val widthInCells:Int, private val heightInCells:Int) {
    private val cellSize: Double = 40.0
    private val wallSize: Double = 4.0

    private val canvas: HTMLCanvasElement =
            (document.body?.appendChild(document.createElement("canvas")) as HTMLCanvasElement).apply {
                width = Math.ceil(widthInCells * cellSize)
                height = Math.ceil(heightInCells * cellSize)
            }
    private val ctx: CanvasRenderingContext2D = canvas.getContext("2d") as CanvasRenderingContext2D

    private fun rect(x: Double, y: Double, width: Double, height: Double, color: String, alpha: Double = 1.0) {
        ctx.fillStyle = color
        ctx.globalAlpha = alpha
        ctx.fillRect(x, y, width, height)
    }

    fun clear() {
        rect(0.0, 0.0, canvas.width.toDouble(), canvas.height.toDouble(), "white")
    }

    fun horizontalWall(x: Int, y: Int) = rect(x * cellSize - wallSize / 2, y * cellSize - wallSize / 2,
            wallSize, cellSize + wallSize / 2, "black")

    fun verticalWall(x: Int, y: Int) = rect(x * cellSize - wallSize / 2, y * cellSize - wallSize / 2,
            cellSize + wallSize / 2, wallSize, "black")

    fun cell(x: Int, y: Int, color: String, isActive: Boolean = true)
            = rect(x * cellSize + wallSize / 2, y * cellSize + wallSize / 2,
            cellSize - wallSize, cellSize - wallSize, color, if (isActive) 1.0 else 0.5)
}