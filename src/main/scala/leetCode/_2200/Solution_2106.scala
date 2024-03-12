package leetCode._2200

object Solution_2106 {
  def maxTotalFruits(fruits: Array[Array[Int]], startPos: Int, k: Int): Int = {
    val arr = Array.fill(fruits.iterator.map(_.head).max + 1)(0L)
    fruits.foreach(f => arr(f.head) = f(1))
    arr.indices.drop(1).foreach(i => arr(i) += arr(i - 1))

    def get(i: Int): Long =
      if (i < 0) 0
      else if (i >= arr.length) arr.last
      else arr(i)

    var res = get(startPos) - get(startPos - 1)
    (startPos - k to startPos + k)
      .withFilter(pos => pos != startPos && pos >= 0 && pos < arr.length)
      .foreach(pos => if (pos < startPos) {
        val reach = startPos.max(startPos + k - 2 * (startPos - pos))
        res = res.max(get(reach) - get(pos - 1))
      } else {
        val reach = startPos.min(startPos - (k - 2 * (pos - startPos)))
        res = res.max(get(pos) - get(reach - 1))
      })
    res.toInt
  }
}
