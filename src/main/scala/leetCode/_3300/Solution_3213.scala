package leetCode._3300

object Solution_3213 {
  class TreeNode {
    var isEnd: Boolean = false
    var cost: Int = Int.MaxValue
    var child: Array[TreeNode] = Array.ofDim[TreeNode](26)
  }

  var res: Int = Int.MaxValue
  var root: TreeNode = _

  def minimumCost(target: String, words: Array[String], costs: Array[Int]): Int = {
    root = new TreeNode()
    buildTrie(root, words, costs, target)
    val n = target.length
    val dp = Array.fill(n + 1)(0)

    (1 to n).foreach(i => {
      var j = i
      var p = root
      while (j >= 1) {
        val c = target.charAt(j - 1)
        if (p.child(c - 'a') == null) j = 0
        else {
          p = p.child(c - 'a')
          if (p.isEnd) {
            if (j - 1 != 0 && dp(j - 1) == 0) ()
            else if (dp(i) == 0) dp(i) = dp(j - 1) + p.cost
            else dp(i) = dp(i).min(dp(j - 1) + p.cost)
          }
          j -= 1
        }
      }
    })
    if (dp(n) == 0) -1 else dp(n)
  }

  private def buildTrie(root: TreeNode, words: Array[String], costs: Array[Int], target: String): Unit = words.indices.foreach(i => {
    var p = root
    (words(i).length - 1 to 0 by -1).foreach(j => {
      val c = words(i).charAt(j)
      if (p.child(c - 'a') == null) p.child(c - 'a') = new TreeNode()
      p = p.child(c - 'a')
    })
    p.isEnd = true
    p.cost = p.cost.min(costs(i))
  })
}
