package leetCode._2200

import scala.collection.mutable

object Solution_2101 {
  class DSU(val l: Int) {
    val arr: Array[Int] = Array.fill(l)(0)
    (0 until l).foreach(i => arr(i) = i)

    def find(x: Int): Int = {
      if (arr(x) == x) return x
      arr(x) = find(arr(x))
      arr(x)
    }

    def union(x: Int, y: Int): Unit = {
      val x_ = find(x)
      val y_ = find(y)
      arr(x_) = y_
    }
  }

  def f(bombs: Array[Array[Int]]): Int = {
    val dsu = new DSU(bombs.length)

    def cal(a: Array[Int], b: Array[Int]): Boolean = {
      val dis2 = (a.head - b.head) * 1L * (a.head - b.head) + (a(1) - b(1)) * 1L * (a(1) - b(1))
      if (dis2 <= a(2) * 1L * a(2) || dis2 <= b(2) * 1L * b(2)) true
      else false
    }

    bombs.indices.foreach(i => (i + 1 until bombs.length).foreach(j => if (cal(bombs(i), bombs(j))) dsu.union(i, j)))
    val m = mutable.HashMap.empty[Int, Int]
    bombs.indices.foreach(i => {
      val t = dsu.find(i)
      m(t) = m.getOrElse(t, 0) + 1
    })
    var res = 0
    m.foreach({ case (_, v) => res = res.max(v) })
    res
  }

  def maximumDetonation(bombs: Array[Array[Int]]): Int = {
    val arr = Array.fill(bombs.length)(false)

    def cal(a: Array[Int], b: Array[Int]): Boolean = {
      val dis2 = (a.head - b.head) * 1L * (a.head - b.head) + (a(1) - b(1)) * 1L * (a(1) - b(1))
      if (dis2 <= a(2) * 1L * a(2)) true
      else false
    }

    def g(b: Int): Int = {
      if (arr(b)) return 0
      arr(b) = true
      var res = 1
      bombs.indices.foreach(i => if (cal(bombs(b), bombs(i))) res += g(i))
      res
    }

    var mx = 0
    bombs.indices.foreach(i => {
      bombs.indices.foreach(j => arr(j) = false)
      mx = mx.max(g(i))
    })
    mx
  }
}
