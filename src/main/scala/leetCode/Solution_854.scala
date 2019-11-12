package leetCode

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._

object Solution_854 {
  def kSimilarity(A: String, B: String): Int = {
    val a = new StringBuilder
    val b = new StringBuilder
    var res = a.length - 1
    a.append(A)
    b.append(B)
    a.indices.foreach(i => {
      breakable {
        if (a(i) == b(i)) break
      }
      var matches = new ArrayBuffer[Int]()
      ((i + 1) until a.length).foreach(j => {
        breakable {
          if (a(j) == b(j) || a(j) != b(i)) break
        }
        matches += j
        breakable {
          if (a(i) != b(j)) break
        }
        val t = a(i)
        a(i) = a(j)
        a(j) = t

        return 1 + kSimilarity(a.substring(i + 1), b.substring(i + 1))
      })
      matches.foreach(j => {
        val t = a(i)
        a(i) = a(j)
        a(j) = t
        res = res.min(1 + kSimilarity(a.substring(i + 1), b.substring(i + 1)))
        val v = a(i)
        a(i) = a(j)
        a(j) = v
      })
      return res
    })
    0
  }
}
