package leetCode.crackingCodeInterview

object Code_08_13 {
  def pileBox(_box: Array[Array[Int]]): Int = {
    val sorted = _box.sortBy(_.head)

    val dp = sorted.indices.foldLeft(Array.fill(sorted.length)(0))((dp, i) => {
      val maxDp = (0 until i).foldLeft(0)((max, j) => {
        if (sorted(i)(0) > sorted(j)(0) && sorted(i)(1) > sorted(j)(1) && sorted(i)(2) > sorted(j)(2))
          max.max(dp(j))
        else max
      })
      dp.updated(i, maxDp + sorted(i)(2))
    })

    dp.max
  }
}
