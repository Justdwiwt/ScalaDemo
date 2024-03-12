package leetCode._1000

import scala.collection.mutable

object Solution_907 {
  def sumSubarrayMins(arr: Array[Int]): Int = {
    val M = (1e9 + 7).toInt
    var sum = 0L
    val stack = mutable.Stack[Int]()
    val a = 0 +: arr :+ 0
    a.indices.foreach(i => {
      while (stack.nonEmpty && a(stack.top) > a(i)) {
        val j = stack.pop()
        val k = stack.top
        val s = (a(j).toLong * (i - j) * (j - k)) % M
        sum = (sum + s) % M
      }
      stack.push(i)
    })
    sum.toInt
  }
}
