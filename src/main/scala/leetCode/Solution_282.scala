package leetCode

import scala.collection.mutable

object Solution_282 {
  def addOperators(num: String, target: Int): List[String] = {
    val res = mutable.ListBuffer.empty[String]

    def add(path: String, pos: Int, eval: Long, mul: Long): Unit = {
      if (pos == num.length) {
        if (target == eval) res += path
        return
      }
      (pos until num.length).foreach(i => {
        if (i != pos && num(pos) == '0') return
        val cur = num.substring(pos, i + 1).toLong
        if (pos == 0)
          add(path + cur, i + 1, eval + cur, cur)
        else {
          add(path + "+" + cur, i + 1, eval + cur, cur)
          add(path + "-" + cur, i + 1, eval - cur, -cur)
          add(path + "*" + cur, i + 1, eval - mul + mul * cur, mul * cur)
        }
      })
    }

    add("", 0, 0, 0)
    res.toList
  }
}
