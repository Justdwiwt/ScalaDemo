package leetCode._800

object Solution_768 {
  def maxChunksToSorted(a: Array[Int]): Int = {
    var p = 0
    val sorted = a.sorted
    var cnt = 0
    a.indices.foreach(i => {
      val f = sorted.indexOf(a(i))
      sorted(f) = Int.MinValue
      if (f > p) p = f
      if (i == p) cnt += 1
    })
    cnt
  }
}
