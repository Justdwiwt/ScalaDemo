package leetCode

object Solution_957 {
  def prisonAfterNDays(cells: Array[Int], N: Int): Array[Int] = {
    val arr = Array.fill(8)(0)
    val a = N % 14
    var n = if (a == 0) 14 else a
    while (n > 0) {
      (1 until 7).foreach(i => {
        if ((cells(i - 1) ^ cells(i + 1)) == 0) arr(i) = 1
        else arr(i) = 0
      })
      (0 until 8).foreach(j => cells(j) = arr(j))
      n -= 1
    }
    cells
  }
}
