package leetCode

object Solution_264 {
  def nthUglyNumber(n: Int): Int = {
    val dp: Array[Int] = new Array[Int](n)

    var index_2 = 0
    var index_3 = 0
    var index_5 = 0

    var v_2 = 2
    var v_3 = 3
    var v_5 = 5

    var i = 1

    dp(0) = 1

    while (i < n) {
      val v = min(v_2, min(v_3, v_5))
      if (v == v_2) {
        dp(i) = v_2
        index_2 += 1
        v_2 = dp(index_2) * 2
      }
      if (v == v_3) {
        dp(i) = v_3
        index_3 += 1
        v_3 = dp(index_3) * 3
      }
      if (v == v_5) {
        dp(i) = v_5
        index_5 += 1
        v_5 = dp(index_5) * 5
      }
      i += 1
    }
    dp(n - 1)
  }

  def min(a: Int, b: Int): Int = {
    if (b < a) b
    else a
  }

}
