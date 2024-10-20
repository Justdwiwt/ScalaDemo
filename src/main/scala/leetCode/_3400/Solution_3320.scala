package leetCode._3400

object Solution_3320 {
  private val M = 1000000007
  private val diff = Array.fill(128)(0)
  private val arr = Array.fill(500)(0)

  diff('F') = 0
  diff('W') = 1
  diff('E') = 2

  arr(0) = 1
  arr.indices.drop(1).foreach(i => arr(i) = (arr(i - 1) * 2) % M)

  def countWinningSequences(s: String): Int = {
    val n = s.length
    val memo = Array.fill(n, n * 2 + 1, 3)(-1)

    def dfs(i: Int, j: Int, ban: Int, s: Array[Char]): Int =
      if (-j > i) 0
      else if (j > i + 1) arr(i + 1)
      else {
        if (memo(i)(j + n)(ban) != -1) memo(i)(j + n)(ban)
        else {
          val res = (0 until 3)
            .filter(i == n - 1 || _ != ban)
            .map(k => {
              val score = (k - diff(s(i)) + 3) % 3 match {
                case 2 => -1
                case other => other
              }
              dfs(i - 1, j + score, k, s)
            })
            .foldLeft(0)((acc, x) => (acc + x) % M)

          memo(i)(j + n)(ban) = res
          res
        }
      }

    dfs(n - 1, 0, 0, s.toCharArray)
  }
}
