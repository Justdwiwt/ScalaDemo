package leetCode

import scala.collection.mutable

object Solution_403 {
  //  solution 1
  //  type pos = Int
  //  type jump = mutable.Set[Int]
  //
  //  def canCross(stones: Array[Int]): Boolean = {
  //    val m = mutable.Map[pos, jump](stones.head + 1 -> mutable.Set(1))
  //    stones.foreach(x => m.get(x).collect(jumps => jumps.foreach({ j =>
  //      m.getOrElseUpdate(x + j - 1, mutable.Set()).add(j - 1)
  //      m.getOrElseUpdate(x + j, mutable.Set()).add(j)
  //      m.getOrElseUpdate(x + j + 1, mutable.Set()).add(j + 1)
  //    })))
  //    m.contains(stones.last)
  //  }

  def canCross(stones: Array[Int]): Boolean = {
    val q = mutable.Queue((stones.head, 0))
    val s = stones.toSet
    val visited = mutable.Set[Int]()
    while (q.nonEmpty) {
      val (pos, jump) = q.dequeue()
      visited.add(pos)
      val x = jump - 1 + pos
      if (jump - 1 > 0 && s.contains(x) && !visited.contains(x)) q.enqueue((x, jump - 1))
      val y = jump + pos
      if (jump > 0 && s.contains(y) && !visited.contains(y)) q.enqueue((y, jump))
      val z = jump + 1 + pos
      if (s.contains(z) && !visited.contains(z)) q.enqueue((z, jump + 1))
    }
    visited.contains(stones.last)
  }
}
