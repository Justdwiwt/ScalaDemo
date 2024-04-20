package leetCode._2400

object Solution_2313 {
  // fixme: case 59/61 stack overflow
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  private val FALSE = 0
  private val TRUE = 1
  private val OR = 2
  private val AND = 3
  private val XOR = 4
  private val NOT = 5

  def minimumFlips(root: TreeNode, result: Boolean): Int = {
    val res = getTime(root)
    if (result) res.head else res(1)
  }

  private def getTime(root: TreeNode): Array[Int] = {
    if (root == null) return Array(0, 0)
    root.value match {
      case `TRUE` => Array(0, 1)
      case `FALSE` => Array(1, 0)
      case _ =>
        val lRes = getTime(root.left)
        val rRes = getTime(root.right)
        root.value match {
          case `OR` => Array(Math.min(lRes(0), rRes(0)), lRes(1) + rRes(1))
          case `AND` => Array(lRes(0) + rRes(0), Math.min(lRes(1), rRes(1)))
          case `XOR` => Array(Math.min(lRes(0) + rRes(1), lRes(1) + rRes(0)), Math.min(lRes(0) + rRes(0), lRes(1) + rRes(1)))
          case `NOT` => Array(lRes(1) + rRes(1), lRes(0) + rRes(0))
          case _ => Array(0, 0)
        }
    }
  }
}
