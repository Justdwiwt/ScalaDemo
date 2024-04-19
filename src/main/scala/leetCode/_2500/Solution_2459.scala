package leetCode._2500

object Solution_2459 {
  // fixme: case 63/87 time limit exceeded
  def sortArray(nums: Array[Int]): Int = {
    val n = nums.length

    def f(nums: List[Int], z: Int): Int = {
      val vis = Array.fill(n)(false)
      val cir = nums.indices.foldLeft(0)((acc, i) => {
        if (i == nums(i) || vis(i)) acc
        else {
          var count = 1
          var j = nums(i)
          while (j != i && !vis(j)) {
            vis(j) = true
            count += 1
            j = nums(j)
          }
          acc + count
        }
      })

      cir - 2 * (if (nums(z) != z) 1 else 0)
    }

    f(nums.toList, 0) min f(nums.toList.map(x => (x - 1 + n) % n), n - 1)
  }
}
