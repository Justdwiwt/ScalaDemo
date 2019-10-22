package leetCode

object Solution_645 {
  def findErrorNums(nums: Array[Int]): Array[Int] = {
    val res = new Array[Int](2)
    val cnt = new Array[Int](10001)
    nums.indices.foreach(i => cnt(nums(i)) += 1)
    (1 to nums.length).foreach(i => {
      if (cnt(i) == 2) res(0) = i
      if (cnt(i) == 0) res(1) = i
    })
    res
  }
}
