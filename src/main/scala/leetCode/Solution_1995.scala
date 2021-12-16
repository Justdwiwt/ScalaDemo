package leetCode

object Solution_1995 {
  def countQuadruplets(nums: Array[Int]): Int = {
    var cnt = 0
    nums.indices.foreach(i =>
      (i + 1 until nums.length).foreach(j =>
        (j + 1 until nums.length).foreach(k =>
          (k + 1 until nums.length).foreach(m =>
            if (nums(i) + nums(j) + nums(k) == nums(m))
              cnt += 1
          )
        )
      )
    )
    cnt
  }
}
