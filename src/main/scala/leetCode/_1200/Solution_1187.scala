package leetCode._1200

import scala.collection.mutable

object Solution_1187 {
  def makeArrayIncreasing(arr1: Array[Int], arr2: Array[Int]): Int = {
    if (arr1.length == 1) return 0
    val ts = mutable.TreeSet[Int](arr2: _*)
    val m = mutable.HashMap.empty[String, Int]

    def f(idx: Int, pre: Int): Int = {
      if (idx == arr1.length) return 0
      val key = idx.toString + "#" + pre
      if (m.contains(key)) return m(key)
      val cur = arr1(idx)
      var res = 2000
      if (cur > pre) {
        res = f(idx + 1, cur)
        val higher = ts.to(pre + 1).headOption.getOrElse(-1)
        if (higher != -1 && higher < cur) res = res.min(1 + f(idx + 1, higher))
      } else {
        val higher = ts.to(pre + 1).headOption.getOrElse(-1)
        if (higher != -1) res = f(idx + 1, higher) + 1
      }
      m += (key -> res)
      res
    }

    val res = f(0, -1)
    if (res >= 2000) -1 else res
  }
}
