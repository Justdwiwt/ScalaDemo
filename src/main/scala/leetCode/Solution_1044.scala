package leetCode

import scala.collection.mutable

object Solution_1044 {
  def longestDupSubstring(str: String): String = {
    val hash, power = Array.ofDim[Long](str.length)
    val base = 29L
    val mod = 1000000007L
    hash(0) = str.head
    power(0) = base
    str.indices.drop(1).foreach(i => {
      hash(i) = ((hash(i - 1) * base) + str.charAt(i)) % mod
      power(i) = (base * power(i - 1)) % mod
    })

    def h(start: Int, end: Int): Long =
      (hash(end) - (if (start - 1 >= 0) hash(start - 1) else 0) * power(end - start) % mod + mod) % mod

    def f(wid: Int): Int = {
      val map = mutable.Map.empty[Long, mutable.Set[Int]]
      var t = h(0, wid - 1)
      map += t -> mutable.Set.empty[Int]
      map(t) += 0
      (1 to str.length - wid).foreach(i => {
        t = h(i, i + wid - 1)
        if (!map.contains(t)) map += t -> mutable.Set.empty[Int]
        else map(t).foreach(s => if (str.substring(i, i + wid).equals(str.substring(s, s + wid))) return i)
        map(t) += i
      })
      -1
    }

    var lowLen = 1
    var highLen = str.length - 1
    while (lowLen <= highLen) {
      val midLen = (lowLen + highLen) >> 1
      val tmp = f(midLen)
      if (tmp == -1) highLen = midLen - 1
      else lowLen = midLen + 1
    }
    if (highLen == 0) return ""
    val res = f(highLen)
    if (res == -1) "" else str.substring(res, res + highLen)
  }
}
