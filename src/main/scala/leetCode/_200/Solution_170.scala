package leetCode._200

import scala.collection.mutable

object Solution_170 {

  class TwoSum {
    private val all: mutable.HashSet[Int] = mutable.HashSet()
    private val duplicate: mutable.HashSet[Int] = mutable.HashSet()

    def add(number: Int): Unit = {
      if (all.contains(number)) duplicate.add(number)
      else all.add(number)
    }

    def find(value: Int): Boolean = all.exists(num => {
      val target = value - num
      (target == num && duplicate.contains(target)) || (target != num && all.contains(target))
    })
  }

}
