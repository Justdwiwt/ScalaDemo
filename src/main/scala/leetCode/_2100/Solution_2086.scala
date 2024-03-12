package leetCode._2100

object Solution_2086 {
  def minimumBuckets(street: String): Int =
    if (street == "H" || street.startsWith("HH") || street.endsWith("HH") || street.contains("HHH")) -1
    else street.replace("H.H", "  ").length - street.replace("H", "").length
}
