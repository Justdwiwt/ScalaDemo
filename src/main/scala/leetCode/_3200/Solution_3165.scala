package leetCode._3200

object Solution_3165 {
  def maximumSumSubsequence(nums: Array[Int], queries: Array[Array[Int]]): Int = {
    val n = nums.length
    val node = new Node()
    nums.indices.foreach(i => update(node, 0, n - 1, i, nums(i)))
    val M = (1e9 + 7).toLong
    var res = 0L
    queries.foreach(q => {
      update(node, 0, n - 1, q.head, q(1))
      res = (res + node.value(1)(1)) % M
    })
    res.toInt
  }

  class Node {
    var left: Node = _
    var right: Node = _
    var value: Array[Array[Long]] = Array.ofDim[Long](2, 2)
    value = Array.ofDim[Long](2, 2)
  }

  private def pushDown(node: Node): Unit = {
    if (node.left == null) node.left = new Node()
    if (node.right == null) node.right = new Node()
  }

  private def pushUp(node: Node): Unit = {
    val left = node.left.value
    val right = node.right.value
    node.value(0)(0) = math.max(left(0)(0) + right(1)(0), left(0)(1) + right(0)(0))
    node.value(0)(1) = math.max(left(0)(1) + right(0)(1), left(0)(0) + right(1)(1))
    node.value(1)(0) = math.max(left(1)(0) + right(1)(0), left(1)(1) + right(0)(0))
    node.value(1)(1) = math.max(left(1)(0) + right(1)(1), left(1)(1) + right(0)(1))
  }

  def update(node: Node, sl: Int, sr: Int, idx: Int, value: Int): Unit = {
    if (idx < sl || idx > sr) return
    if (sl == sr) {
      node.value(1)(1) = math.max(value, 0)
      return
    }
    val mid = (sl + sr) >> 1
    pushDown(node)
    if (mid >= idx) update(node.left, sl, mid, idx, value)
    if (idx >= mid + 1) update(node.right, mid + 1, sr, idx, value)
    pushUp(node)
  }

  def query(node: Node, sl: Int, sr: Int, l: Int, r: Int): Array[Array[Long]] = {
    if (sl > sr || sl > r || sr < l) return Array.ofDim[Long](2, 2)
    if (sl >= l && sr <= r) return node.value
    val mid = (sl + sr) >> 1
    pushDown(node)
    val left = query(node.left, sl, mid, l, r)
    val right = query(node.right, mid + 1, sr, l, r)
    val ret = Array.ofDim[Long](2, 2)
    ret(0)(0) = math.max(left(0)(0) + right(1)(0), left(0)(1) + right(0)(0))
    ret(0)(1) = math.max(left(0)(1) + right(0)(1), left(0)(0) + right(1)(1))
    ret(1)(0) = math.max(left(1)(0) + right(1)(0), left(1)(1) + right(0)(0))
    ret(1)(1) = math.max(left(1)(0) + right(1)(1), left(1)(1) + right(0)(1))
    ret
  }
}
