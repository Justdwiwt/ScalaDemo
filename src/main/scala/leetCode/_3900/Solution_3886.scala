package leetCode._3900

object Solution_3886 {
  def sortableIntegers(nums: Array[Int]): Int = {
    val n = nums.length
    val divisorsBuildler = Array.newBuilder[Int]
    var d = 1
    while (d * d < n) {
      if (n % d == 0) {
        divisorsBuildler += d
        divisorsBuildler += n / d
      }
      d += 1
    }
    if (d * d == n) divisorsBuildler += d
    val divisors = divisorsBuildler.result()

    def analizeSubarray(start: Int, end: Int): (Int, Int) = {
      var drops = 0
      var maximum = -1
      var minimum = Int.MaxValue
      (start until end).foreach(i => {
        maximum = maximum max nums(i)
        minimum = minimum min nums(i)
        if (i == end - 1) {
          if (nums(i) > nums(start)) drops += 1
        } else {
          if (nums(i) > nums(i + 1)) drops += 1
        }
      })
      if (drops <= 1) (maximum, minimum)
      else (-1, -1)
    }

    var count = 0
    divisors.foreach(k => {
      var prev = Int.MinValue
      var result = true
      (0 until n / k)
        .withFilter(_ => result)
        .foreach(seqId => {
          val seqStart = seqId * k
          val seqEnd = (seqId + 1) * k

          val (maximum, minimum) = analizeSubarray(seqStart, seqEnd)
          if (maximum == -1 && minimum == -1) result = false
          else if (minimum < prev) result = false
          else prev = maximum
        })
      if (result) count += k
    })

    count
  }
}
