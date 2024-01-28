package leetCode

object Code_16_06 {
  def smallestDifference(a: Array[Int], b: Array[Int]): Int = {
    val sortedA = a.sorted
    val sortedB = b.sorted
    var i, j = 0
    var mn = Long.MaxValue
    while (i < a.length && j < b.length) {
      if (sortedA(i) == sortedB(j)) return 0
      else if (sortedA(i) > sortedB(j)) {
        mn = mn.min(sortedA(i).toLong - sortedB(j).toLong)
        j += 1
      } else {
        mn = mn.min(sortedB(j).toLong - sortedA(i))
        i += 1
      }
    }
    mn.toInt
  }
}
