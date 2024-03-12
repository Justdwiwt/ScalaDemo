package leetCode._600

import scala.collection.mutable

object Solution_529 {
  def updateBoard(board: Array[Array[Char]], click: Array[Int]): Array[Array[Char]] = {
    if (board(click.head)(click(1)) == 'M') {
      board(click.head)(click(1)) = 'X'
      return board
    }

    val processed = mutable.Set.empty[(Int, Int)]

    def process(board: Array[Array[Char]], curr: (Int, Int)): Unit = {
      processed += curr
      val surroundings = getSurrounding(curr, board.length, board.head.length)
      val minesAround = surroundings./:(0)((acc, curr) => if (board(curr._1)(curr._2) == 'M') acc + 1 else acc)
      if (minesAround == 0) {
        board(curr._1)(curr._2) = 'B'
        surroundings.filterNot(processed.contains).foreach(process(board, _))
      }
      else board(curr._1)(curr._2) = minesAround.toString.head
    }

    process(board, (click.head, click(1)))
    board
  }

  def getSurrounding(cur: (Int, Int), rows: Int, cols: Int): Array[(Int, Int)] = {
    val res = mutable.ListBuffer.empty[(Int, Int)]
    (cur._1 - 1 to cur._1 + 1).foreach(x => (cur._2 - 1 to cur._2 + 1).foreach(y =>
      if (x >= 0 && x < rows && y >= 0 && y < cols && (x, y) != cur)
        res += (x -> y)
    ))
    res.toArray
  }
}
