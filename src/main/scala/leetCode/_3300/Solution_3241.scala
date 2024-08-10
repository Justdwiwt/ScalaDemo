package leetCode._3300

// fixme: case 803/804 stack overflow
object Solution_3241 {
  def timeTaken(edges: Array[Array[Int]]): Array[Int] = {
    val n = edges.length + 1
    val e = Array.fill[List[Int]](n)(List.empty)

    edges.foreach { case Array(u, v) =>
      e(u) ::= v
      e(v) ::= u
    }

    val f = Array.fill(n)(0)

    def dfs1(sn: Int, fa: Int): Int = {
      f(sn) = 0
      e(sn).foreach(fn => {
        if (fn != fa) {
          val t = dfs1(fn, sn) + (if (fn % 2 == 1) 1 else 2)
          f(sn) = math.max(f(sn), t)
        }
      })
      f(sn)
    }

    dfs1(0, -1)

    val ans = Array.fill(n)(0)

    def dfs2(sn: Int, fa: Int, fv: Int): Unit = {
      ans(sn) = math.max(fv, f(sn))
      val (max1, max2, fn1, _) = e(sn).filter(_ != fa).foldLeft((-1, -1, -1, -1)) { case ((mx1, mx2, f1, f2), fn) =>
        val t = f(fn) + (if (fn % 2 == 1) 1 else 2)
        if (t > mx1) (t, mx1, fn, f1)
        else if (t > mx2) (mx1, t, f1, fn)
        else (mx1, mx2, f1, f2)
      }

      e(sn).filter(_ != fa).foreach(fn => {
        val t = if (fn == fn1) math.max(fv, max2) else math.max(fv, max1)
        dfs2(fn, sn, t + (if (sn % 2 == 1) 1 else 2))
      })
    }

    dfs2(0, -1, 0)
    ans
  }
}
