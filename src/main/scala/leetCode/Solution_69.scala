package leetCode

object Solution_69 {
  def mySqrt(x: Int): Int = x match {
    case x: Int if x <= 1 => x
    case a: Int =>
      var res: Double = 0

      @scala.annotation.tailrec
      def recur(x_ : Double): Double = {
        res = (x_ + a / x_) / 2
        if (res == x_) x_ else recur(res)
      }

      recur(a).toInt
  }
}
