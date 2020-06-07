package leetCode

object Solution_1394 {
  def findLucky(arr: Array[Int]): Int = {
    val res = Array.fill(501)(0)
    arr.indices.foreach(i => res(arr(i)) += 1)
    (1 to 500).reverse.foreach(i => if (res(i) == i) return i)
    -1
  }
}
