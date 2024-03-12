package leetCode._2500

object Solution_2435 {
  def numberOfPaths(grid: Array[Array[Int]], k: Int): Int = {
    val dp = Array.fill(grid.length)(new Array[Array[Int]](grid.head.length))
    dp(0)(0) = init(k, grid(0)(0))
    grid.head.indices.tail.foreach(j => dp.head(j) = shift(dp.head(j - 1), grid.head(j) % k))
    grid.indices.tail.foreach(i => {
      dp(i)(0) = shift(dp(i - 1)(0), grid(i)(0) % k)
      grid(i).indices.tail.foreach(j => dp(i)(j) = shift(combine(dp(i - 1)(j), dp(i)(j - 1)), grid(i)(j) % k))
    })
    dp.last.last.head
  }

  def combine(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
    val nArr = Array.fill(arr1.length)(0)
    nArr.indices.foreach(i => nArr(i) = (arr1(i) + arr2(i)) % 1000000007)
    nArr
  }

  def init(k: Int, value: Int): Array[Int] = {
    val nArr = Array.fill(k)(0)
    nArr(value % k) = 1
    nArr
  }

  def shift(arr: Array[Int], k: Int): Array[Int] = {
    val nArr = Array.fill(arr.length)(0)
    nArr.indices.foreach(i => nArr((i + k) % arr.length) = arr(i))
    nArr
  }
}
