package leetCode._1600

object Solution_1570 {
  class SparseVector(nums: Array[Int]) {
    private val arr = nums

    def dotProduct(vec: SparseVector): Int =
      arr.zip(vec.arr).map { case (x, y) => x * y }.sum
  }
}
