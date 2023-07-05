package leetCode

object Solution_2749 {
  def makeTheIntegerZero(num1: Int, num2: Int): Int = (0 to 60)
    .find(k => {
      val target = num1.toLong - k.toLong * num2
      val bitCount = target.toBinaryString.count(_ == '1')
      target >= 0 && bitCount <= k && k <= target
    })
    .getOrElse(-1)
}
