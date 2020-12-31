package leetCode

object Solution_1012 {
  def numDupDigitsAtMostN(N: Int): Int = {
    val str = N.toString
    var res = 0
    val arr = Array.fill(str.length, 1 << 10, 2)(-1)
    (1 to (str.head - '0')).foreach(i => {
      if (i < str.head - '0') res += g(1, str.length, 0, str, 1 << i, arr)
      else if (i == str.head - '0') res += g(1, str.length, 1, str, 1 << i, arr)
    })
    var n = 0
    str.indices.drop(1).reverse.withFilter(k => k > 0).foreach(k => n += f(9, k) + (k - 1) * f(9, k - 1))
    N - res - n
  }

  def f(n: Int, m: Int): Int = {
    if (m > n) return 0
    var res = 1
    var i = n
    while (i >= (n - m + 1)) {
      res *= i
      i -= 1
    }
    res
  }

  def g(idx: Int, len: Int, rb: Int, str: String, state: Int, arr: Array[Array[Array[Int]]]): Int = {
    if (idx >= len) return 1
    if (arr(idx)(state)(rb) > 0) return arr(idx)(state)(rb)
    val upper = if (rb == 1) str(idx) - '0' else 9
    var res = 0
    (0 to upper).foreach(i => if ((state & (1 << i)) == 0) res += g(idx + 1, len, if (rb == 1 && i == upper) 1 else 0, str, state | (1 << i), arr))
    arr(idx)(state)(rb) = res
    res
  }
}
