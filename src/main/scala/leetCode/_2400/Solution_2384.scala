package leetCode._2400

import scala.collection.mutable

object Solution_2384 {
  def largestPalindromic(num: String): String = {
    val m = mutable.Map.empty[Int, Int].withDefaultValue(0)
    num.foreach(c => m(c - '0') += 1)
    val list = List.empty[(Int, Int)]
    val pair = m.toList.sortBy(_._1)./:((list, list)) { case ((evens, odds), (i, cnt)) =>
      val nEvens = if (cnt / 2 > 0) (i, cnt / 2) :: evens else evens
      val nOdds = if (cnt % 2 > 0) (i, cnt % 2) :: odds else odds
      (nEvens, nOdds)
    }

    pair match {
      case (Nil, odd) => odd.head._1.toString
      case (List((0, _)), odd) => odd.headOption.fold("0")(_._1.toString)
      case (even, odd) =>
        val halfEven = even.map { case (i, cnt) => i.toString * cnt }.mkString
        halfEven + odd.headOption.fold("")(_._1.toString) + halfEven.reverse
    }
  }
}
