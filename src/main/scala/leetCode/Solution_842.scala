package leetCode

import scala.collection.mutable.ListBuffer

object Solution_842 {
  def splitIntoFibonacci(S: String): List[Int] = {
    val res = ListBuffer.empty[Int]

    def dfs(p: Int, S: String, res: ListBuffer[Int]): Boolean = {
      val size = res.size
      if (p == S.length) return size > 2
      var num = 0
      (p until S.length).foreach(i => {
        num = 10 * num + S(i) - '0'
        if (num < 0) return false
        if (size < 2 || num == res(size - 1) + res(size - 2)) {
          res += num
          if (dfs(i + 1, S, res)) return true
          res.remove(size)
        }
        if (S(i) - '0' == 0 && i == p) return false
      })
      false
    }

    if (dfs(0, S, res)) res.toList else Nil
  }
}
