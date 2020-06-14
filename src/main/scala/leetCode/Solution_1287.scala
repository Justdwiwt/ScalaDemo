package leetCode

object Solution_1287 {
  def findSpecialInteger(arr: Array[Int]): Int = {
    (0 until arr.length - arr.length / 4).foreach(i => if (arr(i) == arr(i + arr.length / 4)) return arr(i))
    arr.head
  }
}
