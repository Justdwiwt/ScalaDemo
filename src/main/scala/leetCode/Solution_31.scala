package leetCode

object Solution_31 {
  def nextPermutation(nums: Array[Int]): Unit = {
    @annotation.tailrec
    def reverse(i: Int, j: Int): Unit = {
      if (i < j) {
        val t = nums(i)
        nums(i) = nums(j)
        nums(j) = t
        reverse(i + 1, j - 1)
      }
    }

    def swap(i: Int, j: Int): Unit = {
      val t = nums(i)
      nums(i) = nums(j)
      nums(j) = t
    }

    nums.indices.drop(1).reverse.find(r => {
      val x = r - 1
      nums(x) < nums(r)
    }) match {
      case None =>
        reverse(0, nums.indices.last)
      case Some(r) =>
        val x = r - 1
        val Some(y) = (r until nums.length).reverse.find(y => nums(y) > nums(x))
        swap(x, y)
        reverse(r, nums.indices.last)
    }
  }
}
