package leetCode._2900

object Solution_2900 {
  def getLongestSubsequence(words: Array[String], groups: Array[Int]): List[String] = words
    .zip(groups)
    .foldLeft(List[(String, Int)]())((acc, curr) => {
      if (acc.isEmpty || (acc.nonEmpty && acc.last._2 != curr._2)) acc :+ curr
      else acc
    })
    .map(_._1)
}
