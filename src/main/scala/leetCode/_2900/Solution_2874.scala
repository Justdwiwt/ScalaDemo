package leetCode._2900

object Solution_2874 {
  def maximumTripletValue(nums: Array[Int]): Long = {
    var res = 0L
    var maxDiff = 0
    var preMax = 0
    nums.foreach(x => {
      res = res.max(maxDiff.toLong * x)
      maxDiff = maxDiff.max(preMax - x)
      preMax = preMax.max(x)
    })
    res
  }
}
