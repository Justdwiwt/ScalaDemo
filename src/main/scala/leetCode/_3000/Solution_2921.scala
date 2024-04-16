package leetCode._3000

object Solution_2921 {
  private class BIT(n: Int) {
    private val tree = Array.fill(n + 1)(0)

    private def lowBit(index: Int): Int =
      index & -index

    def update(index: Int, v: Int): Unit = {
      var i = index
      while (i <= n && v > tree(i)) {
        tree(i) = v
        i += lowBit(i)
      }
    }

    def query(index: Int): Int = {
      var res = 0
      var i = index
      while (i > 0) {
        res = res.max(tree(i))
        i -= lowBit(i)
      }
      res
    }
  }

  def maxProfit(prices: Array[Int], profits: Array[Int]): Int = {
    val n = prices.length
    val mx = prices.max

    val bit1 = new BIT(mx + 1)
    val left = Array.ofDim[Int](n)
    prices.indices.dropRight(1).foreach(i => {
      val idx = prices(i)
      left(i) = bit1.query(idx - 1)
      bit1.update(idx, profits(i))
    })

    val bit2 = new BIT(mx + 1)
    val right = Array.ofDim[Int](n)
    prices.indices.drop(1).reverse.foreach(i => {
      var idx = prices(i)
      idx = mx - idx + 1
      right(i) = bit2.query(idx - 1)
      bit2.update(idx, profits(i))
    })

    prices
      .indices
      .drop(1)
      .dropRight(1)
      .filter(i => left(i) != 0 && right(i) != 0)
      .map(i => left(i) + profits(i) + right(i))
      .foldLeft(-1)(_.max(_))
  }
}
