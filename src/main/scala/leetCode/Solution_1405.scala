package leetCode

import scala.util.control.Breaks._

object Solution_1405 {
  def longestDiverseString(a: Int, b: Int, c: Int): String = {
    var char2num = Array.empty[Int]

    def nextChar(exclude: Char): Char = exclude match {
      case 'a' => if (char2num(1) > char2num(2)) 'b' else 'c'
      case 'b' => if (char2num(0) > char2num(2)) 'a' else 'c'
      case 'c' => if (char2num(0) > char2num(1)) 'a' else 'b'
      case _ =>
        val res = if (char2num(0) > char2num(1)) 'a' else 'b'
        if (char2num(res - 'a') > char2num(2)) res else 'c'
    }

    char2num = Array(a, b, c)
    val res = Array.ofDim[Char](a + b + c)
    var idx = 0
    breakable {
      while (char2num(0) != 0 || char2num(1) != 0 || char2num(2) != 0) {
        var next = ' '
        if (idx < 2 || res(idx - 1) != res(idx - 2)) next = nextChar(' ')
        else next = nextChar(res(idx - 1))
        if (char2num(next - 'a') <= 0) break()
        char2num(next - 'a') -= 1
        res(idx) = next
        idx += 1
      }
    }

    new String(res, 0, idx)
  }
}
