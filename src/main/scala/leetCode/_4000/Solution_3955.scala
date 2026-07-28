package leetCode._4000

object Solution_3955 {
  def generateValidStrings(n: Int, k: Int): List[String] = {
    def dfs(i: Int, cost: Int, prev1: Boolean, s: String): List[String] =
      if (cost > k) Nil
      else if (i == n) List(s)
      else
        dfs(i + 1, cost, prev1 = false, s + '0') :::
          (if (prev1) Nil else dfs(i + 1, cost + i, prev1 = true, s + '1'))

    dfs(0, 0, prev1 = false, "")
  }
}
