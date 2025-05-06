package leetCode._3600

object Solution_3531 {
  def countCoveredBuildings(n: Int, buildings: Array[Array[Int]]): Int = {
    val top = new Array[Int](n + 1)
    val bottom = new Array[Int](n + 1)
    val left = new Array[Int](n + 1)
    val right = new Array[Int](n + 1)

    buildings.foreach {
      case Array(x, y) =>
        top(x) = top(x).max(y)
        bottom(x) = if (bottom(x) == 0) y else bottom(x).min(y)
        left(y) = if (left(y) == 0) x else left(y).min(x)
        right(y) = right(y).max(x)
    }

    buildings.foldLeft(0) {
      case (count, Array(x, y)) =>
        if (y < top(x) && y > bottom(x) && x > left(y) && x < right(y)) count + 1
        else count
    }
  }
}
