package leetCode

object Solution_7 {
  def reverse(x: Int): Int = {
    var ans: Int = 0
    if (x > 0) {
      val tmp: Long = x.toLong.toString.reverse.toLong
      if (tmp <= Int.MaxValue) ans = tmp.toInt
    } else if (x < 0) {
      val tmp: Long = x.toLong.abs.toString.reverse.toLong * -1
      if (tmp >= Int.MinValue) ans = tmp.toInt
    }
    ans
  }
}
