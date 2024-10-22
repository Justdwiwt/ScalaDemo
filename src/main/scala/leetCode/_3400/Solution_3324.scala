package leetCode._3400

object Solution_3324 {
  def stringSequence(target: String): List[String] = target
    .foldLeft((List.empty[String], "")) { case ((res, pre), c) =>
      val cur = ('a' to c).toList.map(pre + _)
      (res ++ cur, cur.last)
    }._1
}
