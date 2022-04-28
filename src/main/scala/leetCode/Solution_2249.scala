package leetCode

object Solution_2249 {
  def countLatticePoints(circles: Array[Array[Int]]): Int = {
    var res = 0

    def f(x: Int, y: Int): Boolean = {
      circles.foreach(circle => {
        val distSq = math.pow(x - circle.head, 2) + math.pow(y - circle(1), 2)
        if (distSq <= math.pow(circle(2), 2)) return true
      })
      false
    }

    (0 to 200).foreach(x => (0 to 200).foreach(y => if (f(x, y)) res += 1))
    res
  }
}
