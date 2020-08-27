package leetCode

object Solution_849 {
  def maxDistToClosest(seats: Array[Int]): Int = {
    val pos = seats.zipWithIndex.filter(_._1 == 1)
    val mid = pos.zip(pos.tail).foldLeft(0)(
      (dis, x) => dis.max((x._2._2 - x._1._2) / 2)
    )
    disOfp(seats, 0).max(disOfp(seats, seats.indices.last)).max(mid)
  }

  def d0(seats: Array[Int]): Int = seats.indexOf(1)

  def dn(seats: Array[Int]): Int = seats.indices.last - seats.lastIndexOf(1)

  def disOfp(seats: Array[Int], p: Int): Int = {
    var l = 0
    var lf = true
    var r = 0
    var rf = true
    (0 to p).reverse.withFilter(_ => lf).foreach(x => if (seats(x) == 1) lf = false else l += 1)
    if (p - l < 0) l = Int.MaxValue
    (p until seats.length).withFilter(_ => rf).foreach(x => if (seats(x) == 1) rf = false else r += 1)
    if (p + r > seats.length - 1) r = Int.MaxValue
    l.min(r)
  }
}
