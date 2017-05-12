val digits = "0123456789"
fun substringBeforeA(str: String): String {
    val aIndex = str.toLowerCase().indexOf('a')
    if (aIndex != -1) {
        return str.substring(0, aIndex)
    } else {
        return str
    }
}

fun printlnReverseWithBigFirstChar(str: String) {
    var reversedStr = str;
    if (str.isNotEmpty()) {
        reversedStr = str.toLowerCase().reversed();
        if (str.length > 1) {
            reversedStr = reversedStr.substring(0, 1).toUpperCase() + reversedStr.substring(1)
        } else {
            reversedStr = reversedStr.substring(0, 1).toUpperCase()
        }
    }
    println("Reversed str with first big: \"" + reversedStr + "\"")
}

fun printTextByRule(i: Int) {
    if (i >= 0 && i <= 100) {
        when (i) {
            0 -> println("Баллы не заработаны")
            1, 2 -> println("1-2 балла")
            in 3..9 -> println("Баллов меньше 10")
            in 10..55 -> println("Баллов меньше 56")
            else -> println("Баллов >= 56")
        }
    }
}

fun digitCount(str: String): Int {
    val r = str.foldRight('0') {
        total, next ->
        next + (if (digits.contains(total)) 1 else 0)
    }
    return (r - '0')
}

fun percent(prec: Int): Double {
    if (prec >= 0 && prec <= 100) {
        return prec.toDouble() / 100.0
    }
    throw IllegalArgumentException(prec.toString())
}

fun printDigits(list:List<String>?) {
    list?.let {
        run {
            val list1 = list.filter { l->l.matches(Regex("[\\d]+"))}.map(String::toInt)
            println(list1.sorted())

        }
    }
    if (list == null) println("null detected")

}

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        println("args length: " + args.size)
        println("args contains items:" + args.size)
        args.forEach { a ->
            run {
                val preparedStr = substringBeforeA(a)
                println("Original arg: \"" + a + "\" with length :" + a.length)
                println("Prepared arg: \"" + preparedStr + "\" with length :" + preparedStr.length)
                printlnReverseWithBigFirstChar(a)
                println("Digits count: " + digitCount(a))
            }
        }
    }

    printTextByRule(100)
    try {
        val percent = 50
        println(percent.toString() + "% => " + percent(50))
    } catch (e: IllegalArgumentException) {
        println("Illegal percent " + e.message)
    }

    printDigits(listOf("sadasd00","asdasd","12","2","100","1","12"))
}