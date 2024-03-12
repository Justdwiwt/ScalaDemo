package leetCode._600

import leetCode.TreeNode

import scala.collection.mutable

object Solution_508 {
  def findFrequentTreeSum(root: TreeNode): Array[Int] = {
    if (root == null) return Array.empty
    val m = mutable.Map.empty[Int, Int]
    f(root, m)
    val sorted = m.toArray.sortWith(_._2 > _._2)
    sorted.filter({ case (_, freq) => freq == sorted.head._2 }).map(_._1)
  }

  def f(root: TreeNode, m: mutable.Map[Int, Int]): Int = {
    if (root == null) return 0
    val sum = root.value + f(root.left, m) + f(root.right, m)
    m += sum -> (m.getOrElse(sum, 0) + 1)
    sum
  }
}
