package leetCode._4000

object Solution_3956 {
  def maximumSum(nums: Array[Int], m: Int, l: Int, r: Int): Long = {
    val n = nums.length

    val pre = nums.scanLeft(0L)(_ + _)

    val negInf = Long.MinValue / 4

    def nextState(cur: Array[Long]): (Array[Long], Long) = {
      val nxt = Array.fill(n + 1)(negInf)

      val queue = new Array[Int](n + 1)
      var head = 0
      var tail = 0

      var best = negInf

      (l to n).foreach(i => {
        val idx = i - l
        val value = cur(idx) - pre(idx)

        while (tail > head &&
          cur(queue(tail - 1)) - pre(queue(tail - 1)) <= value) {
          tail -= 1
        }

        queue(tail) = idx
        tail += 1

        while (tail > head && queue(head) < i - r) head += 1

        if (tail > head) {
          nxt(i) = cur(queue(head)) - pre(queue(head)) + pre(i)

          best = best.max(nxt(i))
        }
      })

      val merged = nxt.scanLeft(negInf)(math.max).tail

      (merged, best)
    }

    val (_, ans) = (1 to m).foldLeft((Array.fill(n + 1)(0L), negInf)) {
      case ((cur, best), _) =>
        val (next, score) = nextState(cur)
        (next, math.max(best, score))
    }

    ans
  }
}
