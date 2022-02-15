package leetCode

object Solution_2171 {
  def minimumRemoval(beans: Array[Int]): Long = {
    if (beans.length <= 1) return 0
    val sorted = beans.map(_.toLong).sorted
    sorted.sum - sorted.indices.map(i => sorted(i) * (sorted.length - i)).max
  }
}
