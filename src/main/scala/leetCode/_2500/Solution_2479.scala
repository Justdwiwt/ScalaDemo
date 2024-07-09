package leetCode._2500

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._

object Solution_2479 {

  class TrieNode {
    var isEnd: Boolean = false
    val son: Array[TrieNode] = Array.fill(2)(null)
  }

  object Solution {
    private type Trie = TrieNode

    def maxXor(n: Int, edges: Array[Array[Int]], values: Array[Int]): Long = {
      val g = Array.fill(n)(new ArrayBuffer[Int]())
      edges.foreach(e => {
        val a = e(0)
        val b = e(1)
        g(a).append(b)
        g(b).append(a)
      })

      val f = Array.fill(n)(0L)
      val son = Array.fill(n)(0)

      def check(u: Int, fa: Int): Unit = {
        f(u) += values(u)
        for (ne <- g(u)) {
          if (ne != fa) {
            check(ne, u)
            f(u) += f(ne)
            son(u) += 1
          }
        }
      }

      check(0, -1)
      var ok = true
      (0 until n).foreach(i => if (son(i) > 1) ok = false)
      if (ok) return 0

      var ans = 0L
      val root = new Trie

      def insert(x: Long): Unit = {
        var p = root
        for (i <- 45 to 0 by -1) {
          val c = (x >> i & 1).toInt
          if (p.son(c) == null) p.son(c) = new Trie
          p = p.son(c)
        }
        p.isEnd = true
      }

      def query(x: Long): Long = {
        var res = 0L
        var p = root
        breakable {
          (45 to 0 by -1).foreach(i => {
            val c = (x >> i & 1).toInt
            if (p.son(1 - c) != null) {
              res += 1L << i
              p = p.son(1 - c)
            } else if (p.son(c) != null) p = p.son(c)
            else {
              res = -1
              break()
            }
          })
        }
        res
      }

      def dfs(u: Int, fa: Int): Unit = {
        val t = query(f(u))
        ans = math.max(ans, t)
        g(u).foreach(ne => if (ne != fa) dfs(ne, u))
        insert(f(u))
      }

      dfs(0, -1)
      ans
    }
  }
}
