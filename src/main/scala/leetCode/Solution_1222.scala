package leetCode

import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

object Solution_1222 {

  private val N = 8

  def queensAttacktheKing(queens: Array[Array[Int]], king: Array[Int]): List[List[Int]] = {
    var res = List[List[Int]]()
    val Q = ListBuffer.fill(N, N)(0)
    queens.foreach(i => Q(i.head)(i(1)) = 1)
    val dr = Array(1, 1, 0, -1, -1, -1, 0, 1)
    val dc = Array(0, 1, 1, 1, 0, -1, -1, -1)
    (0 until N).foreach(i => {
      var r = king(0)
      var c = king(1)
      breakable {
        while (flag(r, c)) {
          if (Q(r)(c) > 0) {
            res :+= List(r, c)
            break
          }
          r += dr(i)
          c += dc(i)
        }
      }
    })
    res
  }

  def flag(r: Int, c: Int): Boolean = 0 <= r && r < N && 0 <= c && c < N

}
