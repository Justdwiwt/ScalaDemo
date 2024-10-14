package leetCode._200

object Solution_158 {
  abstract class Reader4 {
    def read4(buf: Array[Char]): Int = 0
  }

  class Solution extends Reader4 {
    val buf4: Array[Char] = Array.fill(4)(' ')
    private var buf2Read = 0
    private var next2Read = 0

    def read(buf: Array[Char], n: Int): Int = {
      @scala.annotation.tailrec
      def readRecursively(buf: Array[Char], n: Int, len: Int): Int = {
        if (len >= n) len
        else if (next2Read == buf2Read) {
          buf2Read = read4(buf4)
          next2Read = 0
          if (buf2Read == 0) len
          else readRecursively(buf, n, len)
        } else {
          buf(len) = buf4(next2Read)
          next2Read += 1
          readRecursively(buf, n, len + 1)
        }
      }

      readRecursively(buf, n, 0)
    }
  }
}
