package leetCode._3500

object Solution_3404 {
  def numberOfSubsequences(nums: Array[Int]): Long = {
    val counts = collection.mutable.Map.empty[Double, Int].withDefaultValue(0)
    val n = nums.length
    var res = 0L
    (4 until n - 2).foreach(r => {
      val q = r - 2
      (0 until q - 1).foreach(p => {
        val left = nums(p).toDouble / nums(q).toDouble
        counts(left) += 1
      })
      (r + 2 until n).foreach(s => {
        val right = nums(s).toDouble / nums(r).toDouble
        res += counts(right)
      })
    })
    res
  }
}
