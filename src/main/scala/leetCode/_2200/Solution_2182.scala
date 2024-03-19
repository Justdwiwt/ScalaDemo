package leetCode._2200

object Solution_2182 {
  def repeatLimitedString(s: String, repeatLimit: Int): String = {
    @scala.annotation.tailrec
    def f(cnt: List[(Char, Int)], sb: StringBuilder): StringBuilder = cnt match {
      case (c, count) :: tail if count <= repeatLimit => f(tail, sb ++= Iterator.fill(count)(c))
      case (c1, count1) :: (c2, 1) :: tail => f((c1, count1 - repeatLimit) :: tail, sb ++= Iterator.fill(repeatLimit)(c1) += c2)
      case (c1, count1) :: (c2, count2) :: tail => f((c1, count1 - repeatLimit) :: (c2, count2 - 1) :: tail, sb ++= Iterator.fill(repeatLimit)(c1) += c2)
      case (c1, _) :: Nil => sb ++= Iterator.fill(repeatLimit)(c1)
      case _ => sb
    }

    f(s.groupBy(identity).mapValues(_.length).toList.sortBy(-_._1), new StringBuilder).toString
  }
}
