package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_529 {
  def updateBoard(board: Array[Array[Char]], click: Array[Int]): Array[Array[Char]] = {
    if (board.isEmpty || board(0).isEmpty) return Array.empty
    val Q = new mutable.Queue[(Int, Int)]()
    Q.enqueue((click(0), click(1)))
    while (Q.nonEmpty) {
      val row = Q.front._1
      val col = Q.front._2
      var cnt = 0
      Q.dequeue
      var neighbor = Array.empty[(Int, Int)]
      if (board(row)(col) == 'M') board(row)(col) = 'X'
      else {
        (-1 until 2).foreach(i => (-1 until 2).foreach(j => {
          val x = row + i
          val y = col + j
          breakable {
            if (x < 0 || x >= board.length || y < 0 || y >= board(0).length) break
          }
          if (board(x)(y) == 'M') cnt += 1
          else if (cnt == 0 && board(x)(y) == 'E') neighbor :+= (x, y)
        }))
      }
      if (cnt > 0) board(row)(col) = (cnt + '0').toChar
      else neighbor.foreach(nei => {
        board(nei._1)(nei._2) = 'B'
        Q.enqueue(nei)
      })
    }
    board
  }
}
