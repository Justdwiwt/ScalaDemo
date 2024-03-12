package leetCode._3000

object Solution_2951 {
  def findPeaks(mountain: Array[Int]): List[Int] = mountain
    .indices
    .drop(1)
    .dropRight(1)
    .filter(i => mountain(i) > mountain(i - 1) && mountain(i) > mountain(i + 1))
    .toList
}
