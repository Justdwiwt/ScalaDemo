package leetCode

object Solution_2257 {
  def countUnguarded(m: Int, n: Int, guards: Array[Array[Int]], walls: Array[Array[Int]]): Int = {
    val arr = Array.fill(m)(Array.fill(n)('o'))

    def isObstacle(i: Int, j: Int): Boolean =
      arr(i)(j) == 'G' || arr(i)(j) == 'W'

    @scala.annotation.tailrec
    def markIPlus(i: Int, j: Int): Unit =
      if (i < m && !isObstacle(i, j)) {
        arr(i)(j) = 'g'
        markIPlus(i + 1, j)
      }

    @scala.annotation.tailrec
    def markIMinus(i: Int, j: Int): Unit =
      if (i >= 0 && !isObstacle(i, j)) {
        arr(i)(j) = 'g'
        markIMinus(i - 1, j)
      }

    @scala.annotation.tailrec
    def markJPlus(i: Int, j: Int): Unit =
      if (j < n && !isObstacle(i, j)) {
        arr(i)(j) = 'g'
        markJPlus(i, j + 1)
      }

    @scala.annotation.tailrec
    def markJMinus(i: Int, j: Int): Unit =
      if (j >= 0 && !isObstacle(i, j)) {
        arr(i)(j) = 'g'
        markJMinus(i, j - 1)
      }

    guards.foreach { case Array(i, j) => arr(i)(j) = 'G' }
    walls.foreach { case Array(i, j) => arr(i)(j) = 'W' }

    guards.foreach { case Array(i, j) =>
      markIPlus(i + 1, j)
      markIMinus(i - 1, j)
      markJPlus(i, j + 1)
      markJMinus(i, j - 1)
    }

    var res = 0
    (0 until m).foreach(i => (0 until n).foreach(j => if (arr(i)(j) == 'o') res += 1))
    res
  }
}
