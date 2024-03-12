package leetCode._1300

import scala.collection.mutable

object Solution_1284 {
  def minFlips(mat: Array[Array[Int]]): Int = {
    val m = mat.length
    val n = mat(0).length
    if (m == 1 && n == 1) return if ((mat(0)(0) & 1) == 1) 1 else 0
    var num = 0
    mat.indices.foreach(i => mat(0).indices.withFilter(j => (mat(i)(j) & 1) == 1).foreach(j => num = num | (1 << ((m - i - 1) * n + (n - j - 1)))))
    val Q = mutable.Queue[Int]()
    val S = mutable.Set[Int]()
    var step = 0
    Q.enqueue(num)
    val diff = Array(Array(0, 1), Array(0, -1), Array(1, 0), Array(-1, 0))
    while (Q.nonEmpty) {
      var k = Q.size
      while (k > 0) {
        val curr = Q.dequeue()
        if ((curr | 0) == 0) return step
        if (S.add(curr)) (0 until m * n).foreach(i => {
          val x = m - i / n - 1
          val y = n - (i % n) - 1
          var tmp = if ((curr & (1 << i)) > 0) curr & ~(1 << i) else curr | (1 << i)
          diff.foreach(d => {
            val p = x + d(0)
            val q = y + d(1)
            if (p >= 0 && q >= 0 && p < m && q < n)
              tmp = if ((tmp & (1 << ((m - p - 1) * n + (n - q - 1)))) > 0)
                tmp & ~(1 << ((m - p - 1) * n + (n - q - 1)))
              else tmp | (1 << ((m - p - 1) * n + (n - q - 1)))
          })
          if (!S.contains(tmp)) Q.enqueue(tmp)
        })
        k -= 1
      }
      step += 1
    }
    -1
  }
}
