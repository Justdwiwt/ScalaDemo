package leetCode

object Solution_1663 {
  def getSmallestString(n: Int, k: Int): String = {
    val arr = Array.fill[Char](n)('a')
    (n - 1 to 0 by -1)./:(k - n)((b, a) => {
      if (b >= 25) {
        arr(a) = 'z'
        b - 25
      }
      else {
        arr(a) = (b + 97).toChar
        0
      }
    })
    arr.mkString
  }
}
