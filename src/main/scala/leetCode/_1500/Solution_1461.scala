package leetCode._1500

object Solution_1461 {
  def hasAllCodes(s: String, k: Int): Boolean =
    s.sliding(k).toSet.size == 1 << k
}
