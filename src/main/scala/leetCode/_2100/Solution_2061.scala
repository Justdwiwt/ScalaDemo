package leetCode._2100

object Solution_2061 {
  private val dir = Array((0, 1), (1, 0), (0, -1), (-1, 0))

  def numberOfCleanRooms(room: Array[Array[Int]]): Int = {
    val m = room.length
    val n = room.head.length
    var x = 0
    var y = 0
    var dr = 0
    var seen = Set((0, 0, 3))

    while (!seen.contains((x, y, dr))) {
      seen += ((x, y, dr))
      if (0 <= x + dir(dr)._1 && x + dir(dr)._1 < m && 0 <= y + dir(dr)._2 && y + dir(dr)._2 < n && room(x + dir(dr)._1)(y + dir(dr)._2) == 0) {
        x = x + dir(dr)._1
        y = y + dir(dr)._2
      } else dr = (dr + 1) & 3
    }
    seen.map { case (a, b, _) => (a, b) }.size
  }
}
