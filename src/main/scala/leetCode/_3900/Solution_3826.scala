package leetCode._3900

object Solution_3826 {
  def minPartitionScore(nums: Array[Int], k: Int): Long = {
    val n = nums.length

    val pre = nums.foldLeft(Vector(0L))((acc, x) => acc :+ (acc.last + x)).toArray

    val INF = Long.MaxValue / 4

    val init = Array.fill[Long](n + 1)(INF)
    init(0) = 0L

    (1 to k).foldLeft(init)((prev, K) => {
      val cur = Array.fill[Long](n + 1)(INF)

      val qx = new Array[Long](n + 1)
      val qy = new Array[Long](n + 1)
      var head = 0
      var tail = 0

      def add(x: Long, y: Long): Unit = {
        while (
          tail - head > 1 &&
            cross(
              qx(tail - 2), qy(tail - 2),
              qx(tail - 1), qy(tail - 1),
              x, y
            ) <= 0
        ) tail -= 1

        qx(tail) = x
        qy(tail) = y
        tail += 1
      }

      def query(s: Long): Long = {
        while (
          tail - head > 1 &&
            (-2 * s) * qx(head) + qy(head) >=
              (-2 * s) * qx(head + 1) + qy(head + 1)
        ) head += 1

        (-2 * s) * qx(head) + qy(head)
      }

      val s0 = pre(K - 1)
      add(s0, prev(K - 1) + s0 * s0 - s0)

      val end = n - (k - K)

      (K to end).foreach(i => {
        val s = pre(i)

        cur(i) = query(s) + s * s + s

        add(s, prev(i) + s * s - s)
      })

      cur
    })(n) / 2
  }

  private def cross(
                     x1: Long, y1: Long,
                     x2: Long, y2: Long,
                     x3: Long, y3: Long
                   ): Long =
    (x2 - x1) * (y3 - y2) - (y2 - y1) * (x3 - x2)
}
