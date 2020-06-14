package leetCode

object Solution_1299 {
  def replaceElements(arr: Array[Int]): Array[Int] = {
    val res = Array.fill(arr.length)(0)
    res(arr.length - 1) = -1
    (0 to arr.length - 2).reverse.foreach(i => res(i) = res(i + 1).max(arr(i + 1)))
    res
  }
}
