package leetCode._2100

object Solution_2071 {
  def maxTaskAssign(tasks: Array[Int], workers: Array[Int], pills: Int, strength: Int): Int = {
    val sortedTasks = tasks.sorted
    val sortedWorkers = workers.sorted

    def check(k: Int): Boolean = {
      val selectedTasks = sortedTasks.take(k).toVector
      val selectedWorkers = sortedWorkers.takeRight(k).toVector

      @scala.annotation.tailrec
      def loop(i: Int, p: Int, q: Vector[Int], w: List[Int]): Boolean = w match {
        case Nil => true
        case worker :: rest =>
          val (newQ, newI) = {
            var j = i
            var nq = q
            while (j < k && selectedTasks(j) <= worker + strength) {
              nq = nq :+ selectedTasks(j)
              j += 1
            }
            (nq, j)
          }

          if (newQ.isEmpty) false
          else if (worker >= newQ.head) loop(newI, p, newQ.tail, rest)
          else if (p > 0) loop(newI, p - 1, newQ.init, rest)
          else false
      }

      loop(0, pills, Vector.empty, selectedWorkers.toList)
    }

    var l = 0
    var r = tasks.length.min(workers.length)
    var res = 0
    while (l <= r) {
      val mid = (l + r) / 2
      if (check(mid)) {
        res = mid
        l = mid + 1
      } else r = mid - 1
    }
    res
  }
}
