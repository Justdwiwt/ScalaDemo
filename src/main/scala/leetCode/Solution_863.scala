package leetCode

object Solution_863 {
  private var res = List.empty[Int]

  def distanceK(root: TreeNode, target: TreeNode, K: Int): List[Int] = K match {
    case 0 => List(target.value)
    case _ =>
      func(root, target, K, 0)
      res
  }

  def func(node: TreeNode, target: TreeNode, K: Int, dist: Int): Int = {
    if (node == null) return 0
    if (dist == K) {
      res :+= node.value
      return 0
    }
    var left = 0
    var right = 0
    if (node.value == target.value || dist > 0) {
      left = func(node.left, target, K, dist + 1)
      right = func(node.right, target, K, dist + 1)
    } else {
      left = func(node.left, target, K, dist)
      right = func(node.right, target, K, dist)
    }
    if (left == K || right == K) {
      res :+= node.value
      return 0
    }
    if (node.value == target.value) return 1
    if (left > 0) func(node.right, target, K, left + 1)
    if (right > 0) func(node.left, target, K, right + 1)
    if (left > 0 || right > 0) if (left > 0) return left + 1 else return right + 1
    0
  }
}
