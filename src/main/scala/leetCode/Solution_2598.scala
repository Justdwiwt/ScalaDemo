package leetCode

object Solution_2598 {
  def findSmallestInteger(nums: Array[Int], value: Int): Int = {
    val arr = new Array[Int](value)
    nums.indices.foreach(i => {
      val k = ((nums(i) % value) + value) % value
      arr(k) += 1
    })
    var stop = 0
    arr.indices.foreach(i => if (arr(i) < arr(stop)) stop = i)
    arr(stop) * value + stop
  }
}
