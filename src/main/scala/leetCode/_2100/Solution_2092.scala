package leetCode._2100

import scala.collection.mutable

object Solution_2092 {
  def findAllPeople(n: Int, meetings: Array[Array[Int]], firstPerson: Int): List[Int] = {
    val arr = Array.fill(n)(-1)
    val tm = mutable.TreeMap.empty[Int, mutable.ListBuffer[Array[Int]]]

    def getF(a: Int): Int = {
      if (arr(a) == -1) a
      else {
        arr(a) = getF(arr(a))
        arr(a)
      }
    }

    def union(a: Int, b: Int): Unit = {
      val fa = getF(a)
      val fb = getF(b)
      if (fa != fb) {
        if (fa < fb) arr(fb) = fa
        else arr(fa) = fb
      }
    }

    val res = mutable.ListBuffer.empty[Int]

    res += 0
    res += firstPerson
    union(0, firstPerson)

    meetings.foreach(m => tm.getOrElseUpdate(m(2), mutable.ListBuffer[Array[Int]]()) += m)

    tm.values.foreach(ms => {
      ms
        .withFilter({ case Array(_, _, _) => true; case _ => false })
        .foreach({ case Array(a, b, _) => union(a, b) })

      ms
        .withFilter({ case Array(_, _, _) => true; case _ => false })
        .foreach({ case Array(a, b, _) => if (getF(a) == 0 || getF(b) == 0) {
          res += a
          res += b
        } else {
          arr(a) = -1
          arr(b) = -1
        }
        })
    })
    res.distinct.toList
  }
}
