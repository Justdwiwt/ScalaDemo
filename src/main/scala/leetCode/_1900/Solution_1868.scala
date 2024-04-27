package leetCode._1900

object Solution_1868 {
  def findRLEArray(encoded1: Array[Array[Int]], encoded2: Array[Array[Int]]): List[List[Int]] = {
    val list1 = encoded1.toList.map(a => (a.head, a(1)))
    val list2 = encoded2.toList.map(a => (a.head, a(1)))

    @scala.annotation.tailrec
    def f(l1: List[(Int, Int)], l2: List[(Int, Int)], acc: List[(Int, Int)]): List[(Int, Int)] = (l1, l2) match {
      case ((n1, c1) :: t1, (n2, c2) :: t2) =>
        val minCount = math.min(c1, c2)
        val headProduct = n1 * n2
        val newAcc =
          if (acc.nonEmpty && acc.head._1 == headProduct) (headProduct, acc.head._2 + minCount) :: acc.tail
          else (headProduct, minCount) :: acc
        if (c1 == minCount && c2 == minCount) f(t1, t2, newAcc)
        else if (c1 == minCount) f(t1, (n2, c2 - minCount) :: t2, newAcc)
        else f((n1, c1 - minCount) :: t1, t2, newAcc)
      case _ => acc
    }

    f(list1, list2, Nil).reverse.map { case (num, cnt) => List(num, cnt) }
  }
}
