package leetCode

object Solution_889 {
  def constructFromPrePost(pre: Array[Int], post: Array[Int]): TreeNode = {
    val root = new TreeNode(pre.head)
    pre.tail./:((List(root), post.toList))((t, n) => {
      val newNode = new TreeNode(n)
      if (t._2.head != t._1.head.value) {
        t._1.head.left = newNode
        (newNode :: t._1, t._2)
      } else {
        val res = t._2.takeRight(t._2.length - t._1.length)
        val (st, p) = t._1.zip(t._2).dropWhile(t => t._1.value == t._2).unzip
        st.head.right = newNode
        (newNode :: st, p ::: res)
      }
    })
    root
  }
}
