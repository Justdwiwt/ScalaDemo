package leetCode._2500

object Solution_2450 {
  def countDistinctStrings(s: String, k: Int): Int =
    (BigInt(2).pow(s.length - k + 1) % (BigInt(10).pow(9) + 7)).toInt
}
