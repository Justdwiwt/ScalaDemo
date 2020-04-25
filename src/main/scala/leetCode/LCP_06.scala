package leetCode

object LCP_06 {
  def minCount(coins: Array[Int]): Int = coins.map(i => if (i % 2 != 0) i + 1 else i).sum / 2
}
