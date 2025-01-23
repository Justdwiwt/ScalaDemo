package leetCode._3000

import scala.collection.mutable

object Solution_2920 {
  def maximumPoints(edges: Array[Array[Int]], coins: Array[Int], k: Int): Int = {
    val n = coins.length
    val g = Array.fill(n)(List.empty[Int])
    edges.foreach(e => {
      val x = e.head
      val y = e(1)
      g(x) = y :: g(x)
      g(y) = x :: g(y)
    })

    val memo = mutable.Map[(Int, Int), Int]()
    val stack = mutable.Stack[(Int, Int, Int)]()

    stack.push((0, 0, -1))

    while (stack.nonEmpty) {
      val (i, j, fa) = stack.pop()

      if (!memo.contains((i, j))) {
        var res1 = (coins(i) >> j) - k
        var res2 = coins(i) >> (j + 1)
        var allChildrenCalculated = true

        g(i).foreach(ch => if (ch != fa) {
          if (!memo.contains((ch, j))) {
            stack.push((i, j, fa))
            stack.push((ch, j, i))
            allChildrenCalculated = false
          }
          if (j < 13 && !memo.contains((ch, j + 1))) {
            stack.push((i, j, fa))
            stack.push((ch, j + 1, i))
            allChildrenCalculated = false
          }

          if (memo.contains((ch, j))) res1 += memo((ch, j))
          if (j < 13 && memo.contains((ch, j + 1))) res2 += memo((ch, j + 1))
        })

        if (allChildrenCalculated) memo((i, j)) = res1.max(res2)
      }
    }

    memo((0, 0))
  }
}
