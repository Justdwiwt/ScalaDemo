package leetCode._3200

object Solution_3178 {
  def numberOfChild(n: Int, k: Int): Int = {
    val t = k % (n - 1)
    if ((k / (n - 1)) % 2 > 0) n - t - 1 else t
  }
}
