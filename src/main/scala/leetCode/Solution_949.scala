package leetCode

object Solution_949 {
  def largestTimeFromDigits(A: Array[Int]): String = {
    var res = -1
    (0 until 4).foreach(i => (0 until 4).foreach(j => {
      if (j != i) (0 until 4).foreach(k => if (k != i && k != j) {
        val l = 6 - i - j - k
        val hour = 10 * A(i) + A(j)
        val min = 10 * A(k) + A(l)
        if (hour < 24 && min < 60) res = res.max(hour * 60 + min)
      })
    }))
    if (res >= 0) "%02d:%02d".format(res / 60, res % 60) else ""
  }
}
