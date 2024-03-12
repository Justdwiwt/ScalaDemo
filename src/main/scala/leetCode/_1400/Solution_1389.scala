package leetCode._1400

object Solution_1389 {
  def createTargetArray(nums: Array[Int], index: Array[Int]): Array[Int] = nums.zip(index)./:(Array.empty[Int]) {
    case (arr, (n, i)) => arr.slice(0, i) ++ Array(n) ++ arr.slice(i, arr.length)
  }
}
