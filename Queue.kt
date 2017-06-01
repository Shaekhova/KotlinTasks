package test

class Queue<T>(list: MutableList<T>) {
    var items: MutableList<T> = list

    fun isEmpty(): Boolean {
        return this.items.isEmpty()
    }

    fun count(): Int {
        return this.items.count()
    }

    fun enqueue(element: T) {
        this.items.add(element)
    }

    fun dequeue(): T? {
        if (this.isEmpty()) {
            return null
        } else {
            return this.items.removeAt(0)
        }
    }

    fun peek(): T? {
        return this.items[0]
    }

    override fun toString(): String {
        return this.items.toString()
    }
}
