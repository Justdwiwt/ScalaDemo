package leetCode._1900

object Solution_1866 {
  private val M = 1000000007

  def rearrangeSticks(n: Int, k: Int): Int = (1 to n)
    .foldLeft(IndexedSeq(1L)) {
      case (numArrangements, n) => IndexedSeq.tabulate(n.min(k) + 1) {
        case 0 => 0
        case k if k == n => 1
        case k => (numArrangements(k - 1) + (n - 1) * numArrangements(k)) % M
      }
    }
    .apply(k)
    .toInt
}
