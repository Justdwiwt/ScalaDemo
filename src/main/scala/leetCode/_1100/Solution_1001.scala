package leetCode._1100

import scala.collection.mutable

object Solution_1001 {
  def gridIllumination(N: Int, lamps: Array[Array[Int]], queries: Array[Array[Int]]): Array[Int] = {
    val dir = Array(Array(0, 1), Array(0, -1), Array(1, 0), Array(-1, 0), Array(1, 1), Array(-1, 1), Array(-1, -1), Array(1, -1), Array(0, 0))

    val res = Array.fill(queries.length)(0)

    val row = mutable.HashMap.empty[Int, Int]
    val col = mutable.HashMap.empty[Int, Int]
    val d1 = mutable.HashMap.empty[Int, Int]
    val d2 = mutable.HashMap.empty[Int, Int]
    val cellNo = mutable.HashMap.empty[Int, Boolean]

    lamps.indices.foreach(i => {
      val r = lamps(i).head
      val c = lamps(i)(1)
      if (!cellNo.contains(N * r + c)) {
        row += r -> (row.getOrElse(r, 0) + 1)
        col += c -> (col.getOrElse(c, 0) + 1)
        d1 += (r - c) -> (d1.getOrElse(r - c, 0) + 1)
        d2 += (r + c) -> (d2.getOrElse(r + c, 0) + 1)
        cellNo += (N * r + c) -> true
      }
    })

    queries.indices.foreach(i => {
      val r = queries(i).head
      val c = queries(i)(1)
      res(i) = if (row.getOrElse(r, 0) > 0 || col.getOrElse(c, 0) > 0 || d1.getOrElse(r - c, 0) > 0 || d2.getOrElse(r + c, 0) > 0) 1 else 0
      dir.foreach(d => {
        val r1 = r + d.head
        val c1 = c + d(1)
        if (r1 >= 0 && r1 < N && c1 >= 0 && c1 < N)
          if (cellNo.contains(N * r1 + c1) && cellNo(N * r1 + c1)) {
            row += r1 -> (row.getOrElse(r1, 1) - 1)
            col += c1 -> (col.getOrElse(c1, 1) - 1)
            d1 += (r1 - c1) -> (d1.getOrElse(r1 - c1, 1) - 1)
            d2 += (r1 + c1) -> (d2.getOrElse(r1 + c1, 1) - 1)
            cellNo += (N * r1 + c1) -> false
          }
      })
    })

    res
  }
}
