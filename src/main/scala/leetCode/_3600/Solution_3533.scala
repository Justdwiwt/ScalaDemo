package leetCode._3600

object Solution_3533 {
  def concatenatedDivisibility(nums: Array[Int], k: Int): Array[Int] = {
    val sorted = nums.sorted
    val pow10 = sorted.map(x => BigInt(10).pow(x.toString.length).toInt)
    val n = sorted.length
    val fullMask = (1 << n) - 1

    def dfs(
             s: Int,
             mod: Int,
             memo: Map[(Int, Int), Option[List[Int]]]
           ): (Map[(Int, Int), Option[List[Int]]], Option[List[Int]]) = {
      if (s == 0) return (memo, if (mod == 0) Some(Nil) else None)
      if (memo.contains((s, mod))) return (memo, memo((s, mod)))

      val (updatedMemo, result) = sorted.indices.foldLeft((memo, Option.empty[List[Int]])) {
        case ((m, res@Some(_)), _) => (m, res)
        case ((m, None), i) =>
          if ((s & (1 << i)) != 0) {
            val nextS = s ^ (1 << i)
            val nextMod = (mod * pow10(i) + sorted(i)) % k
            val (m2, subRes) = dfs(nextS, nextMod, m)
            subRes match {
              case Some(path) => (m2 + ((s, mod) -> Some(sorted(i) :: path)), Some(sorted(i) :: path))
              case None => (m2 + ((s, mod) -> None), None)
            }
          } else (m, None)
      }

      (updatedMemo, result)
    }

    dfs(fullMask, 0, Map.empty)._2.map(_.toArray).getOrElse(Array())
  }
}
