package leetCode

object Solution_238 {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val res = Array.fill(nums.length)(1)
    (1 until nums.length).foreach(i => res(i) = res(i - 1) * nums(i - 1))
    var t = 1
    nums.indices.reverse.foreach(i => {
      res(i) *= t
      t *= nums(i)
    })
    res
  }
}
