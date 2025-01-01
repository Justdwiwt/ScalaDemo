package leetCode._300

object Solution_296 {
  def minTotalDistance(grid: Array[Array[Int]]): Int = {
    val (x, y) = grid.zipWithIndex.flatMap { case (row, i) => row.zipWithIndex.collect { case (1, j) => (i, j) } }.unzip
    f(x.toIndexedSeq) + f(y.toIndexedSeq)
  }

  private def f(nums: Seq[Int]): Int = {
    val sorted = nums.sorted
    val median = sorted(sorted.length / 2)
    sorted.foldLeft(0)((acc, num) => acc + (num - median).abs)
  }
}
