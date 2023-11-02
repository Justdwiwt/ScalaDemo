package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_2127 {
  def maximumInvitations(favorite: Array[Int]): Int = {
    val n = favorite.length
    val arr = Array.ofDim[Int](n)
    favorite.indices.foreach(i => arr(favorite(i)) += 1)

    val used = Array.fill(n)(false)
    val f = Array.fill(n)(1)

    val q = mutable.Queue.empty[Int]
    favorite.indices.foreach(i => if (arr(i) == 0) q += i)

    while (q.nonEmpty) {
      val u = q.dequeue()
      used(u) = true
      val v = favorite(u)
      f(v) = f(v).max(f(u) + 1)
      arr(v) -= 1
      if (arr(v) == 0) q += v
    }

    var ring = 0
    var total = 0

    favorite.indices.foreach(i => if (!used(i)) {
      val j = favorite(i)
      if (favorite(j) == i) {
        total += f(i) + f(j)
        used(i) = true
        used(j) = true
      }
      else {
        var u = i
        var cnt = 0
        breakable({
          while (true) {
            cnt += 1
            u = favorite(u)
            used(u) = true
            if (u == i) break
          }
        })
        ring = ring.max(cnt)
      }
    })
    ring.max(total)
  }
}
