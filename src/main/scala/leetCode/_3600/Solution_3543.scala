package leetCode._3600

object Solution_3543 {
  def maxWeight(n: Int, edges: Array[Array[Int]], k: Int, t: Int): Int = {
    if (n <= k) return -1

    val g = Array.fill(n)(List.empty[(Int, Int)])
    edges
      .withFilter { case Array(_, _, _) => true; case _ => false }
      .foreach { case Array(x, y, wt) => g(x) = (y, wt) :: g(x) }

    var prev = Array.fill(n, t)(false)
    (0 until n).foreach(prev(_)(0) = true)

    (1 to k).foreach(_ => {
      val curr = Array.fill(n, t)(false)
      (0 until n).foreach(v => (0 until t)
        .withFilter(prev(v)(_))
        .foreach(w => g(v)
          .map { case (nx, wt) => val nw = w + wt; ((nx, wt), nw) }
          .withFilter { case ((_, _), nw) => nw < t }
          .foreach { case ((nx, _), nw) => curr(nx)(nw) = true }
        )
      )
      prev = curr
    })

    (0 until t).reverse.find(w => prev.exists(_(w))).getOrElse(-1)
  }
}
