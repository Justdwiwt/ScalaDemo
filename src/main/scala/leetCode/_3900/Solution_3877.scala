package leetCode._3900

object Solution_3877 {
  def minRemovals(nums: Array[Int], target: Int): Int = {
    val MAX_XOR = 16384

    val init = Array.fill(MAX_XOR)(-1)
    init(0) = 0

    val dp = nums.foldLeft(init) { (f, num) =>
      val nf = f.clone()

      f.indices.foreach(x => if (f(x) >= 0) nf(x ^ num) = nf(x ^ num).max(f(x) + 1))

      nf
    }

    if (dp(target) < 0) -1
    else nums.length - dp(target)
  }
}
