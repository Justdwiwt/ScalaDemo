package leetCode._4000

object Solution_3977 {
  def minTimeMaxPower(n: Int, edges: Array[Array[Int]], power: Int, cost: Array[Int], source: Int, target: Int): Array[Long] = {
    val g = Array.fill(n)(List.empty[(Int, Int)])

    edges.foreach { case Array(x, y, t) => g(x) = (y, t) :: g(x) }

    val inf = Long.MaxValue
    val f = Array.fill(power + 1, n)(inf)
    f(power)(source) = 0L

    var minDis = inf
    var maxRem = -1

    (power to 0 by -1).foreach(rem => {
      if (f(rem)(target) < minDis) {
        minDis = f(rem)(target)
        maxRem = rem
      }

      f(rem).indices.foreach(x => {
        val v = f(rem)(x)

        if (v != inf && rem >= cost(x)) {
          val nextRem = rem - cost(x)

          g(x).foreach { case (y, t) => f(nextRem)(y) = f(nextRem)(y).min(v + t.toLong) }
        }
      })
    })

    if (maxRem < 0) Array(-1L, -1L) else Array(minDis, maxRem.toLong)
  }
}
