import java.security.SecureRandom
import java.util.*

val set1 : List<Color> = listOf(Color.RED, Color.YELLOW)
val set2 : List<Color> = listOf(Color.YELLOW, Color.BLUE)
val set3 : List<Color> = listOf(Color.BLUE, Color.VIOLET)
fun getMnemonicSynonym(color: Color): String {
    when (color) {
        Color.RED -> return "Richard"
        Color.ORANGE -> return "Of"
        Color.YELLOW -> return "York"
        Color.GREEN -> return "Gave"
        Color.BLUE -> return "Battle"
        Color.INDIGO -> return "In"
        Color.VIOLET -> return "Vain"
    }
}

fun getNewColor(color1: Color, color2: Color):Color{
    if (color1 == color2) return color1
    if (color1 in set1 && color2 in set1) return Color.ORANGE
    if (color1 in set2 && color2 in set2) return Color.GREEN
    if (color1 in set3 && color2 in set3) return Color.INDIGO
    throw Exception("bad colors :(")
}
fun main(args: Array<String>) {
    val random = Random()
    val p1 = Person("name1")
    val p2 = Person("name2",18)
    println(p1.isAdult)
    println(p2.isAdult)
    println(p2==p1)

    println(getMnemonicSynonym(Color.VIOLET))
    println(getNewColor(Color.RED, Color.YELLOW))

    val persons: MutableList<Person> = mutableListOf();
    for (i in 0 until 10) {
        persons.add(Person("name $i", age = random.nextInt(100)))
    }
    println(persons.filter(Person::isAdult))
}