package leetCode

import scala.collection.mutable

object Solution_1056 {
  def confusingNumber(n: Int): Boolean = {
    val s = n.toString
    val sb = new mutable.StringBuilder
    val m = mutable.Map(
      ('0', '0'),
      ('1', '1'),
      ('6', '9'),
      ('8', '8'),
      ('9', '6')
    )
    s.toCharArray.foreach(c => {
      if (c == '2' || c == '3' || c == '4' || c == '5' || c == '7')
        return false
      sb.append(m(c))
    })
    sb.reverse.mkString.toInt != n
  }
}
