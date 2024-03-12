package leetCode._1700

object Solution_1685 {
  def getSumAbsoluteDifferences(nums: Array[Int]): Array[Int] = {
    val res = Array.fill(nums.length)(0)
    val diff = Array.fill(nums.length + 1)(0)
    (1 to nums.length).foreach(i => diff(i) = diff(i - 1) + nums(i - 1))
    (1 to nums.length).foreach(i => {
      val l = i * nums(i - 1) - diff(i)
      val r = diff(nums.length) - diff(i) - (nums.length - i) * nums(i - 1)
      res(i - 1) = l + r
    })
    res
  }
}
