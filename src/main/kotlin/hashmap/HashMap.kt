package hashmap

import java.util.LinkedList
import kotlin.math.absoluteValue

fun main(){
    val map = KotlinHashMap<Person>(46)

    val personOne = Person(
        "aa",
        35
    )

    val personTwo = Person(
        "r",
        21
    )

    print("aa".hashCode() % 46)
    print("\n")

    print("r".hashCode() % 46)
    print("\n")


    map.put(
        personOne.name,
        personOne
    )

    map.put(
        personTwo.name,
        personTwo
    )

    println(
        map.get(personOne.name)
    )

    println(
        map.get(personTwo.name)
    )

}

data class Person(
    val name: String,
    val age: Int
)

//The address of each array element must be derived from the value passed into the hash function.
//Here we use Chaining to solve collisions. This means having LinkedLists instead of just single elements at each array
// index.
class KotlinHashMap<VAL>(
    private val initialSize: Int,
    private var backingArray: Array<LinkedList<Entry<VAL>>?> = arrayOfNulls(initialSize)
) {

    data class Entry<VAL>(val key: String, val value: VAL)

    fun getHash(key: String): Int {
        return key.hashCode().absoluteValue % initialSize
    }

    //average of O(1)
    fun put(key: String, value: VAL) {
        val entry = Entry(key, value)
        val list = backingArray[getHash(key)]
        if (list == null) backingArray[getHash(key)] = LinkedList<Entry<VAL>>().apply { add(entry) }
        else list.add(entry)
    }

    fun get(key: String): VAL? {
        val list = backingArray[getHash(key)]

        list?.forEach { if (it.key == key) return it.value }

        return null
    }

    fun remove(key: String) {
        val list = backingArray[getHash(key)]
        list?.forEach { if (it.key == key) list.remove(it)}
    }
}