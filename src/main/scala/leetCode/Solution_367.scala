package leetCode

object Solution_367 {
  def isPerfectSquare(num: Int): Boolean = {
    @scala.annotation.tailrec
    def f(divisor: Double): Boolean = {
      val res: Double = math.pow(divisor, 2)
      if (res == num) true
      else if (res > num) false
      else f(divisor + 1)
    }

    f(1D)
  }
}
