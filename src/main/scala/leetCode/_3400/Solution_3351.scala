package leetCode._3400

object Solution_3351 {
  def sumOfGoodSubsequences(nums: Array[Int]): Int = {
    val M = 1000000007
    val mx = nums.max

    val (f, _) = nums.foldLeft((Map.empty[Int, Long], Map.empty[Int, Long])) {
      case ((fMap, gMap), x) =>
        val updatedF = fMap.updated(x, (fMap.getOrElse(x, 0L) + x) % M)
        val updatedG = gMap.updated(x, (gMap.getOrElse(x, 0L) + 1) % M)

        val f1 = if (x > 0) (updatedF.getOrElse(x, 0L) + fMap.getOrElse(x - 1, 0L) + gMap.getOrElse(x - 1, 0L) * x) % M else updatedF(x)
        val g1 = if (x > 0) (updatedG.getOrElse(x, 0L) + gMap.getOrElse(x - 1, 0L)) % M else updatedG(x)

        val f2 = if (x < mx) (f1 + fMap.getOrElse(x + 1, 0L) + gMap.getOrElse(x + 1, 0L) * x) % M else f1
        val g2 = if (x < mx) (g1 + gMap.getOrElse(x + 1, 0L)) % M else g1

        (updatedF.updated(x, f2), updatedG.updated(x, g2))
    }

    f.values.foldLeft(0L)((acc, v) => (acc + v) % M).toInt
  }
}
