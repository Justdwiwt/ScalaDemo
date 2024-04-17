package leetCode._3100

import scala.collection.mutable.ListBuffer

object Solution_3008 {
  // fixme: case 229/237 timeout
  def beautifulIndices(s: String, a: String, b: String, k: Int): List[Int] = {
    val bNex = getNext(b)
    val bStart = getSelectedPos(s, b, bNex)
    val pre = diff(bStart, s.length, k)
    val aNex = getNext(a)
    val aStart = ListBuffer[Int](getSelectedPos(s, a, aNex): _*)
    aStart.indices.reverse.foreach(i => if (pre(aStart(i)) == 0) aStart.remove(i))
    aStart.toList
  }

  private def getNext(str: String): Array[Int] = {
    val next = Array.fill(str.length)(0)
    var j = 0
    str.indices.drop(1).foreach(i => {
      while (j > 0 && str(i) != str(j)) j = next(j - 1)
      if (str(i) == str(j)) j += 1
      next(i) = j
    })
    next
  }

  private def getSelectedPos(str: String, sub: String, nex: Array[Int]): List[Int] = {
    val lb = ListBuffer.empty[Int]
    val n = sub.length
    var j = 0
    str.indices.foreach(i => {
      while (j > 0 && str(i) != sub(j)) j = nex(j - 1)
      if (str(i) == sub(j)) j += 1
      if (j == n) {
        lb += (i + 1 - n)
        j = nex(j - 1)
      }
    })
    lb.toList
  }

  private def diff(list: List[Int], len: Int, k: Int): Array[Int] = {
    val res = Array.fill(len + 1)(0)
    list.foreach(i => {
      val left = 0.max(i - k)
      val right = (i + k).min(len - 1)
      res(left) += 1
      res(right + 1) -= 1
    })
    (1 to len).foreach(i => res(i) += res(i - 1))
    res
  }
}
