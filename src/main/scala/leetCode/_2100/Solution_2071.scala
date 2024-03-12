package leetCode._2100

import scala.collection.mutable

object Solution_2071 {
  //  def maxTaskAssign(tasks: Array[Int], workers: Array[Int], pills: Int, strength: Int): Int = {
  //    tasks.sortInPlace()
  //    workers.sortInPlace()
  //
  //    def can(n: Int): Boolean = {
  //      val ts = tasks.take(n).to(mutable.Stack)
  //      val ws = workers.drop(workers.length - n)
  //      val tl = mutable.ArrayDeque.empty[Int]
  //      var left = pills
  //      ws.foreach(w => {
  //        if (tl.isEmpty) tl.append(ts.pop())
  //        if (w >= tl.head) tl.removeHead()
  //        else {
  //          if (left == 0) return false
  //          while (ts.nonEmpty && ts.head <= w + strength) {
  //            tl.append(ts.pop())
  //          }
  //          if (tl.last > w + strength) return false
  //          tl.removeLast()
  //          left -= 1
  //        }
  //      })
  //      true
  //    }
  //
  //    var lo = 0
  //    var hi = tasks.length.min(workers.length)
  //    while (lo != hi) {
  //      val mid = (lo + hi + 1) / 2
  //      if (can(mid)) lo = mid
  //      else hi = mid - 1
  //    }
  //    lo
  //  }
}
