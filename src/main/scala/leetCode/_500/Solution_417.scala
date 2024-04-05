package leetCode._500

object Solution_417 {
  def pacificAtlantic(heights: Array[Array[Int]]): List[List[Int]] = {
    val (m, n) = (heights.length, heights.head.length)
    val pacificShore = (heights.indices.map((_, 0)) ++ heights.head.indices.map((0, _))).toList
    val atlanticShore = (heights.indices.map((_, n - 1)) ++ heights.head.indices.map((m - 1, _))).toList
    val both = f(pacificShore, Set.empty, heights).intersect(f(atlanticShore, Set.empty, heights))
    both.map(c => List(c._1, c._2)).toList
  }

  @scala.annotation.tailrec
  private def f(visit: List[(Int, Int)], visited: Set[(Int, Int)], heights: Array[Array[Int]]): Set[(Int, Int)] = visit match {
    case Nil => visited
    case (i, j) :: tail =>
      if (visited.contains((i, j))) f(tail, visited, heights)
      else {
        val close = List((i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1))
        val border = close.filter(c => c._1 >= 0 && c._1 < heights.length && c._2 >= 0 && c._2 < heights.head.length)
        val higher = border.filter(c => heights(c._1)(c._2) >= heights(i)(j))
        f(higher ::: tail, visited + ((i, j)), heights)
      }
  }
}
