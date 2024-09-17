package leetCode._3300

object Solution_3287 {
  def maxValue(nums: Array[Int], k: Int): Int = {
    val mx = nums.reduce(_ | _)
    val n = nums.length
    val arr = new Array[Array[Boolean]](n)
    val flag = Array.fill(k + 1, mx + 1)(false)
    flag(0)(0) = true

    (k until n).reverse.foreach(i => {
      val v = nums(i)
      (0 until k).reverse.foreach(j => flag(j).indices.withFilter(flag(j)(_)).foreach(x => flag(j + 1)(x | v) = true))
      arr(i) = flag(k).clone()
    })

    var res = 0
    val pre = Array.fill(k + 1, mx + 1)(false)
    pre(0)(0) = true

    nums.init.zipWithIndex
      .foreach { case (v, i) => (0 until k).reverse.foreach(j => pre(j)
        .indices
        .withFilter(pre(j)(_))
        .foreach(x => pre(j + 1)(x | v) = true))
        if (i >= k - 1) pre(k)
          .indices
          .withFilter(pre(k)(_))
          .foreach(x => arr(i + 1).indices.withFilter(arr(i + 1)(_)).foreach(y => res = res.max(x ^ y)))
      }
    res
  }
}
