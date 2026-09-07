package leetCode._4000

object Solution_3984 {
  val MOD = 1000000007L
  val MX = 1000001

  private val primeDivisors: Array[Array[Int]] = {
    val a = Array.fill(MX)(List.empty[Int])

    (2 until MX).foreach(i => if (a(i).isEmpty) (i until MX by i).foreach(j => a(j) = i :: a(j)))

    a.map(_.reverse.toArray)
  }

  def divisibleGame(nums: Array[Int]): Int = {
    val prefix = nums.scanLeft(0L)(_ + _)

    if (prefix.last == nums.length)
      return (MOD - 2).toInt

    val f = collection.mutable.Map.empty[Int, Long].withDefaultValue(0L)
    val last = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)

    var maxDiff = Long.MinValue
    var bestK = 0

    nums.indices.foreach { i =>
      primeDivisors(nums(i)).foreach { p =>
        val diff = 0L.max(f(p) - prefix(i) + prefix(last(p))) + nums(i)

        f(p) = diff
        last(p) = i + 1

        if (diff > maxDiff || diff == maxDiff && p < bestK) {
          maxDiff = diff
          bestK = p
        }
      }
    }

    (maxDiff * bestK % MOD).toInt
  }
}
