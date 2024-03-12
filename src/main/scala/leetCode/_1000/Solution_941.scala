package leetCode._1000

object Solution_941 {
  def validMountainArray(arr: Array[Int]): Boolean = {
    val peak = Iterator
      .iterate(0)(_ + 1)
      .dropWhile(i => i + 1 < arr.length && arr(i) < arr(i + 1))
      .next()

    peak != 0 && peak != arr.length - 1 && Iterator
      .iterate(peak)(_ + 1)
      .dropWhile(i => i + 1 < arr.length && arr(i) > arr(i + 1))
      .next() == arr.length - 1
  }
}
