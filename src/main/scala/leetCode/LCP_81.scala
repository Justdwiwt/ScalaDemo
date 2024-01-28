package leetCode

object LCP_81 {
  private var tree = Array.empty[Array[Int]]
  private var k = 0

  private def merge(pos: Int): Unit = {
    val t = Array.fill(2)(0)
    (0 until k).foreach(i => {
      t(0) |= tree(pos * 2 + 2)(tree(pos * 2 + 1).head >> i & 1) & (1 << i)
      t(1) |= tree(pos * 2 + 2)(tree(pos * 2 + 1)(1) >> i & 1) & (1 << i)
    })
    tree(pos)(0) = t.head
    tree(pos)(1) = t(1)
  }

  private def build(pos: Int, left: Int, right: Int, arr: Array[Int]): Unit = {
    if (left == right) {
      tree(pos)(0) = (1 << k) - 1
      tree(pos)(1) = arr(left) ^ tree(pos).head
      return
    }
    val mid = (left + right) >>> 1
    build(pos * 2 + 1, left, mid, arr)
    build(pos * 2 + 2, mid + 1, right, arr)
    merge(pos)
  }

  private def update(x: Int, y: Int, pos: Int, left: Int, right: Int): Unit = {
    if (left == right) {
      tree(pos)(0) = (1 << k) - 1
      tree(pos)(1) = y ^ tree(pos).head
      return
    }
    val mid = (right + left) >>> 1
    if (x <= mid) update(x, y, pos * 2 + 1, left, mid)
    if (x > mid) update(x, y, pos * 2 + 2, mid + 1, right)
    merge(pos)
  }

  def getNandResult(k: Int, arr: Array[Int], operations: Array[Array[Int]]): Int = {
    this.k = k
    val n = arr.length
    tree = Array.fill(4 * n, 2)(0)
    build(0, 0, n - 1, arr)
    var ans = 0
    operations.indices.foreach(i => {
      val t = operations(i).head
      val x = operations(i)(1)
      val y = operations(i)(2)
      if (t == 0) update(x, y, 0, 0, n - 1)
      else {
        var res = 0
        (0 until k).foreach(j => {
          val a = y >> j & 1
          val b = tree.head(a) >> j & 1
          if (a == b) res |= b << j
          else {
            if (b == (tree.head(b) >> j & 1)) res |= b << j
            else {
              if (x % 2 == 1) res |= b << j
              if (x % 2 == 0) res |= (b ^ 1) << j
            }
          }
        })
        ans ^= res
      }
    })
    ans = ans & ((1 << k) - 1)
    ans
  }
}
