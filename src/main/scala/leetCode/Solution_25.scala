package leetCode

object Solution_25 {
  @scala.annotation.tailrec
  def reverseListInKGroups[A](in: List[A], k: Int, acc: List[A] = List.empty[A], sub: List[A] = List.empty[A]): List[A] =
    if (in.isEmpty) acc ++ sub
    else if (sub.size == k) reverseListInKGroups(in, k, acc ++ sub, List.empty[A])
    else reverseListInKGroups(in.tail, k, acc, in.head :: sub)
}
