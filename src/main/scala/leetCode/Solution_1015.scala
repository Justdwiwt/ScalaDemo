package leetCode

object Solution_1015 {
  def smallestRepunitDivByK(K: Int): Int = {
    if (K % 2 == 0 || K % 5 == 0) return -1
    var n = 1 % K
    var cnt = 1
    while (n > 0) {
      n = (n * 10 + 1) % K
      cnt += 1
    }
    cnt
  }
}
