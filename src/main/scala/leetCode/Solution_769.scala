package leetCode

object Solution_769 {
  def maxChunksToSorted(arr: Array[Int]): Int = {
    val s = arr.scanLeft(0)((a, b) => a + (1 << b))
    val p = arr.indices.scanLeft(0)((a, b) => a + (1 << b))
    s.zip(p).map(a => a._1 == a._2).count(_ == true) - 1
  }
}
