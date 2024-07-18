package leetCode._2500

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

object Solution_2467 {
  def mostProfitablePath(edges: Array[Array[Int]], bob: Int, amount: Array[Int]): Int = {
    val n = amount.length

    val buffer = Array.fill[ListBuffer[Int]](n)(ListBuffer.empty)
    edges.foreach(edge => {
      val x = edge.head
      val y = edge(1)
      buffer(x).append(y)
      buffer(y).append(x)
    })

    val level = Array.ofDim[Int](n)
    val q = mutable.Queue.empty[Int]
    q += 0
    while (q.nonEmpty) {
      val a = q.dequeue()
      buffer(a).foreach(b => if (b != 0 && level(b) == 0) {
        q += b
        level(b) = level(a) + 1
      })
    }

    val bobTime = Array.fill[Int](n)(-1)
    bobTime(bob) = 0
    var bobNode = bob
    val breakLoop = false
    while (bobNode != 0 && !breakLoop) {
      breakable {
        buffer(bobNode).foreach(a => if (level(a) < level(bobNode)) {
          bobTime(a) = bobTime(bobNode) + 1
          bobNode = a
          break()
        })
      }
    }

    var res = Int.MinValue
    val count = Array.ofDim[Int](n)
    q += 0
    count(0) = amount(0)
    while (q.nonEmpty) {
      val a = q.dequeue()
      var has = false
      buffer(a).foreach(b => if (level(b) > level(a)) {
        has = true
        count(b) = {
          if (level(b) == bobTime(b)) count(a) + amount(b) / 2
          else if (level(b) < bobTime(b) || bobTime(b) == -1) count(a) + amount(b)
          else count(a)
        }
        q += b
      })
      if (a > 0 && !has) res = res.max(count(a))
    }

    res
  }
}
