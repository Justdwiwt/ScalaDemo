package leetCode._3300

// fixme: case 723/725 timeout
object Solution_3288 {
  def maxPathLength(coordinates: Array[Array[Int]], k: Int): Int = {
    val (kx, ky) = (coordinates(k).head, coordinates(k)(1))

    val sorted = coordinates.sortBy { case Array(x, y) => (x, -y) }

    def bisectLeft(g: List[Int], y: Int): (List[Int], Int) = {
      val (left, right) = g.span(_ < y)
      (left ::: y :: right.drop(1), left.length)
    }

    val res = sorted.foldLeft(List.empty[Int]) {
      case (acc, Array(x, y)) if (x < kx && y < ky) || (x > kx && y > ky) =>
        val (updatedG, _) = bisectLeft(acc, y)
        updatedG
      case (acc, _) => acc
    }

    res.length + 1
  }
}
