package leetCode._200

object Solution_157 {
  private def read4(buf4: Array[Char]): Int = ???

  def read(buf: Array[Char], n: Int): Int = {
    @scala.annotation.tailrec
    def readRecursion(idx: Int, buffer: Array[Char]): Int = {
      if (idx >= n) idx
      else {
        val buf4 = new Array[Char](4)
        val size = read4(buf4)
        if (size == 0) idx
        else {
          var i = 0
          var updatedIdx = idx
          while (i < size && updatedIdx < n) {
            buf(updatedIdx) = buf4(i)
            i += 1
            updatedIdx += 1
          }
          readRecursion(updatedIdx, buf)
        }
      }
    }

    readRecursion(0, buf)
  }
}
