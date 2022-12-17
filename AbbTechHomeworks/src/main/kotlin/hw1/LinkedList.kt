package hw1

import java.util.Collections
fun main() {
    val listStrs = listOf('a', 'B', 'A', 'b', 'A', 'a')
    print(listStrs.uniqueOrdered())

    val listInts = listOf(
        1,
        3,
        5,
        4,
        2,
        2,
    )

    println(listInts.uniqueOrdered())
}

fun <T : Comparable<T>> List<T>.uniqueOrdered(): List<T> {
    val filteredList = mutableListOf<T>()

    for (i in this) {
        if (filteredList.contains(i).not()) {
            filteredList.add(i)
        }
    }
    for (i in filteredList.indices) {
        for (j in filteredList.indices.toMutableList().takeLast(filteredList.size - i - 1)) {
            if (filteredList[i] > filteredList[j]) {
                Collections.swap(filteredList, i, j)
            }
        }
    }
    return filteredList
}