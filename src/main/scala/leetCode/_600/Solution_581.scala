package leetCode._600

object Solution_581 {
  def findUnsortedSubarray(nums: Array[Int]): Int = {
    val prefSize = nums.:\(Int.MaxValue, 0)((n, d) => {
      if (n <= d._1) (n, d._2 + 1)
      else (d._1, 0)
    })._2

    val sufSize = nums.drop(prefSize)./:(Int.MinValue, 0)((d, n) => {
      if (n >= d._1) (n, d._2 + 1)
      else (d._1, 0)
    })._2

    nums.length - prefSize - sufSize
  }
}
