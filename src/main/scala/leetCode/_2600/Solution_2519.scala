package leetCode._2600

object Solution_2519 {
  private var treeLeft: Array[Int] = _
  private var treeRight: Array[Int] = _
  private var n: Int = _

  def kBigIndices(nums: Array[Int], k: Int): Int = {
    this.n = nums.length
    this.treeLeft = Array.fill(n + 1)(0)
    this.treeRight = Array.fill(n + 1)(0)
    nums.foreach(i => update(treeRight, i + 1, 1))
    var res = 0
    nums.foreach(i => {
      update(treeRight, i + 1, -1)
      if (query(treeRight, i) >= k && query(treeLeft, i) >= k) res += 1
      update(treeLeft, i + 1, 1)
    })
    res
  }

  private def lowBit(x: Int): Int =
    x & -x

  private def update(tree: Array[Int], x: Int, dt: Int): Unit = {
    var newX = x
    while (newX <= n) {
      tree(newX) += dt
      newX += lowBit(newX)
    }
  }

  private def query(tree: Array[Int], x: Int): Int = {
    var res = 0
    var newX = x
    while (newX > 0) {
      res += tree(newX)
      newX -= lowBit(newX)
    }
    res
  }
}
