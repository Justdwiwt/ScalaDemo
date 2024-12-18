package leetCode._3400

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_3382 {
  def maxRectangleArea(xCoord: Array[Int], yCoord: Array[Int]): Long = {
    def add(i: Int, x: Int, t: mutable.Map[Int, BigInt], ma: Int): Unit = {
      var idx = i
      while (idx < ma) {
        t.update(idx, t.getOrElse(idx, BigInt(0)) + x)
        idx += idx & -idx
      }
    }

    def get(i: Int, t: mutable.Map[Int, BigInt]): BigInt = {
      var res = BigInt(0)
      var idx = i
      while (idx > 0) {
        res += t.getOrElse(idx, BigInt(0))
        idx &= idx - 1
      }
      res
    }

    val d = mutable.Map[Int, ListBuffer[Int]]()
    xCoord.indices.foreach(i => d.getOrElseUpdate(xCoord(i), ListBuffer()) += yCoord(i))
    val ma = yCoord.max + 2
    val t = mutable.Map[Int, BigInt]()
    var res: BigInt = BigInt(-1)
    val f = mutable.Map[(Int, Int), (Int, BigInt)]()
    d.keys.toList.sorted.foreach(x => {
      val A = d(x).sorted
      (1 until A.size).foreach(i => {
        val a = A(i - 1)
        val b = A(i)
        val s = get(b + 1, t) - get(a, t)
        if (f.contains((a, b))) {
          val (x2, s2) = f((a, b))
          if (s - s2 == 2) res = res.max(BigInt(b - a) * BigInt(x - x2))
        }
        f((a, b)) = (x, s)
      })
      A.foreach(a => add(a + 1, 1, t, ma))
    })
    if (res < 0) -1 else res.toLong
  }
}
