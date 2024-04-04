package leetCode._600

object Solution_517 {
  def findMinMoves(machines: Array[Int]): Int = {
    val total = machines.sum
    if (total % machines.length != 0) -1
    else {
      val avg = total / machines.length
      machines.foldLeft((0, 0)) { case ((cnt, max), load) =>
        (cnt + load - avg, (load - avg).max(max.max(cnt.abs)))
      }._2
    }
  }
}
