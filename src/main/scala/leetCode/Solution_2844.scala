package leetCode

import scala.collection.mutable

object Solution_2844 {
  def minimumOperations(num: String): Int = {
    val m = mutable.HashMap.empty[Char, Char]
    m += '0' -> '0'
    m += '2' -> '5'
    m += '5' -> '0'
    m += '7' -> '5'
    val st = mutable.HashSet.empty[Char]
    var flag = false
    num.indices.reverse.foreach(i => {
      val ch = num(i)
      if (ch == '0') flag = true
      if (m.contains(ch) && st.contains(m(ch))) return num.length - i - 2
      st += ch
    })
    if (flag) num.length - 1 else num.length
  }
}
