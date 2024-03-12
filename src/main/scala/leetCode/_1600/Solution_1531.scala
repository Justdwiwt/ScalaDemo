package leetCode._1600

import scala.collection.mutable

object Solution_1531 {
  def getLengthOfOptimalCompression(s: String, k: Int): Int = {
    def mem[K, V](f: K => V): mutable.Map[K, V] = new collection.mutable.HashMap[K, V] {
      override def apply(k: K): V = getOrElseUpdate(k, f(k))
    }

    lazy val dp: ((Int, Int, Int, Int)) => Int = mem {
      case (_, j, _, _) if j < 0 => 1e9.toInt
      case (i, _, _, _) if i == s.length => 0
      case (i, j, prev, cnt) if prev == s(i) => dp(i + 1, j, s(i), cnt + 1) + (if (Seq(1, 9, 99).contains(cnt)) 1 else 0)
      case (i, j, prev, cnt) => (dp(i + 1, j, s(i), 1) + 1).min(dp(i + 1, j - 1, prev, cnt))
    }
    dp(0, k, ' ', 1)
  }
}
