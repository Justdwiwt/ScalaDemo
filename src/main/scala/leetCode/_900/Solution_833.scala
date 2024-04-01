package leetCode._900

import scala.collection.mutable

object Solution_833 {
  def findReplaceString(s: String, indexes: Array[Int], sources: Array[String], targets: Array[String]): String = {
    val combined = indexes.zipWithIndex.map { case (index, i) => (index, sources(i), targets(i)) }.sortBy(_._1)
    val toAppend = mutable.Map.empty[Int, (String, String)]
    combined.foreach(com => {
      if (exists(com._1, s, com._2)) {
        toAppend(com._1) = (com._2, com._3)
      }
    })
    val res = new StringBuilder()
    var i = 0
    while (i < s.length) {
      if (toAppend.contains(i)) {
        res.append(toAppend(i)._2)
        i += toAppend(i)._1.length
      } else {
        res.append(s(i).toString)
        i += 1
      }
    }
    res.toString
  }

  private def exists(start: Int, s: String, toFind: String): Boolean = {
    if (start + toFind.length > s.length) false
    else {
      var i = start
      var j = 0
      while (j < toFind.length) {
        if (s(i) != toFind(j)) return false
        i += 1
        j += 1
      }
      true
    }
  }
}
