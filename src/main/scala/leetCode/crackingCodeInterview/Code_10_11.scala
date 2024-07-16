package leetCode.crackingCodeInterview

object Code_10_11 {
  def wiggleSort(nums: Array[Int]): Unit = {
    def swap(arr: Array[Int], i: Int, j: Int): Array[Int] = {
      val temp = arr(i)
      arr.updated(i, arr(j)).updated(j, temp)
    }

    @scala.annotation.tailrec
    def f(nums: Array[Int], i: Int): Array[Int] = {
      if (i >= nums.length) nums
      else {
        val updatedNums = (i % 2, nums(i) < nums(i - 1)) match {
          case (0, true) => swap(nums, i, i - 1)
          case (1, false) => swap(nums, i, i - 1)
          case _ => nums
        }
        f(updatedNums, i + 1)
      }
    }

    val sortedNums = f(nums, 1)
    Array.copy(sortedNums, 0, nums, 0, nums.length)
  }
}
