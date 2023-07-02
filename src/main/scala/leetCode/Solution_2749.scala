package leetCode

object Solution_2749 {
  def makeTheIntegerZero(num1: Int, num2: Int): Int = {
    (1 to 50).foreach(i => {
      val p = num1.toLong - num2.toLong * i
      if (p >= i && java.lang.Long.bitCount(p) <= i) return i
    })
    -1
  }
}
