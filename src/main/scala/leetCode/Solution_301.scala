package leetCode

import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

object Solution_301 {

  private val res = new StringBuilder

  def removeInvalidParentheses(s: String): List[String] = {
    var left = 0
    var right = 0
    s.foreach(i => {
      if (i == '(') left += 1
      if (i == ')') {
        if (left > 0) left -= 1
        else right += 1
      }
    })
    dfs(s, 0, left, right)
    val tmp = new ListBuffer[String]
    res.indices.foreach(i => tmp.append(res(i).toString))
    tmp.toList
  }

  def dfs(s: String, st: Int, l: Int, r: Int): Unit = {
    if (l == 0 && r == 0) {
      if (check(s))
        res.append(s)
      return
    }
    breakable {
      (st until s.length).foreach(i => {
        if (i - 1 >= st && s(i) == s(i - 1)) break
        if (l > 0 && s(i) == '(') dfs(s.substring(0, i) + s.substring(i + 1, s.length - i - 1), i, l - 1, r)
        if (r > 0 && s(i) == ')') dfs(s.substring(0, i) + s.substring(i + 1, s.length - i - 1), i, l, r - 1)
      })
    }
  }

  def check(s: String): Boolean = {
    var cnt = 0
    s.foreach(i => {
      if (i == '(') cnt += 1
      if (i == ')') {
        cnt -= 1
        if (cnt < 0) return false
      }
    })
    cnt == 0
  }
}
