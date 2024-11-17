package leetCode._3400

object Solution_3354 {
  def countValidSelections(nums: Array[Int]): Int = {
    val total = nums.sum
    nums.foldLeft((0, 0)) { case ((res, pre), x) =>
      if (x != 0) (res, pre + x)
      else {
        val newAns = if (pre * 2 == total) res + 2
        else if ((pre * 2 - total).abs == 1) res + 1
        else res
        (newAns, pre)
      }
    }._1
  }
}
