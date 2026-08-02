package leetCode._4000

object Solution_3960 {
  def getLength(nums: Array[Int]): Int = {
    val n = nums.length

    if (nums.distinct.length == n) return 1

    val same = nums
      .groupBy(identity)
      .values
      .map(_.length)
      .reduceOption(_.max(_))
      .getOrElse(0)

    var ans = nums
      .foldLeft((0, 0, Int.MinValue)) {
        case ((best, cur, prev), x) =>
          val next =
            if (x == prev) cur + 1
            else 1

          (best.max(next), next, x)
      }
      ._1

    nums
      .indices
      .withFilter(i => n - i > ans)
      .foreach(i => {
        val cnt = collection.mutable.Map.empty[Int, Int]
        val freq = collection.mutable.Map.empty[Int, Int]

        (i until n).foreach(j => {
          val x = nums(j)

          cnt.get(x).foreach(old => {
            freq(old) = freq(old) - 1
            if (freq(old) == 0) freq.remove(old)
          })

          val next = cnt.getOrElse(x, 0) + 1
          cnt(x) = next
          freq(next) = freq.getOrElse(next, 0) + 1

          if (freq.size == 2) {
            val Array(a, b) = freq.keys.toArray.sorted
            if (a * 2 == b) ans = ans.max(j - i + 1)
          }
        })
      })

    ans
  }
}
