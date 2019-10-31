package leetCode

import java.util
import java.util.Collections

object Solution_761 {
  def makeLargestSpecial(S: String): String = {
    val sb = new StringBuilder
    val list = new util.ArrayList[String]()
    var start = 0
    var cnt = 0
    S.indices.foreach(i => {
      if (S.charAt(i) == '1') cnt += 1 else cnt += -1
      if (cnt == 0) {
        list.add("1" + makeLargestSpecial(S.substring(start + 1, i)) + "0")
        start = i + 1
      }
    })
    Collections.sort(list)
    (list.size() - 1 to 0 by -1).foreach(i => sb.append(list.get(i)))
    sb.toString
  }
}
