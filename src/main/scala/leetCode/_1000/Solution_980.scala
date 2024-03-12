package leetCode._1000

object Solution_980 {
  def uniquePathsIII(g: Array[Array[Int]]): Int = {
    case class Pos(r: Int, c: Int) {
      def gval: Int = g(r)(c)

      def inBounds: Boolean = g.indices.contains(r) && g.head.indices.contains(c)

      def peers: Array[Pos] = Array(Pos(r - 1, c), Pos(r, c + 1), Pos(r + 1, c), Pos(r, c - 1)).filter(p => p.inBounds && p.gval != -1)
    }

    val allPos = g.indices.flatMap(r => g(r).indices.map(c => Pos(r, c)))

    val start = allPos.find(_.gval == 1).get
    val end = allPos.find(_.gval == 2).get
    val len = 2 + allPos.count(_.gval == 0)

    def dfs(seen: Set[Pos], p: Pos): Int =
      if (p == end) if (seen.size == len) 1 else 0
      else p.peers.filterNot(seen).map(p => dfs(seen + p, p)).sum

    dfs(Set(start), start)
  }
}
