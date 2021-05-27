package leetCode

import java.util

object Solution_1847 {
  def closestRoom(rooms: Array[Array[Int]], queries: Array[Array[Int]]): Array[Int] = {
    val n = rooms.length
    val m = queries.length
    val res = Array.fill(m)(0)
    val pos = new Array[Integer](m)
    queries.indices.foreach(i => pos(i) = i)
    util.Arrays.sort(pos, (a: Integer, b: Integer) => queries(b)(1) - queries(a)(1))
    val t: Array[Array[Int]] = rooms
    util.Arrays.sort(t, (o1: Array[Int], o2: Array[Int]) => o2(1) - o1(1))
    val rSorted = t
    var k = 0
    val ts = new util.TreeSet[Int]()
    pos.foreach(x => {
      val id = queries(x).head
      val area = queries(x)(1)
      while (k < n && rSorted(k)(1) >= area) {
        ts.add(rooms(k).head)
        k += 1
      }
      if (ts.size() == 0) res(x) = -1
      else {
        val floor: Integer = ts.floor(id)
        val ceil: Integer = ts.ceiling(id)
        if (floor == null || ceil == null)
          res(x) = if (floor == null) ceil else floor
        else {
          val a = (floor - id).abs
          val b = (ceil - id).abs
          res(x) = if (a <= b) floor else ceil
        }
      }
    })
    res
  }
}
