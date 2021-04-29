package leetCode

object Solution_1339 {
  def maxProduct(root: TreeNode): Int = {
    val sum = totalSum(Option(root))
    (split(Option(root), sum)(2) % 1000000007).toInt
  }

  def split(ndOpt: Option[TreeNode], totalSum: Int): List[Long] = ndOpt.map(nd => {
    val left = split(Option(nd.left), totalSum)
    val right = split(Option(nd.right), totalSum)
    val sum = nd.value + left.head + right.head
    val prod = 1L * sum * (totalSum - sum)
    val maxProd = List(prod, left(2), right(2)).max
    List(sum, prod, maxProd)
  }).getOrElse(List(0L, 0L, 0L))

  def totalSum(ndOpt: Option[TreeNode]): Int = ndOpt
    .map(nd => nd.value + totalSum(Option(nd.left)) + totalSum(Option(nd.right)))
    .getOrElse(0)
}
