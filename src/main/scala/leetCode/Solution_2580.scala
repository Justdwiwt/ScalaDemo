package leetCode

object Solution_2580 {
  final val M = 1000000007

  def countWays(ranges: Array[Array[Int]]): Int = {
    val sorted = ranges.sorted((a: Array[Int], b: Array[Int]) => a.head - b.head)

    var mx = sorted.head(1)
    var res = 2
    sorted.indices.drop(1).foreach(i => {
      val l = sorted(i).head
      val r = sorted(i)(1)
      if (l > mx) res = (res * 2) % M
      mx = mx.max(r)
    })
    res
  }
}
