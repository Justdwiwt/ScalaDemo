package leetCode._1000

object Solution_904 {
  def totalFruit(tree: Array[Int]): Int = tree./:((0, -1, 0, -1, 0)) { case ((res, p1, l1, p2, l2), t) =>
    t match {
      case `p1` => (res.max(l2 + 1), p1, l1 + 1, p2, l2 + 1)
      case `p2` => (res.max(l2 + 1), p2, 1, p1, l2 + 1)
      case _ => (res.max(l1 + 1), t, 1, p1, l1 + 1)
    }
  }._1
}
