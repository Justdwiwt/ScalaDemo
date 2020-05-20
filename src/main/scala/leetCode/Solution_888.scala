package leetCode

import scala.collection.mutable

object Solution_888 {
  def fairCandySwap(A: Array[Int], B: Array[Int]): Array[Int] = {
    var sum = 0
    val s = new mutable.HashSet[Int]()
    B.foreach(i => {
      sum += i
      s.add(i)
    })
    A.foreach(i => sum -= i)
    A.foreach(i => if (s.contains(i + sum / 2)) return Array(i, i + sum / 2))
    Array.empty
  }
}
