package leetCode

object Solution_1248 {
  def numberOfSubarrays(nums: Array[Int], k: Int): Int = {
    val pos = -1 +: nums.indices.filter(nums(_) % 2 == 1) :+ nums.length

    @scala.annotation.tailrec
    def f(acc: Int, l: Int, r: Int): Int =
      if (pos.size - 2 < k || r == pos.size - 1) acc
      else f(acc + (pos(l) - pos(l - 1)) * (pos(r + 1) - pos(r)), l + 1, r + 1)

    f(0, 1, k)
  }
}
