package leetCode

object Solution_648 {
  def findLongestChain(pairs: Array[Array[Int]]): Int = {
    val arr = pairs.sortWith(_ (1) < _ (1))
    var res = 1
    var t = arr(0)(1)
    (1 until arr.length).foreach(i => {
      if (arr(i)(0) > t) {
        res += 1
        t = arr(i)(1)
      }
    })
    res
  }
}
