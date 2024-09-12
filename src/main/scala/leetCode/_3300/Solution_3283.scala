package leetCode._3300

import scala.collection.mutable

object Solution_3283 {
  private val DIRS = Array(Array(2, 1), Array(1, 2), Array(-1, 2), Array(-2, 1), Array(-2, -1), Array(-1, -2), Array(1, -2), Array(2, -1))

  def maxMoves(kx: Int, ky: Int, positions: Array[Array[Int]]): Int = {
    val n = positions.length
    val dis = Array.ofDim[Int](n, 50, 50)

    positions.indices.foreach(i => {
      val d = dis(i)
      (0 until 50).foreach(j => java.util.Arrays.fill(d(j), -1))

      val px = positions(i).head
      val py = positions(i)(1)
      d(px)(py) = 0

      val q = mutable.Queue(Array(px, py))

      var step = 1
      while (q.nonEmpty) {
        val tmp = q.dequeueAll(_ => true)
        tmp.foreach(p => DIRS.foreach(dir => {
          val x = p.head + dir.head
          val y = p(1) + dir(1)
          if (x >= 0 && x < 50 && y >= 0 && y < 50 && d(x)(y) < 0) {
            d(x)(y) = step
            q += Array(x, y)
          }
        }))
        step += 1
      }
    })

    val u = (1 << n) - 1
    val f = Array.ofDim[Int](1 << n, n + 1)

    (1 until (1 << n)).foreach(mask => (0 to n).foreach(i => {
      val (x, y) = if (i < n) (positions(i).head, positions(i)(1)) else (kx, ky)

      if (Integer.bitCount(u ^ mask) % 2 == 0)
        positions.indices.foreach(j => if ((mask >> j & 1) > 0) f(mask)(i) = f(mask)(i).max(f(mask ^ (1 << j))(j) + dis(j)(x)(y)))
      else {
        f(mask)(i) = Int.MaxValue
        positions.indices.foreach(j => if ((mask >> j & 1) > 0) f(mask)(i) = f(mask)(i).min(f(mask ^ (1 << j))(j) + dis(j)(x)(y)))
      }
    }))

    f(u)(n)
  }
}
