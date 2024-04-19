package leetCode._2500

object Solution_2495 {
  def evenProduct(nums: Array[Int]): Long = {
    var left = -1
    var sum = 0L

    nums.indices.foreach(i => if (nums(i) % 2 == 0) {
      sum += (i + 1)
      left = i
    } else if (left != -1) sum += (left + 1))

    sum
  }
}
