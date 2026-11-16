package leetCode._4100

object Solution_4045 {
  def countGroups(position: Array[Int], speed: Array[Int], distance: Int): Int = speed
    .indices
    .reverse
    .tail
    .foldLeft((speed.last, 1)) {
      case ((mn, ans), i) =>
        if (speed(i) <= mn && position(i + 1) - position(i) > distance)
          (speed(i), ans + 1)
        else (mn, ans)
    }._2
}
