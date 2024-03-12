package leetCode._2800

object Solution_2735 {
  def minCost(nums: Array[Int], x: Int): Long = {
    val t = Array.fill(nums.length)(Int.MaxValue)
    var res = Long.MaxValue
    nums.indices.foreach(i => {
      var d = 0L
      nums.indices.foreach(j => {
        t(j) = t(j).min(nums((j + i) % nums.length))
        d += t(j)
      })
      res = res.min(d + x.toLong * i)
    })
    res
  }
}
