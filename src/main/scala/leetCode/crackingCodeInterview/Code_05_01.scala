package leetCode.crackingCodeInterview

object Code_05_01 {
  def insertBits(N: Int, M: Int, i: Int, j: Int): Int = {
    var n = N
    n &= ~(((1 << (j - i + 1)) - 1) << i)
    n | (M << i)
  }
}
