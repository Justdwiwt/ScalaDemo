package leetCode._1500

object Solution_1483 {

  class TreeAncestor(_n: Int, _parent: Array[Int]) {

    private val dp = Array.ofDim[Int](_n, (math.log(_n) / math.log(2)).toInt + 1)
    (0 until _n).foreach(i => dp(i)(0) = _parent(i))
    var j = 1
    while ((1 << j) < _n) {
      (0 until _n).foreach(i => {
        if (dp(i)(j - 1) != -1) dp(i)(j) = dp(dp(i)(j - 1))(j - 1)
        else dp(i)(j) = -1
      })
      j += 1
    }

    def getKthAncestor(node: Int, k: Int): Int = {
      if (k == 0 || node == -1) return node
      val p = (math.log(k) / math.log(2)).toInt
      getKthAncestor(dp(node)(p), k - (1 << p))
    }

  }

}
