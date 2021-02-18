package leetCode

object Solution_539 {
  def findMinDifference(timePoints: List[String]): Int = {
    var res = Int.MaxValue
    var nums = Array.emptyIntArray
    timePoints.foreach(i => {
      val h = i.substring(0, 2).toInt
      val m = i.substring(3).toInt
      nums :+= h * 60 + m
    })
    val t = nums.sorted
    timePoints.indices.drop(1).foreach(i => res = res.min(t(i) - t(i - 1)))
    res.min(1440 + t.head - t.last)
    res.min(1440 + t.head - t.last)
  }
}
