package leetCode._3700

object Solution_3654 {
  def minArraySum(nums: Array[Int], k: Int): Long = {
    val INF = Long.MaxValue / 4

    nums.foldLeft((0, 0L, Map(0 -> 0L))) {
      case ((s, f, m), x) =>
        val ns = (s + x) % k
        val keep = f + x
        val remove = m.getOrElse(ns, INF)
        val nf = keep.min(remove)
        (ns, nf, m + (ns -> nf))
    }._2
  }
}
