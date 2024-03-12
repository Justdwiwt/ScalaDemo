package leetCode.offer

import scala.collection.mutable

object Offer_13 {
  def movingCount(m: Int, n: Int, k: Int): Int = {
    var res = 0
    val q = new mutable.Queue[(Int, Int)]()
    val visit = Array.fill(m, n)(0)
    val dir = Array(Array(-1, 0), Array(1, 0), Array(0, 1), Array(0, -1))
    var t = (0, 0)
    visit(0)(0) = 1
    q.enqueue(t)
    while (q.nonEmpty) {
      var tx = 0
      var ty = 0
      t = q.front
      q.dequeue()
      res += 1
      (0 until 4).foreach(i => {
        tx = t._1 + dir(i)(0)
        ty = t._2 + dir(i)(1)
        if (tx >= 0 && tx < m && ty >= 0 && ty < n && check(tx, ty, k) && visit(tx)(ty) == 0) {
          q.enqueue((tx, ty))
          visit(tx)(ty) = 1
        }
      })
    }
    res
  }

  def check(_i: Int, _j: Int, _k: Int): Boolean = {
    var sum = 0
    var i = _i
    var j = _j
    while (i != 0) {
      sum += i % 10
      i /= 10
    }
    while (j != 0) {
      sum += j % 10
      j /= 10
    }
    sum <= _k
  }
}
