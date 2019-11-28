package leetCode

object Solution_40 {
  private var res = List[List[Int]]()
  private var out = List[Int]()

  def combinationSum2(candidates: Array[Int], target: Int): List[List[Int]] = {
    val t = candidates.sorted
    func(t, target, 0, 0)

    def func(t: Array[Int], target: Int, sum: Int, level: Int): Int = {
      if (sum > target) return 1
      if (sum == target) {
        if (!res.contains(out)) res ::= out
        return 1
      }
      if (t.length == 1) {
        if (target == t(0)) {
          out :::= List(t(0))
          res ::= out
        }
        return 0
      }
      var s = sum
      var i = level
      while (i < t.length) {
        s += t(i)
        out :::= List(t(i))
        val j = func(t, target, s, i + 1)
        out = out.drop(out.length - 1)
        s -= t(i)
        if (j == 1) i = t.length
        i += 1
      }
      0
    }

    res
  }
}
