package leetCode._3500

object Solution_3424 {
  def minCost(arr: Array[Int], brr: Array[Int], k: Long): Long = {
    val r1 = arr.zip(brr).map { case (x, y) => (x - y).abs.toLong }.sum
    val r2 = arr.sorted.zip(brr.sorted).map { case (x, y) => (x - y).abs.toLong }.sum + k
    r2.min(r1)
  }
}
