package leetCode

import scala.collection.mutable

object Solution_1654 {
  def minimumJumps(forbidden: Array[Int], a: Int, b: Int, x: Int): Int = {
    if (x == 0) return 0
    if (x < 0) return -1
    if (x == a) return 1
    var step = 0
    val st = forbidden.toSet
    val limit = x + 6 * a.max(b)

    case class Data(idx: Int, forward: Boolean = true)

    val q = mutable.Queue[Data]()
    val visited = mutable.HashSet[Data]()
    q enqueue Data(0)
    while (q.nonEmpty) {
      val k = q.size
      (0 until k).foreach(_ => {
        val curr = q.dequeue()
        if (curr.idx == x) return step
        if (!visited.contains(curr)) {
          visited += curr
          if (!visited.contains(Data(curr.idx + a)) && curr.idx + a <= limit && !st.contains(curr.idx + a))
            q += Data(curr.idx + a)
          if (curr.forward && !visited.contains(Data(curr.idx - b, forward = false)) && curr.idx - b >= 0 && !st.contains(curr.idx - b))
            q += Data(curr.idx - b, forward = false)
        }
      })
      step += 1
    }
    -1
  }
}
