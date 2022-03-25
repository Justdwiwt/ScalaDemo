package leetCode

object Solution_2209 {
  def minimumWhiteTiles(floor: String, numCarpets: Int, carpetLen: Int): Int = {
    val arr = floor + ("0" * (carpetLen - 1))
    val pre = Array.fill(arr.length + 1)(0)
    arr.indices.foreach(i => {
      pre(i + 1) += pre(i)
      if (arr(i) == '1') pre(i + 1) += 1
    })

    def f(i: Int): Int =
      pre((i + 1).min(arr.length)) - pre((i - carpetLen + 1).max(0))

    floor.count(_ == '1')

    val dp = Array.fill(arr.length + 1)(Array.fill(numCarpets + 1)(-1))

    def g(numCarpets: Int, i: Int): Int = {
      if (numCarpets == 0) return 0
      if (i < 0) return 0
      if (dp(i)(numCarpets) == -1)
        dp(i)(numCarpets) = (f(i) + g(numCarpets - 1, i - carpetLen)).max(g(numCarpets, i - 1))
      dp(i)(numCarpets)
    }

    floor.count(_ == '1') - g(numCarpets, arr.length - 1)
  }
}
