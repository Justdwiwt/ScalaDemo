package leetCode._100

object Solution_49 {
  def groupAnagrams(strs: Array[String]): List[List[String]] = strs.map(x => (x.sorted, x)).groupBy(_._1).map(_._2.map(_._2).toList).toList
}
