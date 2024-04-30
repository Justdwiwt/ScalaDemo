package leetCode._1300

object Solution_1246 {
  def minimumMoves(arr: Array[Int]): Int = {
    val n = arr.length
    val dp = Array.ofDim[Int](n, n)

    (0 until n).foreach(i => dp(i)(i) = 1)

    (0 until n - 1).foreach(i => {
      if (arr(i) == arr(i + 1)) dp(i)(i + 1) = 1
      else dp(i)(i + 1) = 2
    })

    arr.indices.drop(2).foreach(len => {
      (0 until n - len).foreach(i => {
        dp(i)(i + len) = len + 1
        (0 until len).foreach(k => {
          val sum = dp(i)(i + k) + dp(i + k + 1)(i + len)
          if (dp(i)(i + len) > sum) dp(i)(i + len) = sum
        })
        if (arr(i) == arr(i + len) && dp(i)(i + len) > dp(i + 1)(i + len - 1))
          dp(i)(i + len) = dp(i + 1)(i + len - 1)
      })
    })

    dp.head.last
  }
}
