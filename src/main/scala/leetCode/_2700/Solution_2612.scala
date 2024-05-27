package leetCode._2700

import scala.collection.mutable

object Solution_2612 {
  def minReverseOperations(n: Int, p: Int, banned: Array[Int], k: Int): Array[Int] = {
    val dp = Array.fill(n)(-1)
    dp(p) = 0
    val ban = Array.fill(n)(false)
    banned.foreach(ban(_) = true)
    ban(p) = true

    val oddRemain = mutable.TreeSet.empty[Int]
    val evenRemain = mutable.TreeSet.empty[Int]
    (0 until n).foreach(i => if (!ban(i)) if (i % 2 == 0) evenRemain.add(i) else oddRemain.add(i))

    val queue = new mutable.Queue[Int]()
    queue.enqueue(p)

    while (queue.nonEmpty) {
      val i = queue.dequeue()
      val start = 2 * math.max(0, i - k + 1) + k - 1 - i
      val end = 2 * math.min(n - k, i) + k - 1 - i
      val curSet = if (start % 2 == 0) evenRemain else oddRemain
      var next = curSet.from(start).headOption
      while (next.isDefined && next.get <= end) {
        curSet -= next.get
        dp(next.get) = dp(i) + 1
        queue.enqueue(next.get)
        next = curSet.from(start).headOption
      }
    }
    dp
  }
}
