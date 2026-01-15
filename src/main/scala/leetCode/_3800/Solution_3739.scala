package leetCode._3800

object Solution_3739 {
  def countMajoritySubarrays(nums: Array[Int], target: Int): Long = {
    val prefix = nums.scanLeft(0)((s, x) => s + (if (x == target) 1 else -1))

    val sorted = prefix.distinct.sorted
    val index = sorted.zipWithIndex.toMap

    val bit = Array.fill(sorted.length + 1)(0L)

    def add(i: Int): Unit = {
      var x = i + 1
      while (x < bit.length) {
        bit(x) += 1
        x += x & -x
      }
    }

    def sum(i: Int): Long = {
      var x = i + 1
      var res = 0L
      while (x > 0) {
        res += bit(x)
        x -= x & -x
      }
      res
    }

    var ans = 0L
    prefix.foreach(s => {
      val i = index(s)
      ans += sum(i - 1)
      add(i)
    })

    ans
  }
}
