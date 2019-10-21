package algorithm

object QuickSort {

  def quickSort[A](list: List[A])(implicit ev$1: A => Ordered[A]): List[A] = list match {
    case Nil => List()
    case head :: tail =>
      val (left, right) = tail.partition(_ < head)
      quickSort(left) ::: head :: quickSort(right)
  }

}
