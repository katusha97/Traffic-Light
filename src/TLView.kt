import java.awt.Color
import java.awt.Dimension
import java.awt.EventQueue
import java.awt.Graphics
import javax.swing.JFrame
import javax.swing.JPanel


class TLView : JPanel() {

    private var model: TLModel = TLModel()

    init {
        model.setMode(TLModel.Color.green, TLModel.LightMode.on)
        model.setMode(TLModel.Color.yellow, TLModel.LightMode.on)
        model.setMode(TLModel.Color.red, TLModel.LightMode.on)
    }

    val green: Color = Color.getHSBColor(0.37F,0.99F,0.42F)
    val yellow: Color = Color.getHSBColor(0.163F,0.78F,0.9F)
    val red: Color = Color.getHSBColor(1F,0.88F,0.72F)
    val black: Color = Color.getHSBColor(0.547F,1F,0.09F)
    val gray: Color = Color.getHSBColor(0.591F,0.47F,0.93F)
    val radius: Int = 40
    val yBegin: Int = 100
    val xBegin: Int = 100
    val margin: Int = 10

    fun chooseColor(color: TLModel.Color, awtColor: Color) : Color {
        if (model.getMode(color) == TLModel.LightMode.off)
            return black

        return awtColor
    }

    override fun paint(g: Graphics) {
        g.color = gray
        g.fillRect(xBegin - margin, yBegin - margin, radius + 2 * margin, 3 * radius + 2 * margin)
        g.color = chooseColor(TLModel.Color.red, red)
        g.fillOval(xBegin, yBegin, radius, radius)
        g.color = chooseColor(TLModel.Color.yellow, yellow)
        g.fillOval(xBegin, yBegin + radius, radius, radius)
        g.color = chooseColor(TLModel.Color.green, green)
        g.fillOval(xBegin, yBegin + 2 * radius, radius, radius)
    }

}

private fun createAndShowGUI() {
    val frame = JFrame()
    frame.preferredSize = Dimension(400, 400)
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.title = "Traffic lights"
    frame.add(TLView())
    frame.isVisible = true
}

fun main() {
    EventQueue.invokeLater(::createAndShowGUI)
}