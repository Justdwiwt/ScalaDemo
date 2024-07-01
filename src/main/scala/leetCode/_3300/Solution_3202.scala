package leetCode._3300

object Solution_3202 {
  def maximumLength(nums: Array[Int], k: Int): Int = (0 until k).foldLeft(0)((maxAns, m) => {
    val finalF = nums.foldLeft(Array.fill(k)(0))((f, num) => {
      val x = num % k
      val newF = f.updated(x, f((m - x + k) % k) + 1)
      newF
    })
    maxAns.max(finalF.max)
  })
}
