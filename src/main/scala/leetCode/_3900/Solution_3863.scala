package leetCode._3900

object Solution_3863 {
  def minOperations(s: String): Int = {
    val n = s.length
    val mn = s.min
    val mx = s.max

    val isSorted = s.sliding(2).forall {
      case w if w.length == 2 => w.head <= w(1)
      case _ => true
    }

    if (isSorted) 0
    else if (n == 2) -1
    else if (s.head == mn || s.last == mx) 1
    else if (s.slice(1, n - 1).exists(ch => ch == mn || ch == mx)) 2
    else 3
  }
}
