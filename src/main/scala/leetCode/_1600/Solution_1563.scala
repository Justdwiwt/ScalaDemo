package leetCode._1600

object Solution_1563 {
  def stoneGameV(stoneValue: Array[Int]): Int = {
    val n = stoneValue.length
    val sub = stoneValue.scanLeft(0)(_ + _)
    val arr = Array.ofDim[Int](n, n)

    (2 to n).foreach(len =>
      (0 until (n - len + 1)).foreach(i => {
        val j = i + len - 1
        arr(i)(j) = (i until j).map(k => {
          val left = sub(k + 1) - sub(i)
          val right = sub(j + 1) - sub(k + 1)
          if (left > right) right + arr(k + 1)(j)
          else if (left < right) left + arr(i)(k)
          else (left + arr(i)(k)).max(right + arr(k + 1)(j))
        }).max
      })
    )
    arr.head(n - 1)
  }
}
