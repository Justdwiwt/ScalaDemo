package leetCode._3100

object Solution_3023 {
  abstract class InfiniteStream(bits: Array[Int]) {
    def next(): Int
  }

  def findPattern(infiniteStream: InfiniteStream, pattern: Array[Int]): Int = {
    val n = pattern.length

    val sz = 50
    val mskLow = (1L << sz.min(n)) - 1L
    val mskHigh = (1L << 0.max(n - sz)) - 1L
    val highest = mskLow + 1L

    var patternLow = 0L
    var patternHigh = 0L

    (n - 1 to 0.max(n - sz) by -1)
      .foreach(i => patternLow |= (pattern(i).toLong << (n - 1 - i)))
    (n - sz - 1 to 0 by -1)
      .foreach(i => patternHigh |= (pattern(i).toLong << (n - sz - 1 - i)))

    var low = 0L
    var high = 0L
    var i = 0
    var foundIndex = -1

    while (foundIndex == -1) {
      val bit = infiniteStream.next()

      low = (low << 1) | bit
      val tmp = if ((low & highest) == 0) 0L else 1L
      low &= mskLow

      high = (high << 1) | tmp
      high &= mskHigh

      if (n - 1 <= i && patternLow == low && patternHigh == high) {
        foundIndex = i - n + 1
      }

      i += 1
    }

    foundIndex
  }
}
