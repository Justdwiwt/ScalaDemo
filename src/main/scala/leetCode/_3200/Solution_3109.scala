package leetCode._3200

import scala.collection.mutable

object Solution_3109 {
  private val M: Int = 1000000007
  private val fact: Array[Long] = Array.fill(100001)(1)

  // fixme: case 436 memory limit is exceeded
  def getPermutationIndex(perm: List[Int]): Int = {
    val n: Int = perm.length
    val st = mutable.SortedSet(1 to n: _*)
    var res = 0L
    perm.indices.foreach(p => {
      res = (res + st.rangeImpl(Some(1), Some(perm(p))).size.toLong * fact(n - 1 - p)) % M
      st -= perm(p)
    })
    res.toInt
  }
}
