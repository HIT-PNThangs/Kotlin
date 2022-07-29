package Box

class Box(
    private var length: Int,
    private var width: Int,
    private var height: Int
) {
    constructor(a: Int) : this(a,  a,  a)
    constructor() : this(0,  0,  0)

    init {
        println("Init Block Called")
    }

    val theTich
        get() = length * width * height

    fun fillContents() {
        println("Box is Filled")
    }

    override fun toString() = "length= $length width= $width height= $height"
}