package leetCode.crackingCodeInterview

object Code_16_05 {
  def trailingZeroes(n: Int): Int = {
    var res = 0
    var t = n
    while (t != 0) {
      t /= 5
      res += t
    }
    res
  }
}
