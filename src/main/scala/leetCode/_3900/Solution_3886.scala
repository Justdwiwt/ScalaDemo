package leetCode._3900

object Solution_3886 {
  def sortableIntegers(nums: Array[Int]): Int = {
    val n = nums.length

    val divisors = (1 to math.sqrt(n).toInt)
      .flatMap(d => {
        if (n % d != 0) Nil
        else if (d * d == n) List(d)
        else List(d, n / d)
      })

    def analyzeSubarray(start: Int, end: Int): Option[(Int, Int)] = {
      val sub = nums.slice(start, end)

      val drops = sub.indices.count(i => sub(i) > sub((i + 1) % sub.length))

      if (drops <= 1) Some(sub.max -> sub.min)
      else None
    }

    divisors.foldLeft(0)((sum, k) => {
      val ok = (0 until n / k)
        .foldLeft(Option(Int.MinValue)) {
          case (None, _) => None

          case (Some(prevMax), seqId) =>
            val start = seqId * k
            val end = start + k

            analyzeSubarray(start, end).flatMap {
              case (mx, mn) =>
                if (mn < prevMax) None
                else Some(mx)
            }
        }
        .nonEmpty

      if (ok) sum + k else sum
    })
  }
}
