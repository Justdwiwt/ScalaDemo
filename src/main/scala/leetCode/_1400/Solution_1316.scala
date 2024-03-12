package leetCode._1400

import scala.collection.mutable

object Solution_1316 {
  def distinctEchoSubstrings(text: String): Int = {
    val s = new mutable.HashSet[String]()
    text.indices.foreach(i => (i + 1 to (text.length + i) / 2).foreach(j => {
      val t = text.substring(i, j)
      if (text.startsWith(t, j)) s.add(t)
    }))
    s.size
  }
}
