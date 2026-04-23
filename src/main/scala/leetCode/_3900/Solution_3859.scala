package leetCode._3900

object Solution_3859 {
  def countSubarrays(nums: Array[Int], k: Int, m: Int): Long = {

    def calc(limit: Int): Long = {
      val cnt = collection.mutable.HashMap[Int, Int]()
      var geM = 0
      var left = 0
      var ans = 0L

      nums.zipWithIndex.foreach { case (x, right) =>
        val nx = cnt.getOrElse(x, 0) + 1
        cnt(x) = nx
        if (nx == m) geM += 1

        def shrink(): Unit = {
          val out = nums(left)
          val c = cnt(out)

          if (c == m) geM -= 1

          if (c == 1) cnt -= out
          else cnt(out) = c - 1

          left += 1
        }

        while (cnt.size >= limit && geM >= k) shrink()

        ans += left
      }

      ans
    }

    calc(k) - calc(k + 1)
  }
}
