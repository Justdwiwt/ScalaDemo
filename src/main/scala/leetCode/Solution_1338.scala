package leetCode

import scala.collection.mutable

object Solution_1338 {
  def minSetSize(arr: Array[Int]): Int = {
    val m = new mutable.HashMap[Int, Int]()
    arr.foreach(i => m.put(i, m.getOrElse(i, 0) + 1))
    var res = 0
    val list = m.keySet.toList
    val t = list.sorted((o1: Int, o2: Int) => m(o2) - m(o1))
    var len = arr.length
    t.indices.foreach(i => {
      len = len - m(t(i))
      res += 1
      if (len <= arr.length / 2) return res
    })
    res
  }
}
