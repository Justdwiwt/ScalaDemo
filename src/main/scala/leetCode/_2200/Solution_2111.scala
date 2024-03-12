package leetCode._2200

import scala.collection.mutable.ArrayBuffer

object Solution_2111 {
  def f(seq: Iterator[Int]): Int = {
    val last = ArrayBuffer.empty[Int]

    def find(item: Int): Int = {
      var l = 0
      var r = last.size
      while (l != r) {
        val mid = (l + r) >>> 1
        if (last(mid) > item) r = mid
        else l = mid + 1
      }
      l
    }

    seq.foreach(item => {
      val idx = find(item)
      if (idx == last.size) last += item
      else last(idx) = item
    })
    last.size
  }

  def kIncreasing(arr: Array[Int], k: Int): Int = {
    var res = 0
    (0 until k).foreach(i => {
      val chain = (i until arr.length by k).iterator.map(arr)
      val length = (arr.length - i + k - 1) / k
      res += length - f(chain)
    })
    res
  }
}
