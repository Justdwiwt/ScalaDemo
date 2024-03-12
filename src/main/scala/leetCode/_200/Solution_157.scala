package leetCode._200

object Solution_157 {
  def read4(buf4: Array[Char]): Int = ???

  def read(buf: Array[Char], n: Int): Int = {
    var res = 0
    var t = n
    var buffer = buf.toBuffer
    while (t > 0) {
      res += read4(buffer.toArray)
      buffer(t) = 0
      buffer += 4
      t -= 4
    }
    res
  }
}
