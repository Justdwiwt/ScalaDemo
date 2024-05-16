package leetCode._3000

object Solution_2983 {
  def canMakePalindromeQueries(S: String, queries: Array[Array[Int]]): Array[Boolean] = {
    val ch = S.toCharArray
    val m = ch.length
    val n = m / 2

    val sumS = (0 until n).foldLeft(Array.fill(n + 1, 26)(0))((acc, i) => {
      val updated = acc(i).clone()
      updated(ch(i) - 'a') += 1
      acc.updated(i + 1, updated)
    })

    val sumT = (0 until n).foldLeft(Array.fill(n + 1, 26)(0))((acc, i) => {
      val updated = acc(i).clone()
      updated(ch(m - 1 - i) - 'a') += 1
      acc.updated(i + 1, updated)
    })

    val sumNe = (0 until n).foldLeft(Array.fill(n + 1)(0))((acc, i) => acc.updated(i + 1, acc(i) + (if (ch(i) != ch(m - 1 - i)) 1 else 0)))

    def count(sum: Array[Array[Int]], l: Int, r: Int): Array[Int] = {
      val res = sum(r + 1).clone()
      (0 until 26).foreach(i => res(i) -= sum(l)(i))
      res
    }

    def subtract(s1: Array[Int], s2: Array[Int]): Option[Array[Int]] = {
      val res = s1.zip(s2).map { case (a, b) => a - b }
      if (res.exists(_ < 0)) None else Some(res)
    }

    def check(l1: Int, r1: Int, l2: Int, r2: Int, sumS: Array[Array[Int]], sumT: Array[Array[Int]], sumNe: Array[Int]): Boolean = {
      if (sumNe(l1) > 0 || sumNe.last - sumNe(r1.max(r2) + 1) > 0) return false
      if (r2 <= r1) return count(sumS, l1, r1).sameElements(count(sumT, l1, r1))
      if (r1 < l2) return sumNe(l2) - sumNe(r1 + 1) <= 0 &&
        count(sumS, l1, r1).sameElements(count(sumT, l1, r1)) &&
        count(sumS, l2, r2).sameElements(count(sumT, l2, r2))

      val s1Opt = subtract(count(sumS, l1, r1), count(sumT, l1, l2 - 1))
      val s2Opt = subtract(count(sumT, l2, r2), count(sumS, r1 + 1, r2))

      (s1Opt, s2Opt) match {
        case (Some(s1), Some(s2)) => s1.sameElements(s2)
        case _ => false
      }
    }

    queries.indices.map(i => {
      val q = queries(i)
      val (l1, r1, l2, r2) = (q.head, q(1), m - 1 - q(3), m - 1 - q(2))
      if (l1 <= l2) check(l1, r1, l2, r2, sumS, sumT, sumNe)
      else check(l2, r2, l1, r1, sumT, sumS, sumNe)
    }).toArray
  }
}
