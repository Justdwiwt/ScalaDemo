package leetCode._2300

import scala.collection.mutable

object Solution_2282 {
  def seePeople(heights: Array[Array[Int]]): Array[Array[Int]] = {
    val m = heights.length
    val n = heights.head.length
    val res = Array.ofDim[Int](m, n)

    def fill(startI: Int, endI: Int, startJ: Int, endJ: Int, moveI: Int, moveJ: Int): Unit = {
      val stack = mutable.Stack[Int]()
      var i = startI
      while (i != endI) {
        var j = startJ
        while (j != endJ) {
          while (stack.nonEmpty && heights(i)(j) > stack.top) {
            res(i)(j) += 1
            stack.pop()
          }
          if (stack.nonEmpty) res(i)(j) += 1
          if (stack.isEmpty || heights(i)(j) != stack.top) stack.push(heights(i)(j))
          j += moveJ
        }
        i += moveI
      }
    }

    heights.indices.foreach(i => fill(i, i + 1, n - 1, -1, 1, -1))
    heights.head.indices.foreach(j => fill(m - 1, -1, j, j + 1, -1, 1))

    res
  }
}
