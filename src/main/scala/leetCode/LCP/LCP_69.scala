package leetCode.LCP

import scala.collection.mutable

object LCP_69 {
  var map = Map.empty[Char, Array[Int]]
  var dp: Array[Array[Int]] = _
  var len: Int = _
  var costs = List.empty[Map[Int, Int]]

  def Leetcode(words: Array[String]): Int = {
    len = words.length
    map = Map(
      'c' -> Array(10, 1, 1),
      'd' -> Array(9, 1, 1),
      'e' -> Array(0, 4, 7),
      'h' -> Array(8, 1, 1),
      'l' -> Array(3, 3, 3),
      'o' -> Array(5, 2, 3),
      't' -> Array(7, 1, 1)
    )

    costs = words.map(word => {
      val hp = mutable.Map.empty[Int, Int]
      dfs(hp, word, 0, 0)
      hp.toMap
    }).toList

    dp = Array.fill(len, 1 << 11)(-1)
    val res = dfs2(0, 0)
    if (res == 0x3f3f3f3f) -1 else res
  }

  private def dfs(hp: mutable.Map[Int, Int], str: String, mask: Int, tot: Int): Unit = {
    if (!hp.contains(mask) || hp(mask) > tot) hp(mask) = tot
    if (str.isEmpty) return
    val n = str.length

    str
      .indices
      .withFilter(i => map.contains(str.charAt(i)))
      .map { i => val pnm = map(str.charAt(i)); (i, pnm) }
      .map { case (i, pnm) => val cnt = (mask >> pnm(0)) & pnm(2); (i, pnm, cnt) }
      .withFilter { case (_, pnm, cnt) => cnt < pnm(1) }
      .foreach { case (i, pnm, _) => dfs(hp, str.substring(0, i) + str.substring(i + 1, n), mask + (1 << pnm(0)), tot + i * (n - i - 1)) }
  }

  private def merge(mask: Int, add: Int): Int = {
    val newMask = map.values.foldLeft((mask, true)) { case ((accMask, valid), pnm) =>
      if (!valid) (accMask, valid)
      else {
        val c1 = (accMask >> pnm(0)) & pnm(2)
        val c2 = (add >> pnm(0)) & pnm(2)
        if (c1 + c2 > pnm(1)) (accMask, false)
        else (accMask + (c2 << pnm(0)), valid)
      }
    }
    if (newMask._2) newMask._1 else -1
  }

  private def dfs2(wi: Int, mask: Int): Int =
    if (wi == len)
      if (mask == 2012) 0
      else 0x3f3f3f3f
    else {
      if (dp(wi)(mask) != -1) dp(wi)(mask)
      else {
        val res = costs(wi).foldLeft(0x3f3f3f3f) { case (acc, (key, value)) =>
          val m = merge(mask, key)
          if (m >= 0) acc.min(dfs2(wi + 1, m) + value) else acc
        }
        dp(wi)(mask) = res
        res
      }
    }
}
