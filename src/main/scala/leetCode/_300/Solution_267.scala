package leetCode._300

import scala.collection.mutable

object Solution_267 {
  def generatePalindromes(s: String): List[String] = {
    var set = mutable.HashSet.empty[String]
    val m = Array.fill(128)(0)
    val st = new Array[Char](s.length / 2)

    def vis(s: String, arr: Array[Int]): Boolean = {
      var cnt = 0
      s.indices.foreach(i => {
        arr(s(i)) += 1
        if (arr(s(i)) % 2 == 0) cnt -= 1 else cnt += 1
      })
      cnt <= 1
    }

    def swap(s: Array[Char], i: Int, j: Int): Unit = {
      val t = s(i)
      s(i) = s(j)
      s(j) = t
    }

    def permute(s: Array[Char], l: Int, ch: Char): Unit = {
      if (l == s.length)
        set += (s.mkString + (if (ch == '0') "" else ch) + s.mkString.reverse)
      else {
        (l until s.length).foreach(i => {
          if (s(l) != s(i) || l == i) {
            swap(s, l, i)
            permute(s, l + 1, ch)
            swap(s, l, i)
          }
        })
      }
    }

    if (!vis(s, m)) return Nil
    var ch = '0'
    var k = 0
    m.indices.foreach(i => {
      if (m(i) % 2 == 1) ch = i.toChar
      (0 until m(i) / 2).foreach(_ => {
        st(k) = i.toChar
        k += 1
      })
    })
    permute(st, 0, ch)
    set.toList
  }
}
