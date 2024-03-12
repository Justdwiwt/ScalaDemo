package leetCode.crackingCodeInterview

object Code_17_08 {
  def bestSeqAtIndex(height: Array[Int], weight: Array[Int]): Int = {
    val zips = height
      .zip(weight)
      .sorted(Ordering.comparatorToOrdering(Ordering.by[(Int, Int), Int](t => t._1).thenComparing(Ordering.by[(Int, Int), Int](t => t._2).reverse)))

    f(zips.map(_._2))
  }

  private def f(nums: Array[Int]): Int = {
    val arr = Array.fill(nums.length)(0)
    var res = 0
    nums.foreach(num => {
      var i = 0
      var j = res
      while (i < j) {
        val m = (i + j) >>> 1
        if (arr(m) < num) i = m + 1
        else j = m
      }
      arr(i) = num
      if (res == j) res += 1
    })
    res
  }
}
