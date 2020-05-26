package leetCode

object Solution_1402 {
  def maxSatisfaction(satisfaction: Array[Int]): Int = {
    val t = satisfaction.sorted
    var res = 0
    var sum = 0
    var all = 0
    (satisfaction.length - 1 to 0 by (-1)).foreach(i => {
      all += sum + t(i)
      res = res.max(all)
      sum += t(i)
    })
    res
  }
}
