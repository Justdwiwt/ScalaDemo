package leetCode._3000

object Solution_2976 {
  def minimumCost(source: String, target: String, original: Array[Char], changed: Array[Char], cost: Array[Int]): Long = {
    val arr = Array.fill(26, 26)(Int.MaxValue)
    original.indices.foreach(i => {
      val o = original(i) - 'a'
      val c = changed(i) - 'a'
      arr(o)(c) = arr(o)(c).min(cost(i))
    })

    (0 until 26).foreach(k => (0 until 26).foreach(i => (0 until 26).foreach(j =>
      if (arr(i)(k) < Int.MaxValue && arr(k)(j) < Int.MaxValue) {
        arr(i)(j) = arr(i)(j).min(arr(i)(k) + arr(k)(j))
      })))

    var totalCost = 0L
    source.indices.foreach(i => {
      val s = source(i) - 'a'
      val t = target(i) - 'a'
      if (s != t) {
        if (arr(s)(t) == Int.MaxValue) return -1
        totalCost += arr(s)(t)
      }
    })
    totalCost
  }
}
