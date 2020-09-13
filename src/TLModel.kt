class TLModel {

    enum class LightMode {
        on,
        off
    }

    enum class Color{
        green,
        yellow,
        red
    }

    fun getMode(color: Color): LightMode = lightsModes[color]!!

    fun setMode(color: Color, lightMode: LightMode) {
        lightsModes[color] = lightMode
    }

    private var lightsModes: MutableMap<Color, LightMode> =
        mutableMapOf(Color.green to LightMode.off, Color.yellow to LightMode.off, Color.red to LightMode.off)
}