package leetCode._3900

object Solution_3872 {
  def longestArithmetic(nums: Array[Int]): Int = {
    val n = nums.length

    val memo = collection.mutable.Map.empty[(Int, Int), Int]

    def dfs(i: Int, left: Int): Int = memo.getOrElseUpdate((i, left), {
      if (i <= 1) i + 1
      else {
        val base =
          if (nums(i - 2) + nums(i) == nums(i - 1) * 2) dfs(i - 1, left) + 1
          else 2

        val withOp =
          if (left == 0) base
          else {
            val res1 = math.max(base, 3)

            val res2 =
              if (i >= 3 &&
                (nums(i - 2) - nums(i - 3)) * 2 == nums(i) - nums(i - 2))
                math.max(res1, dfs(i - 2, 0) + 2)
              else res1

            val d = nums(i) - nums(i - 1)

            val res3 =
              if (i >= 3 && nums(i - 1) - nums(i - 3) == d * 2) {
                val r = math.max(res2, 4)
                if (i >= 4 && nums(i - 3) - nums(i - 4) == d) math.max(r, dfs(i - 3, 0) + 3)
                else r
              } else res2

            res3
          }

        withOp
      }
    })

    val ans1 = (0 until n).map(dfs(_, 1)).max
    val ans2 = (1 until n).map(i => dfs(i - 1, 0)).max + 1

    math.max(ans1, ans2)
  }
}
