package leetCode

object Solution_566 {
  def matrixReshape(nums: Array[Array[Int]], r: Int, c: Int): Array[Array[Int]] = {
    if (nums.length * nums(0).length != r * c) return nums
    val res = Array.fill(r, c)(0)
    (0 until r * c).foreach(i => res(i / c)(i % c) = nums(i / nums(0).length)(i % nums(0).length))
    res
  }
}
