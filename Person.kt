import kotlin.reflect.KProperty

class Person : Comparable<Person> {
    val name: String

    var age: Int? = null
        get set
    constructor(name: String) {
        this.name = name
        this.age = null
    }

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    var isAdult: Boolean = false
        get() =  age?.let { age!! >= ADULT_AGE } ?: false

    companion object {
        private val ADULT_AGE = 18
    }

    override fun compareTo(other: Person): Int {
        if (this.age != null && other.age != null) {
            return this.age!! - other.age!!
        } else if (this.age == null) {
            return -other.age!!
        }
        return this.age!!
    }

    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }

}