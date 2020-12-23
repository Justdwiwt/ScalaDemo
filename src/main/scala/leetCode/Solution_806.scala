package leetCode

object Solution_806 {
  def numberOfLines(widths: Array[Int], S: String): Array[Int] = (('a' to 'z').zip(widths.toList).toMap match {
    case m => S./:[(Int, List[Int])](0, List(1, -1)) { (cur, idx) =>
      if (m(idx) + cur._1 > 100) (m(idx), List(cur._2.head + 1, m(idx)))
      else (cur._1 + m(idx), List(cur._2.head, cur._1 + m(idx)))
    }
  })._2.toArray
}
