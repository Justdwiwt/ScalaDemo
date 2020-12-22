package leetCode

object Solution_870 {
  def advantageCount(a: Array[Int], b: Array[Int]): Array[Int] = {
    val bSorted = b.indices.sortBy(b)
    val (bIdxToAValue, _, _) = a.sorted./:(Map[Int, Int](), 0, bSorted.length) {
      case ((map, start, end), v) if v > b(bSorted(start)) => (map + (bSorted(start) -> v), start + 1, end)
      case ((map, start, end), elem) => (map + (bSorted(end - 1) -> elem), start, end - 1)
    }
    b.indices.map(bIdxToAValue).toArray
  }
}
