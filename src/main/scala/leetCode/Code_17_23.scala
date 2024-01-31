package leetCode

object Code_17_23 {
  def findSquare(matrix: Array[Array[Int]]): Array[Int] = {
    val n = matrix.length
    val left = Array.fill(n + 1, n + 1)(0)
    val up = Array.fill(n + 1, n + 1)(0)
    var r, c, size = 0
    (1 to n).foreach(i => {
      (1 to n).foreach(j => {
        if (matrix(i - 1)(j - 1) == 0) {
          left(i)(j) = left(i)(j - 1) + 1
          up(i)(j) = up(i - 1)(j) + 1
          var border = left(i)(j).min(up(i)(j))
          while (left(i - border + 1)(j) < border || up(i)(j - border + 1) < border) border -= 1
          if (border > size) {
            r = i - border
            c = j - border
            size = border
          }
        }
      })
    })
    if (matrix.head.head == 1 && matrix.length == 1) return Array.empty
    if (size > 0) Array(r, c, size) else Array(0)
  }
}
