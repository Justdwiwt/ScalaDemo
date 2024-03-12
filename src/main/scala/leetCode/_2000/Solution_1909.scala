package leetCode._2000

object Solution_1909 {
  def canBeIncreasing(nums: Array[Int]): Boolean = {
    def f(arr: Array[Int]): Boolean = arr.indices.dropRight(1).forall(i => arr(i) < arr(i + 1))

    nums.indices.exists(i => f(nums.take(i) ++ nums.drop(i + 1)))
  }
}
