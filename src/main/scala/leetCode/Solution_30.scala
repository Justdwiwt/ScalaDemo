package leetCode

import scala.collection.mutable

object Solution_30 {
  def findSubstring(s: String, words: Array[String]): List[Int] = {
    if (s.isEmpty || words.isEmpty) return Nil
    val l1 = s.length
    val l2 = words.map(_.length).sum
    val key = words.permutations.map(_.mkString).toSet

    val hash_targets = new mutable.HashSet[String]()
    val i = key.iterator
    while (i.hasNext) hash_targets.add(i.next())

    (0 to (l1 - l2)).withFilter(i => key.contains(s.substring(i, i + l2))).map(i => i).toList
  }
}
