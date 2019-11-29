package leetCode

import scala.collection.mutable

object Solution_187 {
  def findRepeatedDnaSequences(s: String): List[String] = {
    val st = new mutable.HashSet[String]()
    val res = new mutable.HashSet[String]()
    (0 until s.length - 9).foreach(i => {
      val t = s.substring(i, 10)
      if (st.contains(t)) res.add(t)
      else st.add(t)
    })
    var ans = List[String]()
    res.foreach(i => ans :+= i)
    ans
  }
}
