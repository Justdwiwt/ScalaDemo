package leetCode

import scala.collection.mutable

object Solution_927 {
  def threeEqualParts(array: Array[Int]): Array[Int] = {
    val power = BigInt(2).pow _
    if (array.length < 3) return Array(-1, -1)
    if (array.length == 3) return if (array(0) == array(1) && array(1) == array(2)) Array(0, 2) else Array(-1, -1)
    var start = 0
    while (start < array.length && array(start) == 0) start += 1
    if (start >= array.length) return Array(0, array.length - 2)
    val preSumTab = Array.ofDim[BigInt](array.length)
    preSumTab(start) = if (array(start) == 1) power(array.length - 1 - start) else 0
    (start + 1 until array.length).foreach(i => preSumTab(i) = preSumTab(i - 1) + (if (array(i) == 1) power(array.length - i - 1) else 0))
    val firstMap = mutable.Map[BigInt, Int]()
    (start to array.length - 3).foreach(i => {
      val t: BigInt = preSumTab(i) / power(array.length - i - 1)
      firstMap += t -> i
    })
    (array.length - 1 to start + 2 by -1).foreach(i => {
      val t: BigInt = preSumTab(array.length - 1) - preSumTab(i - 1)
      if (firstMap.contains(t)) {
        val left = firstMap(t)
        if (((preSumTab(i - 1) - preSumTab(left)) / power(array.length - i)) == t) return Array(left, i)
      }
    })
    Array(-1, -1)
  }
}
