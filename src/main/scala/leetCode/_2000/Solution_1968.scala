package leetCode._2000

object Solution_1968 {
  def rearrangeArray(nums: Array[Int]): Array[Int] = {
    val sorted = nums.sorted
    (sorted.indices.drop(1).dropRight(1) by 2).foreach(i => {
      val t = sorted(i)
      sorted(i) = sorted(i + 1)
      sorted(i + 1) = t
    })
    sorted
  }
}
