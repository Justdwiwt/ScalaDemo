package leetCode._2800

import scala.collection.mutable

object Solution_2768 {
  def countBlackBlocks(m: Int, n: Int, coordinates: Array[Array[Int]]): Array[Long] = {
    val st = coordinates.map(_.map(_.toLong).toList).toSet
    val arr = Array.fill(5)(0L)
    val vis = mutable.Set.empty[List[Long]]
    coordinates.foreach(co => {
      val x = co.head
      val y = co(1)
      (0.max(x - 1) until (x + 1).min(m - 1) by 1).foreach(i => (0.max(y - 1) until (y + 1).min(n - 1) by 1).foreach(j => {
        val point: List[Long] = List(i, j)
        if (!vis.contains(point)) {
          vis += point
          val cnt = (List(point, List(i, j + 1), List(i + 1, j), List(i + 1, j + 1)): List[List[Long]]).count(st.contains)
          arr(cnt) = arr(cnt) + 1
        }
      }))
    })
    arr(0) = (m - 1L) * (n - 1L) - vis.size
    arr
  }
}
