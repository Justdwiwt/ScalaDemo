package leetCode._3600

import scala.collection.immutable.TreeSet

object Solution_3590 {
  def kthSmallest(par: Array[Int], vals: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val n = par.length
    val tree = Array.fill[List[Int]](n)(Nil)

    par.indices.drop(1).foreach(i => tree(par(i)) = i :: tree(par(i)))

    val qs = Array.fill[List[(Int, Int)]](n)(Nil)
    queries
      .zipWithIndex
      .withFilter { case (Array(_, _), _) => true; case _ => false }
      .foreach { case (Array(x, k), i) => qs(x) = (k, i) :: qs(x) }

    val res = Array.fill(queries.length)(-1)

    def dfs(x: Int, xor: Int): TreeSet[Int] = {
      val currentXor = xor ^ vals(x)
      var st = TreeSet(currentXor)

      tree(x).foreach(y => {
        val setY = dfs(y, currentXor)
        if (setY.size > st.size) {
          val tmp = st
          st = setY
          tmp.foreach(st += _)
        } else setY.foreach(st += _)
      })

      qs(x).foreach { case (k, idx) => if (k - 1 < st.size) res(idx) = st.iterator.drop(k - 1).next() }

      st
    }

    dfs(0, 0)
    res
  }
}
