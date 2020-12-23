package leetCode

object Solution_1232 {
  def checkStraightLine(coordinates: Array[Array[Int]]): Boolean = {
    val sorted = coordinates.sortWith(_.head < _.head)
    if (sorted.length == 2) true
    else {
      val slop = Array(sorted(1).head - sorted.head.head, sorted(1)(1) - sorted.head(1))
      sorted.drop(2)./:(true) { (x, y) =>
        if (!x) false
        else (y.head - sorted.head.head) * slop(1) == (y(1) - sorted.head(1)) * slop.head
      }
    }
  }
}
