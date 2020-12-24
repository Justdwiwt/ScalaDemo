package leetCode

object Solution_974 {
  def subarraysDivByK(A: Array[Int], K: Int): Int = A.scanLeft(0)(_ + _)./:(Map[Int, Int](), 0: Int) {
    case ((pre, cur), sum) =>
      val M = (sum % K + K) % K
      if (pre.contains(M)) (pre + (M -> (pre.getOrElse(M, 0) + 1)), cur + pre.getOrElse(M, 0))
      else (pre + (M -> pre.getOrElse(M, 1)), cur)
  }._2
}
