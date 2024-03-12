package leetCode._1000

object Solution_937 {
  def reorderLogFiles(logs: Array[String]): Array[String] = {
    val (digit, letters) = logs.partition(l => 'a' > l(l.indexWhere(_ == ' ') + 1))
    letters.map(l => l.dropWhile(_ != ' ') -> l).sortWith((a, b) => if (a._1 == b._1) a._2 < b._2 else a._1 < b._1).map(_._2) ++ digit
  }
}
