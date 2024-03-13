package leetCode._3000

object Solution_2998 {
  def minimumOperationsToMakeEqual(x: Int, y: Int): Int = {
    @scala.annotation.tailrec
    def dfs(toVisit: Seq[Int], visited: Set[Int], steps: Int): Int = {
      if (toVisit.contains(y)) steps
      else {
        val next = toVisit
          .flatMap(n => Seq(n + 1, n - 1)
            ++ (if (n % 11 == 0) Seq(n / 11) else Seq.empty[Int])
            ++ (if (n % 5 == 0) Seq(n / 5) else Seq.empty[Int]))
          .filterNot(visited.contains)
        dfs(next, visited ++ next, steps + 1)
      }
    }

    dfs(toVisit = Seq(x), visited = Set(x), steps = 0)
  }
}
