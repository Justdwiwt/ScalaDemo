package leetCode._3400

object Solution_3365 {
  def isPossibleToRearrange(s: String, t: String, k: Int): Boolean = {
    val n = s.length
    val subLength = n / k
    val sArr = (0 until k).map(i => s.substring(subLength * i, subLength * (i + 1))).sorted
    val tArr = (0 until k).map(i => t.substring(subLength * i, subLength * (i + 1))).sorted
    sArr == tArr
  }
}
