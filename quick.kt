package test

import java.util.*

fun quickSort(list: List<Double>): List<Double> =
        if (list.isEmpty()) {
            list
        } else {
            val pivot = list.first()
            val (lower, upper) = list.subList(1, list.size).partition { it < pivot }
            quickSort(lower) + listOf(pivot) + quickSort(upper)
        }

fun main(args: Array<String>) {
    var xs = listOf<Double>()
    var isDone = false
    while (!isDone) {
        println("Enter doubles per space: ")
        try {
            xs = readLine()!!.split(" ").map(String:: toDouble)
            isDone = true
        } catch (e: NumberFormatException) {
            println("Please enter only numbers")
        }
    }
    val sorted = quickSort(xs)
    println(sorted.joinToString(" "))
    /*val st = MyStack<Int>();
    st.push(1)
    st.push(2)
    print(st)*/

}
