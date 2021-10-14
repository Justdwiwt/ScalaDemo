package leetCode

object Offer_049 {
  def sumNumbers(root: TreeNode): Int = f(root, Nil)

  def f(n: TreeNode, xs: List[Int]): Int = n match {
    case null => 0
    case n if (n.left, n.right) == (null, null) => (xs ::: List(n.value)).reduce(10 * _ + _)
    case n => f(n.left, xs ::: List(n.value)) + f(n.right, xs ::: List(n.value))
  }
}
