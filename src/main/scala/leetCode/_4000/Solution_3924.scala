package leetCode._4000

object Solution_3924 {
  def minimumThreshold(n: Int, edges: Array[Array[Int]], source: Int, target: Int, k: Int): Int = {
    val g = Array.fill(n)(List.empty[(Int, Int)])

    val maxWt = edges.foldLeft(0) { case (mx, Array(x, y, w)) =>
      g(x) = (y, w) :: g(x)
      g(y) = (x, w) :: g(y)
      mx.max(w)
    }

    def check(threshold: Int): Boolean = {
      val dis = Array.fill(n)(Int.MaxValue)

      val pq = collection.mutable.PriorityQueue[(Int, Int)]()(Ordering.by[(Int, Int), Int](-_._2))

      dis(source) = 0
      pq.enqueue((source, 0))

      while (pq.nonEmpty) {
        val (x, d) = pq.dequeue()

        if (x == target) return true

        if (d == dis(x)) {
          g(x).foreach {
            case (y, w) =>
              val nd = d + (if (w > threshold) 1 else 0)

              if (nd < dis(y) && nd <= k) {
                dis(y) = nd
                pq.enqueue((y, nd))
              }
          }
        }
      }

      false
    }

    @scala.annotation.tailrec
    def binarySearch(l: Int, r: Int, ans: Int = -1): Int =
      if (l > r) ans
      else {
        val m = l + (r - l) / 2
        if (check(m)) binarySearch(l, m - 1, m)
        else binarySearch(m + 1, r, ans)
      }

    binarySearch(0, maxWt)
  }
}
