package leetCode._3100

import scala.collection.mutable

object Solution_3003 {
  // fixme: when test case 270+: stackoverflow
  def maxPartitionsAfterOperations(s: String, k: Int): Int = {
    val memo = mutable.HashMap.empty[Long, Int]

    def dfs(i: Int, mask: Int, changed: Int, s: Array[Char], k: Int): Int = {
      if (i == s.length) return 1
      val argsMask: Long = (i.toLong << 32) | (mask.toLong << 1) | changed
      if (memo.contains(argsMask)) return memo(argsMask)
      var res: Int = 0
      val bit: Int = 1 << (s(i) - 'a')
      val newMask: Int = mask | bit
      if (Integer.bitCount(newMask) > k) res = dfs(i + 1, bit, changed, s, k) + 1
      else res = dfs(i + 1, newMask, changed, s, k)

      if (changed == 0) {
        (0 until 26).foreach(j => {
          val newMask: Int = mask | (1 << j)
          if (Integer.bitCount(newMask) > k) res = res.max(dfs(i + 1, 1 << j, 1, s, k) + 1)
          else res = res.max(dfs(i + 1, newMask, 1, s, k))
        })
      }

      memo.put(argsMask, res)
      res
    }

    dfs(0, 0, 0, s.toCharArray, k)
  }
}
