package leetCode._2000

import scala.collection.mutable

object Solution_1916 {
  private val M = (1e9 + 7).toInt

  def waysToBuildRooms(prevRoom: Array[Int]): Int = {
    val g = Array.fill(prevRoom.length)(mutable.ArrayBuffer.empty[Int])
    prevRoom.indices.drop(1).foreach(i => g(prevRoom(i)).append(i))

    val subTreeCount = Array.fill(prevRoom.length)(-1)

    def getSubTreeCount(): Unit = {
      val stack = mutable.Stack[Int]()
      val visited = Array.fill(prevRoom.length)(false)

      g.indices.foreach(i => stack.push(i))

      while (stack.nonEmpty) {
        val current = stack.pop()
        if (!visited(current)) {
          visited(current) = true
          stack.push(current)
          g(current).foreach(next => if (!visited(next)) stack.push(next))
        } else if (subTreeCount(current) == -1) {
          val total = 1 + g(current).map(subTreeCount).sum
          subTreeCount(current) = total
        }
      }
    }

    getSubTreeCount()

    var res = 1L
    prevRoom.indices.drop(1).foreach(i => res = (res * i) % M)
    val nF = Array.fill(prevRoom.length)(0L)
    prevRoom.indices.drop(1).foreach(i => nF(i) = pow(i, M - 2))
    prevRoom.indices.drop(1).foreach(i => res = (res * nF(subTreeCount(i))) % M)

    res.toInt
  }

  private def pow(a: Long, b: Int): Long = {
    @scala.annotation.tailrec
    def loop(a: Long, b: Int, res: Long): Long =
      if (b == 0) res
      else if ((b & 1) > 0) loop((a * a) % M, b / 2, (res * a) % M)
      else loop((a * a) % M, b / 2, res)

    loop(a, b, 1)
  }
}
