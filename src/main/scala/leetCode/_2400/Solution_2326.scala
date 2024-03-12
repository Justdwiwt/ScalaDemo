package leetCode._2400

import leetCode.ListNode

object Solution_2326 {
  def spiralMatrix(m: Int, n: Int, head: ListNode): Array[Array[Int]] = {
    val arr = Array.fill(m, n)(-1)
    val diff = Array(0, 1, 0, -1, 0)

    @scala.annotation.tailrec
    def f(x: Int, y: Int, d: Int, cur: ListNode): Unit = {
      if (cur == null) return
      arr(x)(y) = cur.x
      val (nx, ny) = (x + diff(d), y + diff(d + 1))
      if (nx >= 0 && ny >= 0 && nx < m && ny < n && arr(nx)(ny) == -1)
        f(nx, ny, d, cur.next)
      else {
        val nd = (d + 1) % 4
        f(x + diff(nd), y + diff(nd + 1), nd, cur.next)
      }
    }

    f(x = 0, y = 0, d = 0, cur = head)
    arr
  }
}
