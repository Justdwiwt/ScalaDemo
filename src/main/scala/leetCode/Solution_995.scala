package leetCode

object Solution_995 {
  def minKBitFlips(a: Array[Int], k: Int): Int = {
    @scala.annotation.tailrec
    def minKBitFlips(i: Int, numFlips: Int): Int = {
      if (a.length - i <= k)
        if ((i until a.length).forall(a(_) == 0)) numFlips + 1
        else if ((i until a.length).forall(a(_) == 1)) numFlips
        else -1
      else if (a(i) == 0) {
        f(a, i, i + k)
        minKBitFlips(i + 1, numFlips + 1)
      } else minKBitFlips(i + 1, numFlips)
    }

    minKBitFlips(0, 0)
  }

  def f(bits: Array[Int], start: Int, end: Int): Unit = (start until end).foreach(i => bits(i) = 1 - bits(i))
}
