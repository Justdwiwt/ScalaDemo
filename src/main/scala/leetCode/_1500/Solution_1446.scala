package leetCode._1500

object Solution_1446 {
  def maxPower(s: String): Int = s.indices.tail.foldLeft(1, 1) {
    case ((max, cur), i) => if (s(i) == s(i - 1)) ((cur + 1).max(max), cur + 1) else (max, 1)
  }._1
}
