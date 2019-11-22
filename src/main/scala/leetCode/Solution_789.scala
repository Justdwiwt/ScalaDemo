package leetCode

object Solution_789 {
  def escapeGhosts(ghosts: Array[Array[Int]], target: Array[Int]): Boolean = {
    val dist = target(0).abs + target(1).abs
    ghosts.foreach(i => {
      val t = (i(0) - target(0)).abs + (i(1) - target(1)).abs
      if (t <= dist) return false
    })
    true
  }
}
