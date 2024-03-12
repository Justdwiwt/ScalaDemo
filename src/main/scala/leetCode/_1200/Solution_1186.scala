package leetCode._1200

object Solution_1186 {
  def maximumSum(arr: Array[Int]): Int = {
    var dp0 = arr(0)
    var dp1 = Int.MinValue
    var mx = dp1.max(dp0)
    (1 until arr.length).foreach(i => {
      dp1 = dp0.max(if (dp1 == Int.MinValue) dp1 else dp1 + arr(i))
      dp0 = (dp0 + arr(i)).max(arr(i))
      mx = mx.max(dp1.max(dp0))
    })
    mx
  }
}
