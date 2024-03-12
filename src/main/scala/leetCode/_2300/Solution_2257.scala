package leetCode._2300

object Solution_2257 {
  def countUnguarded(m: Int, n: Int, guards: Array[Array[Int]], walls: Array[Array[Int]]): Int = {
    val grid = Array.fill(m, n)(0)
    val dir = Array((0, 1), (1, 0), (-1, 0), (0, -1))

    (guards ++ walls).foreach { case Array(r, c) => grid(r)(c) = 1 }

    def inGrid(r: Int, c: Int, dr: Int, dc: Int): Boolean =
      r + dr >= 0 && r + dr < m && c + dc >= 0 && c + dc < n

    guards
      .withFilter { case Array(_, _) => true; case _ => false }
      .foreach { case Array(r, c) => dir
        .foreach { case (dr, dc) => Iterator
          .iterate((r, c)) { case (r, c) => (r + dr, c + dc) }
          .takeWhile { case (r, c) => inGrid(r, c, dr, dc) && grid(r + dr)(c + dc) != 1 }
          .foreach { case (r, c) => grid(r + dr)(c + dc) = 2 }
        }
      }

    grid.map(r => r.count(_ == 0)).sum
  }
}
