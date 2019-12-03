package leetCode

import scala.collection.mutable.ListBuffer

object Solution_386 {
  def lexicalOrder(n: Int): List[Int] = {
    val res = ListBuffer.fill(n)(0)
    var cur = 1
    (0 until n).foreach(i => {
      res(i) = cur
      if (cur * 10 <= n) cur *= 10
      else {
        if (cur >= n) cur /= 10
        cur += 1
        while (cur % 10 == 0) cur /= 10
      }
    })
    res.toList
  }
}
