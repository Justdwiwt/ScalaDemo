package leetCode._1900

object Solution_1894 {
  def chalkReplacer(ch: Array[Int], _k: Int): Int = {
    var k = _k % ch.map(_.toLong).sum
    ch.indices.foreach(i => if (k >= ch(i)) k -= ch(i) else return i)
    -1
  }
}
