package leetCode._1900

object Solution_1824 {
  def minSideJumps(obstacles: Array[Int]): Int = {
    val len = obstacles.length - 1

    @scala.annotation.tailrec
    def f(i: Int, pa: Array[Int]): Int =
      if (i == len) pa.min
      else {
        val arr = Array.fill(3)(Int.MaxValue)
        (1 to 3)
          .withFilter(a => a != obstacles(i))
          .withFilter(a => pa(a - 1) != Int.MaxValue)
          .foreach(a => {
            arr(a - 1) = arr(a - 1).min(pa(a - 1))
            (1 to 3)
              .withFilter(o => o != obstacles(i) && a != o)
              .foreach(o => arr(o - 1) = arr(o - 1).min(arr(a - 1) + 1))
          })
        f(i + 1, arr)
      }

    f(1, Array(1, 0, 1))
  }
}
