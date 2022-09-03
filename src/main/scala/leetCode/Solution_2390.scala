package leetCode

import scala.collection.mutable

object Solution_2390 {
  def removeStars(s: String): String = {
    val sb = new mutable.StringBuilder()
    s.foreach {
      case '*' => sb.deleteCharAt(sb.length() - 1)
      case ch => sb += ch
    }
    sb.mkString
  }
}
