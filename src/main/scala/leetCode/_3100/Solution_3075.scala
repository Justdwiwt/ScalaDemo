package leetCode._3100

object Solution_3075 {
  def maximumHappinessSum(happiness: Array[Int], k: Int): Long = {
    val sorted = happiness.sorted(Ordering[Int].reverse)
    (0 until k).map(i => (sorted(i) - i).toLong.max(0L)).sum
  }
}
