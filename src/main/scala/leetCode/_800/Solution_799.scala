package leetCode._800

object Solution_799 {
  def champagneTower(poured: Int, query_row: Int, query_glass: Int): Double = {
    def getSpill(pin: Double): List[Double] = {
      val half = (pin - 1).max(0.0) * 0.5
      List(half, half)
    }

    def joinSpill(left: List[Double], right: List[Double]): List[Double] =
      left.init ::: (left.last + right.head) :: right.tail

    def nextSpill(last: List[Double]): List[Double] =
      last.map(getSpill).reduce(joinSpill)

    @scala.annotation.tailrec
    def f(last: List[Double] = List(poured.toDouble), layer: Int = 0): Double =
      if (layer >= query_row) last(query_glass)
      else f(nextSpill(last), layer + 1)

    f().min(1.0)
  }
}
