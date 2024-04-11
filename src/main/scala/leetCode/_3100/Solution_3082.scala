package leetCode._3100

object Solution_3082 {
  def sumOfPower(nums: Array[Int], k: Int): Int = {
    val arr = Array.fill(k + 1)(0L)
    arr(0) = 1
    nums.foldLeft(arr)((acc, x) => {
      (k to 0 by -1).foreach(j => acc(j) = (acc(j) * 2 + (if (j >= x) acc(j - x) else 0)) % 1000000007)
      acc
    })(k).toInt
  }
}
