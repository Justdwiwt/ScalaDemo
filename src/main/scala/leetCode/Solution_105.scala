package leetCode

object Solution_105 {

  case class Task(handler: TreeNode => _, x: (Int, Int), y: (Int, Int))

  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    val map = inorder.zipWithIndex.toMap
    val q = preorder.take(1).map(_ => Task((_: TreeNode) => (), (0, preorder.length - 1), (0, preorder.length - 1)))
    f(preorder, q, map)
  }

  @scala.annotation.tailrec
  def f(preorder: Array[Int], q: Seq[Task], map: Map[Int, Int], root: Option[TreeNode] = None): TreeNode = q match {
    case Task(handler, (x1, x2), (y1, y2)) +: tail =>
      val par = new TreeNode(preorder(x1))
      handler(par)
      val id = map(par.value)
      val newQ = tail ++
        Seq(Task(setLeft(par)(_), (x1 + 1, x1 + (id - y1)), (y1, id - 1)),
          Task(setRight(par)(_), (x1 + (id - y1) + 1, x2), (id + 1, y2)))
          .filter(t => t.x._1 <= t.x._2)
      f(preorder, newQ, map, root.orElse(Some(par)))
    case _ => root.orNull
  }

  def setLeft(p: TreeNode)(c: TreeNode): Unit = p.left = c

  def setRight(p: TreeNode)(c: TreeNode): Unit = p.right = c

}
