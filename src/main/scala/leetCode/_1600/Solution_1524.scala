package leetCode._1600

object Solution_1524 {
  def numOfSubarrays(arr: Array[Int]): Int = {
    val M = (1e9 + 7).toLong
    var res = 0L
    var p = 0L
    arr.indices.foreach(i => {
      p = if ((arr(i) & 1) > 0) i + 1 - p else p
      res += p
    })
    (res % M).toInt
  }
}
