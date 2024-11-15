package leetCode._3400

object Solution_3351 {
  def sumOfGoodSubsequences(nums: Array[Int]): Int = {
    val M = 1000000007
    val f = collection.mutable.Map[Int, Int]().withDefaultValue(0)
    val cnt = collection.mutable.Map[Int, Int]().withDefaultValue(0)

    nums.foreach(x => {
      val c = cnt(x - 1) + cnt(x + 1) + 1
      f(x) = (f(x) + f(x - 1) + f(x + 1) + x * c) % M
      cnt(x) = (cnt(x) + c) % M
    })

    f.values.sum % M
  }
}
