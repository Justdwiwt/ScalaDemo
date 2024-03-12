package leetCode._1600

object Solution_1561 {
  def maxCoins(piles: Array[Int]): Int = piles.sorted.reverse./:((false, 0, 0)) { (t3, n) =>
    if (!t3._1) (t3._2 < piles.length / 3, t3._2, t3._3)
    else (false, t3._2 + 1, n + t3._3)
  }._3
}
