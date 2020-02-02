package leetCode

object Solution_769 {
  def maxChunksToSorted(arr: Array[Int]): Int = {
    var res = 0
    var mx = 0
    arr.indices.foreach(i => {
      mx = mx.max(arr(i))
      if (mx == i) res += 1
    })
    res
  }
}
