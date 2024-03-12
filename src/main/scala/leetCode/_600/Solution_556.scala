package leetCode._600

object Solution_556 {
  def nextGreaterElement(n: Int): Int = {
    val arr = n.toString.map(_.asDigit).toArray
    if (arr.length < 2) return -1
    var idx = arr.length - 2
    while (idx >= 0) {
      if (arr(idx) < arr(idx + 1)) {
        var firstLessThanRightIdx = arr.indexWhere(dig => dig <= arr(idx), idx + 2)
        if (firstLessThanRightIdx < 0) firstLessThanRightIdx = arr.length
        val smallestBiggerIdx = firstLessThanRightIdx - 1
        val smallestBigger = arr(smallestBiggerIdx)
        arr(smallestBiggerIdx) = arr(idx)
        arr(idx) = smallestBigger
        val nextLargerVal = (arr.slice(0, idx + 1) ++ arr.slice(idx + 1, arr.length).sorted).mkString.toLong
        if (nextLargerVal > Int.MaxValue) return -1
        else return nextLargerVal.toInt
      }
      idx -= 1
    }
    -1
  }
}
