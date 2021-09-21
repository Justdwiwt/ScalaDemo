package leetCode

object Solution_1997 {
  def firstDayBeenInAllRooms(nextVisit: Array[Int]): Int = {
    val f = Array.fill[Long](nextVisit.length)(0)
    val g = Array.fill[Long](nextVisit.length)(0)
    f(0) = 1
    g(0) = 2
    val M = 1000000007L
    nextVisit.indices.drop(1).foreach(i => {
      f(i) = (g(i - 1) + 1) % M
      g(i) = (2 * f(i) - f(nextVisit(i)) + 1) % M
    })
    ((f.last + M - 1) % M).toInt
  }
}
