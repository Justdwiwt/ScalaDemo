package leetCode._700

object Solution_604 {
  class StringIterator(compressedString: String) {
    private var curIndex: Int = 0
    private val nums: Array[Int] = compressedString.substring(1).split("[a-zA-Z]+").map(_.toInt)
    private val chars: Array[String] = compressedString.split("[0-9]+")

    def next(): Char =
      if (hasNext) {
        nums(curIndex) -= 1
        val res = chars(curIndex).charAt(0)
        if (nums(curIndex) == 0) curIndex += 1
        res
      } else ' '

    private def hasNext: Boolean =
      curIndex != chars.length
  }
}
