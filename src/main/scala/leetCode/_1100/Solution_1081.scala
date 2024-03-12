package leetCode._1100

import scala.collection.mutable

object Solution_1081 {
  def smallestSubsequence(s: String): String = {
    val stack = mutable.Stack[Int]()
    val arr = Array.ofDim[Int](26)
    val seen = Array.ofDim[Int](26)
    s.indices.foreach(i => arr(s(i) - 'a') = i)
    s.zipWithIndex.foreach({ case (char, ind) =>
      val ch = char - 'a'
      if (seen(ch) == 0) {
        seen(ch) += 1
        while (stack.nonEmpty && stack.top > ch && arr(stack.top) > ind)
          seen(stack.pop) = 0
        stack.push(ch)
      }
    })
    stack.map('a' + _).map(_.toChar)./:("")(_ + _).reverse
  }
}
