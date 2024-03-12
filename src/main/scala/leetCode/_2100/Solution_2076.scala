package leetCode._2100

object Solution_2076 {
  def friendRequests(n: Int, restrictions: Array[Array[Int]], requests: Array[Array[Int]]): Array[Boolean] = {
    var arr = Array.tabulate(n)(identity)

    def root(dsu: Array[Int], i: Int): Int =
      if (i == dsu(i)) i
      else {
        dsu(i) = root(dsu, dsu(i))
        dsu(i)
      }

    def procReq(a: Int, b: Int): (Boolean, Array[Int]) = {
      val t = arr.clone()
      t(root(t, a)) = root(t, b)
      restrictions
        .withFilter({ case Array(_, _) => true; case _ => false })
        .foreach({ case Array(c, d) => if (root(t, c) == root(t, d)) return (false, arr) })
      (true, t)
    }

    requests.map({ case Array(a, b) =>
      val (r, n) = procReq(a, b)
      arr = n
      r
    })
  }
}
