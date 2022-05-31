package leetCode

import scala.collection.mutable

object Solution_1461 {
  def hasAllCodes(s: String, k: Int): Boolean = (k to s.length)
    ./:(mutable.Set[String]())((b, a) => {
      b.add(s.substring(a - k, a))
      if (b.size == (1 << k)) return true
      b
    })
    .size == (1 << k)
}
