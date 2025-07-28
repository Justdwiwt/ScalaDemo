package leetCode._3700

object Solution_3602 {
  def concatHex36(n: Int): String = {
    val square = n * n
    val cube = n * n * n
    toBase(square, 16) + toBase(cube, 36)
  }

  private def toBase(num: Int, base: Int): String = {
    require(base >= 2 && base <= 36)
    if (num == 0) "0"
    else {
      def digitToChar(d: Int): Char =
        if (d < 10) (d + '0').toChar else (d - 10 + 'A').toChar

      @scala.annotation.tailrec
      def loop(n: Int, acc: List[Char]): List[Char] =
        if (n == 0) acc
        else loop(n / base, digitToChar(n % base) :: acc)

      loop(num, Nil).mkString
    }
  }
}
