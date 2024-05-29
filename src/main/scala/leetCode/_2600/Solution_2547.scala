package leetCode._2600

object Solution_2547 {
  def minCost(nums: Array[Int], k: Int): Int = {
    val n = nums.length
    val arr = Array.fill[Int](n + 1)(0)
    val state = Array.fill[Byte](n)(0)

    nums.indices.foreach(i => {
      state.indices.foreach(state(_) = 0)
      var unique = 0
      var mn = Int.MaxValue

      (i to 0 by -1).foreach(j => {
        val x = nums(j)
        if (state(x) == 0) {
          state(x) = 1
          unique += 1
        } else if (state(x) == 1) {
          state(x) = 2
          unique -= 1
        }
        mn = mn.min(arr(j) - unique)
      })
      arr(i + 1) = k + mn
    })
    arr(n) + n
  }
}
