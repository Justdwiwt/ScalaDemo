package leetCode._3700

object Solution_3624 {
  private class FenwickTree(n: Int) {
    private val tree = Array.fill(n + 2)(0)

    def update(i0: Int, delta: Int): Unit = {
      var i = i0
      while (i < tree.length) {
        tree(i) += delta
        i += i & -i
      }
    }

    private def pre(i0: Int): Int = {
      var i = i0
      var sum = 0
      while (i > 0) {
        sum += tree(i)
        i &= i - 1
      }
      sum
    }

    def query(l: Int, r: Int): Int = pre(r) - pre(l - 1)
  }

  private val popDepthList: Array[Int] = {
    val arr = Array.fill(65)(0)
    (2 until arr.length).foreach(i => arr(i) = arr(java.lang.Integer.bitCount(i)) + 1)
    arr
  }

  private def popDepth(x: Long): Int =
    if (x == 1) 0
    else popDepthList(java.lang.Long.bitCount(x)) + 1

  def popcountDepth(nums: Array[Long], queries: Array[Array[Long]]): Array[Int] = {
    val n = nums.length
    val trees = Array.fill(6)(new FenwickTree(n + 1))

    def update(i: Int, delta: Int, x: Long): Unit =
      trees(popDepth(x)).update(i + 1, delta)

    nums.indices.foreach(i => update(i, 1, nums(i)))

    val init: (Vector[Int], Vector[Long]) = (Vector.empty[Int], nums.toVector)

    val (res, _) = queries.foldLeft(init) {
      case ((res, arr), Array(1, l, r, d)) =>
        val count = trees(d.toInt).query(l.toInt + 1, r.toInt + 1)
        (res :+ count, arr)

      case ((res, arr), Array(_, i, v)) =>
        val idx = i.toInt
        update(idx, -1, arr(idx))
        update(idx, 1, v)
        (res, arr.updated(idx, v))

      case ((_, _), invalid) =>
        throw new MatchError("Unexpected query format: " + invalid.toList)
    }

    res.toArray
  }
}
