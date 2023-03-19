package leetCode

object Solution_2585 {
  def waysToReachTarget(target: Int, types: Array[Array[Int]]): Int = {
    val dp = Array.fill(types.length + 1)(new Array[Long](target + 1))
    dp(0)(target) = 1
    types.indices.foreach(i => {
      val Array(cnt, mark) = types(i)
      (0 to target).foreach(j => {
        val idx = (0 to cnt).map(c => j + c * mark).takeWhile(_ <= target).map(dp(i)(_))
        dp(i + 1)(j) = idx./:(0L)((acc, x) => (acc + x) % 1000000007)
      })
    })
    dp.last.head.toInt
  }
}
