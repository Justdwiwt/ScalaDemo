package leetCode._1500

import scala.collection.mutable

object Solution_1429 {
  class FirstUnique(nums: Array[Int]) {
    private val setQueue = mutable.LinkedHashSet.empty[Int]
    private val isUnique = mutable.Map.empty[Int, Boolean]

    nums.foreach(add)

    def showFirstUnique(): Int =
      setQueue.headOption.getOrElse(-1)

    private def add(value: Int): Unit =
      if (!isUnique.contains(value)) {
        isUnique(value) = true
        setQueue.add(value)
      } else if (isUnique(value)) {
        isUnique(value) = false
        setQueue.remove(value)
      }
  }
}
