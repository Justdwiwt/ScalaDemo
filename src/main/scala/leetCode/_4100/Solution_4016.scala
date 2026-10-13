package leetCode._4100

object Solution_4016 {
  def maxArea(mat: Array[Array[Int]]): Int = {
    def calc(a: Array[Array[Int]]): Int = {
      val m = a.length
      val n = a.head.length
      val sufMax = Array.fill(m + 1)(0)

      def update(row: Array[Int], f: Array[Int]): Int = row
        .indices
        .foldLeft(0)((last, j) => {
          val tmp = f(j + 1)
          f(j + 1) = if (row(j) == 0) 0 else 1 + last.min(f(j + 1)).min(f(j))
          if (row(j) == 0) 0 else tmp
        })

      val f1 = Array.fill(n + 1)(0)
      (m - 1 to 1 by -1).foreach(i => {
        update(a(i), f1)
        sufMax(i) = sufMax(i + 1).max(f1.max)
      })

      val (_, ans) = a.indices.foldLeft((0, 0)) {
        case ((_, ans), i) if sufMax(i + 1) > ans =>
          val f = Array.fill(n + 1)(0)
          val p = (0 to i).foldLeft(0)((mx, k) => {
            update(a(k), f)
            mx.max(f.max)
          })
          (p, ans.max(p.min(sufMax(i + 1))))
        case (state, _) => state
      }

      ans * ans
    }

    calc(mat).max(calc(mat.transpose.map(_.toArray)))
  }
}
