package leetCode._2400

object Solution_2334 {
  def validSubarraySize(nums: Array[Int], threshold: Int): Int = {
    val n = nums.length
    val fa = Array.tabulate(n + 1)(identity)
    val sz = Array.fill(n + 1)(0)

    def find(x: Int): Int = {
      if (fa(x) != x) fa(x) = find(fa(x))
      fa(x)
    }

    @scala.annotation.tailrec
    def process(ids: List[Int]): Int = ids match {
      case Nil => -1
      case i :: rest =>
        val j = find(i + 1)
        fa(i) = j
        sz(j) += sz(i) + 1
        if (nums(i) > threshold / sz(j)) sz(j) else process(rest)
    }

    val ids = nums.indices.toList.sortBy(-nums(_))
    process(ids)
  }
}
