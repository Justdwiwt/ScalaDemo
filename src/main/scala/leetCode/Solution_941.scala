package leetCode

object Solution_941 {
  def validMountainArray(arr: Array[Int]): Boolean = arr
    .indices
    .dropRight(1)
    .find(i => arr(i) >= arr(i + 1))
    .fold(false)(t => {
      if (t == 0) false
      else arr
        .indices
        .drop(1)
        .reverse
        .find(i => arr(i - 1) <= arr(i))
        .fold(false)(_ == t)
    })
}
