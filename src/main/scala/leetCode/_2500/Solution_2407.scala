package leetCode._2500

object Solution_2407 {
  class SegmentTree(n: Int) {
    private val tree = Array.fill(n * 2)(0)

    def query(l: Int, r: Int): Int = Iterator
      .iterate((l + n, r + n, 0)) { case (l, r, res) =>
        val (nl, lRes) = if ((l & 1) > 0) (l + 1, tree(l)) else (l, 0)
        val (nr, rRes) = if ((r & 1) > 0) (r - 1, tree(r - 1)) else (r, 0)
        (nl >> 1, nr >> 1, res.max(lRes).max(rRes))
      }
      .dropWhile { case (l, r, _) => l < r }
      .next()
      ._3

    def update(i: Int, value: Int): Unit = Iterator
      .iterate({
        tree(i + n) = value
        i + n
      })(i => {
        tree(i >> 1) = tree(i).max(tree(i ^ 1))
        i >> 1
      })
      .dropWhile(_ > 1)
      .next()
  }

  def lengthOfLIS(nums: Array[Int], k: Int): Int = {
    val tree = new SegmentTree(nums.max)
    nums./:(1)((res, n) => {
      val preMX = tree.query((n - 1 - k).max(0), n - 1)
      tree.update(n - 1, preMX + 1)
      res.max(preMX + 1)
    })
  }
}
