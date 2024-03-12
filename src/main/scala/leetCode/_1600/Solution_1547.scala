package leetCode._1600

import scala.collection.mutable

object Solution_1547 {
  def minCost(n: Int, cuts: Array[Int]): Int = f(0 +: cuts.sorted :+ n)

  def f(cuts: Array[Int]): Int = {
    val dp = mutable.Map((0 to cuts.length - 2).map(i => (i, i + 1) -> 0): _*)
    cuts.indices.drop(2).foreach(i =>
      (0 until cuts.length - i).foreach(j =>
        dp(j -> (j + i)) = cuts(j + i) - cuts(j) + (j + 1 until j + i)
          .map(k => dp(j, k) + dp(k, j + i)).min))
    dp(0, cuts.length - 1)
  }
}
