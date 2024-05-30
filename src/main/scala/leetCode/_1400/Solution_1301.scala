package leetCode._1400

object Solution_1301 {
  def pathsWithMaxScore(board: List[String]): Array[Int] = {
    val row = board.size
    if (row == 0) return Array(0, 0)
    val M = 1000000007
    val col = board.head.length
    val dpScore = Array.ofDim[Int](row + 1, col + 1)
    val dpPath = Array.ofDim[Int](row + 1, col + 1)

    dpPath(row - 1)(col - 1) = 1

    val positions = board.indices.reverse.flatMap(i => board.head.indices.reverse.map((i, _)))

    positions.foreach {
      case (i, j) =>
        if (board(i)(j) != 'X' && (dpPath(i + 1)(j) != 0 || dpPath(i)(j + 1) != 0 || dpPath(i + 1)(j + 1) != 0)) {
          val maxScore = List(dpScore(i + 1)(j), dpScore(i)(j + 1), dpScore(i + 1)(j + 1)).max
          dpScore(i)(j) = maxScore + (if (board(i)(j) == 'S') 0 else board(i)(j) - '0')

          if (dpScore(i + 1)(j) == maxScore) dpPath(i)(j) = (dpPath(i)(j) + dpPath(i + 1)(j)) % M
          if (dpScore(i)(j + 1) == maxScore) dpPath(i)(j) = (dpPath(i)(j) + dpPath(i)(j + 1)) % M
          if (dpScore(i + 1)(j + 1) == maxScore) dpPath(i)(j) = (dpPath(i)(j) + dpPath(i + 1)(j + 1)) % M
        }
    }

    val maxScore = if (dpScore.head.head == 0) 0 else dpScore.head.head - ('E' - '0')
    Array(maxScore, dpPath.head.head)
  }
}
