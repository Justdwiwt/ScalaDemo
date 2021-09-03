package leetCode

import scala.collection.mutable

object Solution_831 {
  def maskPII(S: String): String = {
    val at = S.indexOf('@')
    if (at > 0) {
      val f = S.take(at)
      val sb = new mutable.StringBuilder
      sb += f.head
      sb ++= "*****"
      sb += f.last
      sb ++= S.drop(at)
      sb.toString.toLowerCase
    } else {
      val n = S.filter(_.isDigit)
      val sb = new mutable.StringBuilder
      if (n.length > 10) {
        sb += '+'
        sb ++= "*" * (n.length - 10)
        sb += '-'
      }
      sb ++= "***-***-"
      sb ++= n.takeRight(4)
      sb.toString
    }
  }
}
