package leetCode._700

import scala.collection.mutable

object Solution_631 {
  class Excel(H: Int, W: Char) {
    private val map: mutable.Map[String, Array[String]] = mutable.HashMap()
    private val num: Array[Array[Int]] = Array.ofDim[Int](H, W - 'A' + 1)

    def set(r: Int, c: Char, v: Int): Unit = {
      map.remove(s"$r $c")
      num(r - 1)(c - 'A') = v
    }

    private def get(r: Int, c: Char): Int = {
      val key = s"$r $c"
      if (map.contains(key)) sum(r, c, map(key))
      else num(r - 1)(c - 'A')
    }

    private def sum(r: Int, c: Char, strs: Array[String]): Int = {
      var sum = 0
      strs.foreach(s => {
        val i = s.indexOf(":")
        if (i == -1) sum += get(s.substring(1).toInt, s.head)
        else {
          val a = s.substring(0, i)
          val b = s.substring(i + 1)
          val h1 = a.substring(1).toInt
          val w1 = a.head
          val h2 = b.substring(1).toInt
          val w2 = b.head
          (h1 to h2).foreach(h => (w1 to w2).foreach(sum += get(h, _)))
        }
      })
      map.put(s"$r $c", strs)
      sum
    }
  }
}
