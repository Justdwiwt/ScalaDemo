package leetCode._2500

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

object Solution_2440 {
  def componentValue(nums: Array[Int], edges: Array[Array[Int]]): Int = {
    val n = nums.length
    if (n == 1) return 0

    val v = Array.fill(n)(false)
    val map = edges.foldLeft(mutable.Map[Int, ListBuffer[Int]]()) {
      case (m, Array(a, b)) =>
        m.getOrElseUpdate(a, ListBuffer()) += b
        m.getOrElseUpdate(b, ListBuffer()) += a
        m
    }

    val sum = nums.sum
    val min = nums.min
    val list = (min to math.sqrt(sum).toInt).flatMap(i => if (sum % i == 0) Seq(i, sum / i) else Seq()).sorted

    val level = buildLevels(map, n, v)

    var res = 0
    breakable {
      list.foreach(x => {
        val w = nums.clone()
        var flag = false
        var t = 0
        breakable {
          level.reverse.foreach(l => {
            l.foreach { case Array(c, p) =>
              if (w(c) > x) {
                flag = true
                break
              } else if (w(c) == x) t += 1 else w(p) += w(c)
            }
            if (flag) break
          })
        }
        if (!flag) {
          res = res.max(t)
          if (res > 0) break
        }
      })
    }
    res
  }

  def buildLevels(map: mutable.Map[Int, ListBuffer[Int]], n: Int, v: Array[Boolean]): ListBuffer[ListBuffer[Array[Int]]] = {
    val level = ListBuffer.empty[ListBuffer[Array[Int]]]
    val zero = ListBuffer(Array(0, 0))
    val que = mutable.Queue(0)

    while (que.nonEmpty) {
      val tmp = ListBuffer.empty[Array[Int]]
      que.indices.foreach(_ => {
        val p = que.dequeue()
        v(p) = true
        map(p).foreach(x => if (!v(x)) {
          tmp += Array(x, p)
          que += x
        })
      })
      if (tmp.nonEmpty) level += tmp
    }
    level
  }
}
