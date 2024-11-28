package leetCode._3400

object Solution_3361 {
  def shiftDistance(s: String, t: String, nextCost: Array[Int], previousCost: Array[Int]): Long = {
    val nextArr = Range(0, 52).scanLeft(0L)((acc, i) => acc + nextCost(i % 26)).toArray
    nextArr.zipWithIndex.map { case (a, i) => (i, (i % 26 + 'a').toChar, a) }
    val prevArr = Range(0, 51).scanRight(0L)((i, acc) => acc + previousCost(i % 26)).tail.toArray
    prevArr.zipWithIndex.map { case (a, i) => (i, (i % 26 + 'a').toChar, a) }

    def next(a: Char, b: Char): Long =
      if (a == b) 0
      else if (a < b) nextArr(b - 'a') - nextArr(a - 'a')
      else nextArr(b + 26 - 'a') - nextArr(a - 'a')

    def prev(a: Char, b: Char): Long =
      if (a == b) 0
      else if (b < a) prevArr(b - 'a') - prevArr(a - 'a')
      else prevArr(b - 'a') - prevArr(a + 26 - 'a')

    s.zip(t).foldLeft(0L) { case (acc, (a, b)) => acc + next(a, b).min(prev(a, b)) }
  }
}
