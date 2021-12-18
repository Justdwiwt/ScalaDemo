package leetCode

object LCS_01 {
  def leastMinutes(n: Int): Int =
    math.ceil(math.log(n) / math.log(2)).toInt + 1
}
