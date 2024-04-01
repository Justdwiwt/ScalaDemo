package leetCode._900

object Solution_864 {
  def shortestPathAllKeys(grid: Array[String]): Int = {
    val (m, n) = (grid.length, grid.head.length)

    def inGrid(i: Int, j: Int): Boolean =
      (0 <= i && i < m) && (0 <= j && j < n)

    def isWall(i: Int, j: Int): Boolean =
      grid(i)(j) == '#'

    def key(i: Int, j: Int): Option[Int] = grid(i)(j) match {
      case c if c.isLower => Some(c.asDigit)
      case _ => None
    }

    def lock(i: Int, j: Int): Option[Int] = grid(i)(j) match {
      case c if c.isUpper => Some(c.asDigit)
      case _ => None
    }

    val startI = grid.indexWhere(_.contains('@'))
    val startJ = grid(startI).indexOf('@')

    val bfs = Stream.iterate((
      Set.empty[(Int, Int, Set[Int])],
      Set((startI, startJ, Set.empty[Int]))
    )) { case (visited, toVisit) =>
      val next = toVisit.flatMap { case (i, j, keys) =>
        Seq((i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1))
          .withFilter { case (k, l) => inGrid(k, l) && !visited(k, l, keys) }
          .withFilter { case (k, l) => !isWall(k, l) && lock(i, j).forall(keys.contains) }
          .map { case (k, l) => (k, l, keys | key(k, l).toSet) }
      }
      (visited | next, next)
    }

    val keyCount = grid.map(_.count(_.isLower)).sum
    bfs.zipWithIndex.collectFirst {
      case ((_, toVisit), idx) if toVisit.exists(_._3.size == keyCount) => idx
      case ((_, toVisit), _) if toVisit.isEmpty => -1
    }.get
  }
}
