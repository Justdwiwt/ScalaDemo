package leetCode

object Solution_2033 {
  def minOperations(grid: Array[Array[Int]], x: Int): Int = {
    val sorted = grid.flatten.sorted
    val med = sorted(sorted.length / 2)
    sorted./:(0)((cnt, v) => {
      if ((v - med) % x != 0) return -1
      cnt + (v - med).abs / x
    })
  }
}
