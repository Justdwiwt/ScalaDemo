package leetCode._3900

object Solution_3830 {
  def longestAlternating(nums: Array[Int]): Int = {
    val n = nums.length
    if (n == 0) return 0

    val f = Array.fill(n, 2, 2)(1)

    nums.indices.drop(1).foreach(i => {

      if (nums(i - 1) != nums(i)) {
        val inc = if (nums(i - 1) < nums(i)) 1 else 0
        f(i)(0)(inc) = f(i - 1)(0)(inc ^ 1) + 1
        f(i)(1)(inc) = f(i - 1)(1)(inc ^ 1) + 1
      }

      if (i > 1 && nums(i - 2) != nums(i)) {
        val inc = if (nums(i - 2) < nums(i)) 1 else 0
        f(i)(1)(inc) = math.max(f(i)(1)(inc), f(i - 2)(0)(inc ^ 1) + 1)
      }
    })

    f.map(v => v(1).max).max
  }
}
