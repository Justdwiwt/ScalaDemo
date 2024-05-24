package leetCode._3000

import scala.collection.mutable.ArrayBuffer

object Solution_2953 {
  def countCompleteSubstrings(word: String, k: Int): Int = {
    var res = 0
    val n = word.length
    val arr = Array.fill(26)(new ArrayBuffer[Int])
    val list = ArrayBuffer.empty[Int]

    word.indices.foreach(i => {
      arr(word(i) - 'a').append(i)
      list.clear()
      (0 until 26).foreach(j => if (arr(j).size >= k) list.append(arr(j)(arr(j).size - k)))
      val sorted = list.sorted(Ordering[Int].reverse)
      sorted.indices.foreach(j => if (i - sorted(j) + 1 == (j + 1) * k) res += 1)
      if (i + 1 < n && (word(i) - word(i + 1)).abs > 2) arr.foreach(_.clear())
    })

    res
  }
}
