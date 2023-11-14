package leetCode

object Solution_2785 {
  def sortVowels(s: String): String = {
    val (ss, is) = s.zipWithIndex.filter(n => "AEIOUaeiou".contains(n._1)).unzip
    (ss.sorted.zip(is) ++ s.zipWithIndex.filter(n => !"AEIOUaeiou".contains(n._1))).sortBy(_._2).map(_._1).mkString
  }
}
