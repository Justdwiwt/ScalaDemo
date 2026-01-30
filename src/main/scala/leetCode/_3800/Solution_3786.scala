package leetCode._3800

object Solution_3786 {
  def interactionCosts(n: Int, edges: Array[Array[Int]], group: Array[Int]): Long = {
    val g = Array.fill(n)(List.empty[Int])
    edges.foreach {
      case Array(x, y) =>
        g(x) = y :: g(x)
        g(y) = x :: g(y)
    }

    val totalCnt = collection.mutable.Map.empty[Int, Int]
    group.foreach(x => totalCnt.update(x, totalCnt.getOrElse(x, 0) + 1))

    var ans = 0L

    def dfs(x: Int, fa: Int): collection.mutable.Map[Int, Int] = {
      val cntX = collection.mutable.Map(group(x) -> 1)

      g(x).foreach(y => {
        if (y != fa) {
          val cntY = dfs(y, x)

          cntY.foreach {
            case (i, c) =>
              ans += c.toLong * (totalCnt(i) - c)
              cntX.update(i, cntX.getOrElse(i, 0) + c)
          }
        }
      })
      cntX
    }

    dfs(0, -1)
    ans
  }
}
