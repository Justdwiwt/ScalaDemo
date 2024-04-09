package leetCode._100

object Solution_60 {
  def getPermutation(n: Int, k: Int): String =
    f((1 until n).scan(1)(_ * _).tail.reverse, 1 to n, k - 1, "")

  @scala.annotation.tailrec
  private def f(seq: Seq[Int], idxSq: IndexedSeq[Int], k: Int, permutation: String): String = seq match {
    case Seq() => permutation + idxSq.head
    case Seq(head, tail@_*) => f(tail, idxSq.filterNot(_ == idxSq(k / head)), k % head, permutation + idxSq(k / head))
  }
}
