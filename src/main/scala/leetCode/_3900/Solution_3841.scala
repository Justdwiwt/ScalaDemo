package leetCode._3900

object Solution_3841 {
  def palindromePath(n: Int, edges: Array[Array[Int]], s: String, queries: Array[String]): List[Boolean] = {
    val adj = edges.foldLeft(Vector.fill(n)(List.empty[Int])) { (acc, e) =>
      acc.updated(e(0), e(1) :: acc(e(0))).updated(e(1), e(0) :: acc(e(1)))
    }

    val maxLog = 32 - Integer.numberOfLeadingZeros(n)
    val depth = new Array[Int](n)
    val up = Array.ofDim[Int](n, maxLog)
    val tin = new Array[Int](n)
    val tout = new Array[Int](n)
    val pathXor = new Array[Int](n)
    var timer = 0

    def dfs(u: Int, p: Int, d: Int, currentMask: Int, charMasks: Array[Int]): Unit = {
      timer += 1
      tin(u) = timer
      depth(u) = d
      up(u)(0) = p
      pathXor(u) = currentMask ^ charMasks(u)
      adj(u).withFilter(_ != p).foreach(dfs(_, u, d + 1, pathXor(u), charMasks))
      tout(u) = timer
    }

    val initialMasks = s.map(c => 1 << (c - 'a')).toArray
    dfs(0, 0, 0, 0, initialMasks)

    (1 until maxLog).foreach(i => (0 until n).foreach(u => up(u)(i) = up(up(u)(i - 1))(i - 1)))

    def getLca(u: Int, v: Int): Int = {
      var (a, b) = if (depth(u) < depth(v)) (v, u) else (u, v)
      ((maxLog - 1) to 0 by -1).foreach(i => if (depth(a) - (1 << i) >= depth(b)) a = up(a)(i))
      if (a == b) return a
      ((maxLog - 1) to 0 by -1).foreach(i => if (up(a)(i) != up(b)(i)) {
        a = up(a)(i)
        b = up(b)(i)
      })
      up(a)(0)
    }

    val bit = new Array[Int](n + 2)

    def update(i: Int, v: Int): Unit = {
      var x = i
      while (x <= n) {
        bit(x) ^= v
        x += x & -x
      }
    }

    def query(i: Int): Int = {
      var x = i
      var res = 0
      while (x > 0) {
        res ^= bit(x)
        x -= x & -x
      }
      res
    }

    val currentMasks = initialMasks.clone()
    queries.toList.map(q => {
      val parts = q.split(" ")
      if (parts(0) == "update") {
        val node = parts(1).toInt
        val newMask = 1 << (parts(2).head - 'a')
        val diff = currentMasks(node) ^ newMask
        currentMasks(node) = newMask
        update(tin(node), diff)
        update(tout(node) + 1, diff)
        false
      } else {
        val u = parts(1).toInt
        val v = parts(2).toInt
        val lca = getLca(u, v)
        val res = pathXor(u) ^ pathXor(v) ^ query(tin(u)) ^ query(tin(v)) ^ currentMasks(lca)
        (res & (res - 1)) == 0
      }
    }).zip(queries).filterNot(_._2.startsWith("update")).map(_._1)
  }
}
