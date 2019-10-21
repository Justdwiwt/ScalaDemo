package leetCode

import scala.collection.mutable.ListBuffer

object Solution_1002 {
  def commonChars(A: Array[String]): List[String] = {
    var res = map(A(0))
    (1 until A.length).foreach(i => res = reduce(res, map(A(i))))
    val list = new ListBuffer[String]
    res.indices.foreach(i => {
      while (res(i) > 0) {
        list += (('a' + i).toChar + "")
        res(i) -= 1
      }
    })
    list.toList
  }

  def map(s: String): Array[Int] = {
    val arr = new Array[Int](26)
    (0 until s.length).foreach(i => arr(s.charAt(i) - 'a') += 1)
    arr
  }

  def reduce(left: Array[Int], right: Array[Int]): Array[Int] = {
    (0 until 26).foreach(i => left(i) = math.min(left(i), right(i)))
    left
  }
}
