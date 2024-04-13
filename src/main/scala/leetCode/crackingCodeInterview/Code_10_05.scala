package leetCode.crackingCodeInterview

object Code_10_05 {
  def findString(words: Array[String], s: String): Int = {
    @scala.annotation.tailrec
    def binarySearch(l: Int, r: Int): Int =
      if (r < l) -1
      else {
        val mid = (l + r) >>> 1
        val newMid = Stream.iterate(mid)(_ - 1).dropWhile(i => i > l && words(i) == "").headOption.getOrElse(l)
        if (s.compareTo(words(newMid)) == 0) newMid
        else if (s.compareTo(words(newMid)) < 0) binarySearch(l, newMid - 1)
        else binarySearch(newMid + 1, r)
      }

    binarySearch(0, words.length - 1)
  }
}
