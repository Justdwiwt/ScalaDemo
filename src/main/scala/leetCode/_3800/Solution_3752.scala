package leetCode._3800

object Solution_3752 {
  def lexSmallestNegatedPerm(n: Int, target: Long): Array[Int] = {
    val mx = n.toLong * (n + 1) / 2
    if (math.abs(target) > mx || ((mx - target) & 1L) != 0L)
      return Array.emptyIntArray

    val need = (mx - target) / 2

    val (neg, pos, _) = (n to 1 by -1).foldLeft((Vector.empty[Int], Vector.empty[Int], need)) {
      case ((neg, pos, rest), x) =>
        if (rest >= x) (neg :+ -x, pos, rest - x)
        else (neg, pos :+ x, rest)
    }

    (neg ++ pos.reverse).toArray
  }
}
