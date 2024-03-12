package leetCode._500

object Solution_403 {
  def canCross(stones: Array[Int]): Boolean = {
    val m = stones.zipWithIndex.toMap
    val arr = Array.fill[Set[Int]](stones.length)(Set.empty)
    arr(0) = arr(0) + 0
    stones.indices.foreach(i => {
      val steps = arr(i).flatMap(x => List(-1, 0, 1).map(_ + x).filter(_ != 0))
      steps.foreach(step => {
        val pos = m.getOrElse(stones(i) + step, -1)
        if (pos >= 0) arr(pos) = arr(pos) + step
      })
    })
    arr.last.nonEmpty
  }
}
