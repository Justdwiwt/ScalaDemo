package leetCode

import scala.collection.mutable

object Solution_1125 {
  def smallestSufficientTeam(A: Array[String], ll: List[List[String]]): Array[Int] = {
    def f(l: List[String]): Int = {
      var x = 0
      (A map l.contains).zipWithIndex.withFilter(y => y._1).foreach(y => x += 1 << y._2)
      x
    }

    def cond(x: Int)(y: Int): Boolean = (x & y) != 0 && (y & ~(x & y)) == 0

    def g(x: Int): List[Int] = (1 to x).toList.filter({ y => cond(x)(y) })

    val m = mutable.HashMap[Int, List[Int]]()
    val track = mutable.HashMap[Int, Int]()
    val path = mutable.HashMap[Int, (Int, Int)]()
    val l = ll.map(f)
    l.zipWithIndex.foreach({ case (x, i) => track += x -> i })
    l.foreach({ q => m += q -> g(q) })

    val dp = Array.fill(1 << A.length)(61)
    dp(0) = 0
    (1 until (1 << A.length)).foreach(i => {
      var mn = 61
      var tp = -1
      var tq = -1
      l.foreach(q => m(q).map({ k => val p = i & (~k); (k, p) }).foreach({ case (_, p) => if (dp(p) + 1 < mn) {
        mn = dp(p) + 1
        tq = p
        tp = q
      }
      }))

      if (mn < dp(i)) {
        dp(i) = mn
        path += i -> (tq, track(tp))
      }
    })

    @scala.annotation.tailrec
    def getPath(i: Int, acc: List[Int]): List[Int] = if (i == 0) acc else getPath(path(i)._1, path(i)._2 :: acc)

    getPath(dp.indices.last, Nil).toArray
  }
}
