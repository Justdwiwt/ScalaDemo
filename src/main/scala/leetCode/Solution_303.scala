package leetCode

object Solution_303 {

  class NumArray(_nums: Array[Int]) {

    private val arr = _nums.scan(0)(_ + _)

    def sumRange(i: Int, j: Int): Int = arr(j + 1) - arr(i)

  }

}
