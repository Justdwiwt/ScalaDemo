package leetCode._2500

object Solution_2472 {
  def maxPalindromes(s: String, k: Int): Int = {
    @scala.annotation.tailrec
    def f(arr: Array[(Int, Int)], l: Int, r: Int): Array[(Int, Int)] =
      if (l < 0 || r >= s.length || s(l) != s(r)) arr
      else if (r - l + 1 < k) f(arr, l - 1, r + 1)
      else arr :+ (l, r + 1)

    (0 until 2 * s.length - 1)
      ./:(Array.empty[(Int, Int)])((arr, cent) => f(arr, cent / 2, cent / 2 + cent % 2))
      ./:(0, Int.MinValue) { case ((cnt, last), (x, y)) =>
        if (x >= last) (cnt + 1, y)
        else if (y < last) (cnt, y)
        else (cnt, last)
      }
      ._1
  }
}
