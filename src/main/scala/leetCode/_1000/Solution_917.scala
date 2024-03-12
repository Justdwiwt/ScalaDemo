package leetCode._1000

object Solution_917 {
  def reverseOnlyLetters(S: String): String = {
    val (p, q) = S.zipWithIndex.partition(x => x._1.toInt >= 65 && x._1.toInt <= 90 || x._1.toInt >= 97 && x._1.toInt <= 122)
    var res = p.reverse.map(x => x._1).mkString
    q.foreach(i => res = res.patch(i._2, i._1.toString, 0))
    res
  }
}
