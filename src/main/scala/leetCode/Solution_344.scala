package leetCode

object Solution_344 {
  def reverseString(s: Array[Char]): Unit = {
    @scala.annotation.tailrec
    def f(arr: Array[Char], l: Int, r: Int): Array[Char] = l match {
      case _ if l >= r => arr
      case _ =>
        val t = arr(r)
        arr(r) = arr(l)
        arr(l) = t
        f(arr, l + 1, r - 1)
    }

    f(s, 0, s.length - 1)
  }
}
