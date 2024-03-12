package leetCode._1100

object Solution_1005 {
  def largestSumAfterKNegations(A: Array[Int], K: Int): Int = {
    val l = A.filter(_ < 0)
    val r = A.filter(_ >= 0)
    val mn = A.map(x => x.abs).min
    if (K >= l.length) (K - l.length) % 2 match {
      case 0 => A.map(x => x.abs).sum
      case 1 => A.map(x => x.abs).sum - 2 * mn
    } else l.sorted.zipWithIndex.map(i => if (i._2 < K) -i._1 else i._1).sum + r.sum
  }
}
