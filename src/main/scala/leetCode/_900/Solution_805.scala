package leetCode._900

object Solution_805 {
  def splitArraySameAverage(nums: Array[Int]): Boolean = {
    val avg = nums.sum.toDouble / nums.length
    val (left, right) = (nums.take(nums.length / 2), nums.drop(nums.length / 2))
    var flag = false
    (0 to left.length).foreach(i => (0 to right.length)
      .withFilter(j => i + j != 0 && i + j != nums.length && !flag)
      .foreach(j => {
        val l = left.combinations(i).map(_.sum).toVector.sorted
        val r = right.combinations(j).map(_.sum).toVector.sorted
        var (x, y) = (0, r.size - 1)
        while (x < l.size && y >= 0 && !flag) {
          if ((l(x) + r(y) - avg * (i + j)).abs < 1e-6) flag = true
          else if (l(x) + r(y) < avg * (i + j)) x += 1
          else y -= 1
        }
      }))
    flag
  }
}
