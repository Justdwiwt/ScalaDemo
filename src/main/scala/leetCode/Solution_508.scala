package leetCode

object Solution_508 {

  private var ans = Array.empty[Int]

  def findFrequentTreeSum(root: TreeNode): Array[Int] = {
    func(root)
    var t = ans.sorted
    t :+= Int.MinValue
    var res = Array.empty[Int]
    var cnt = 1
    var m = -1
    (0 until t.length - 1).foreach(i => {
      if (t(i) == t(i + 1)) cnt += 1 else cnt = 1
      if (cnt == m) res :+= t(i)
      if (cnt > m) {
        res = Array.empty[Int]
        m = cnt
        res :+= t(i)
      }
    })
    res
  }

  def func(node: TreeNode): Int = node match {
    case null => 0
    case _ =>
      val left = func(node.left)
      val right = func(node.right)
      val sum = left + right + node.value
      ans :+= sum
      sum
  }

}
