package leetCode

import scala.collection.mutable

object Solution_893 {
  def numSpecialEquivGroups(A: Array[String]): Int = {
    val s = new mutable.HashSet[String]()
    A.foreach(i => {
      var even = ""
      var odd = ""
      i.indices.foreach(j => if (j % 2 == 0) even += i(j) else odd += i(j))
      even = even.sorted
      odd = odd.sorted
      s.add(even + odd)
    })
    s.size
  }
}
