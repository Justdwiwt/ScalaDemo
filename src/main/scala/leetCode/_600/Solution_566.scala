package leetCode._600

object Solution_566 {
  def matrixReshape(nums: Array[Array[Int]], r: Int, c: Int): Array[Array[Int]] = {
    if (nums.length * nums.head.length != r * c) return nums
    nums.flatten.grouped(c).toArray
  }
}
