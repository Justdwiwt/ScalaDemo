package leetCode._1300

object Solution_1228 {
  def missingNumber(arr: Array[Int]): Int = {
    val arraySum = arr.sum
    val length = arr.length
    val realSum = (arr.head + arr.last) * (length + 1) / 2
    realSum - arraySum
  }
}
