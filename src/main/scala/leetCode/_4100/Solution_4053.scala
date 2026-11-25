package leetCode._4100

object Solution_4053 {
  private val MX = 2000000002

  private val palindromes = Array.fill(2)(
    scala.collection.mutable.ArrayBuffer(0)
  )

  private val initialized: Unit = {
    var base = 1
    var done = false

    while (base <= MX && !done) {
      var i = base

      while (i < base * 10 && !done) {
        var x = i
        var t = i / 10

        while (t > 0) {
          x = x * 10 + t % 10
          t /= 10
        }

        if (x > MX) done = true
        else palindromes(x % 2) += x

        i += 1
      }

      i = base

      while (i < base * 10 && !done) {
        var x = i
        var t = i

        while (t > 0) {
          x = x * 10 + t % 10
          t /= 10
        }

        if (x > MX) done = true
        else palindromes(x % 2) += x

        i += 1
      }

      base *= 10
    }
  }

  def minOperations(nums: Array[Int]): Long = {
    val _ = initialized

    nums.foldLeft(0L) { (ans, x) =>
      val p = palindromes(x % 2)
      var l = -1
      var r = p.length

      while (l + 1 < r) {
        val m = (l + r) >>> 1
        if (p(m) >= x) r = m
        else l = m
      }

      ans + math.min(p(r) - x, x - p(l))
    } / 2
  }
}
