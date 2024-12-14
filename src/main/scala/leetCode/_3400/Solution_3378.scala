package leetCode._3400

object Solution_3378 {
  def countComponents(nums: Array[Int], threshold: Int): Int = {
    val n = nums.length
    val fa = Array.tabulate(n)(identity)
    val idx = Array.fill(threshold + 1)(-1)

    nums.zipWithIndex.foreach { case (num, i) => if (num <= threshold) idx(num) = i }

    def find(x: Int): Int = {
      if (fa(x) != x) fa(x) = find(fa(x))
      fa(x)
    }

    (1 to threshold).foldLeft(n)((count, g) => {
      val minX = (g to threshold by g).find(idx(_) >= 0).getOrElse(-1)
      if (minX < 0) count
      else {
        val fi = find(idx(minX))
        val upper = (g.toLong * threshold / minX).toInt
        (minX + g to upper by g).foldLeft(count)((c, y) => {
          if (idx(y) >= 0) {
            val fj = find(idx(y))
            if (fi != fj) {
              fa(fj) = fi
              c - 1
            } else c
          } else c
        })
      }
    })
  }
}
