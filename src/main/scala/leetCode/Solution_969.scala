package leetCode

import scala.collection.mutable.ListBuffer

object Solution_969 {
  def pancakeSort(A: Array[Int]): List[Int] = {
    @scala.annotation.tailrec
    def flip(input: Array[Int], k: Int, start: Int = 0): Array[Int] =
      if (start >= k) input
      else {
        val flipped = input
        flipped(start) = flipped(start) ^ flipped(k)
        flipped(k) = flipped(start) ^ flipped(k)
        flipped(start) = flipped(start) ^ flipped(k)
        flip(flipped, k - 1, start + 1)
      }

    @scala.annotation.tailrec
    def sort(input: Array[Int], res: ListBuffer[Int], elem: Int): List[Int] = input.indexOf(elem) match {
      case -1 => res.toList
      case idx if idx == elem - 1 => sort(input, res, elem - 1)
      case idx if idx == 0 => sort(flip(input, elem - 1), res += elem, elem - 1)
      case idx => sort(flip(input, idx), res += (idx + 1), elem)
    }

    sort(A, ListBuffer.empty[Int], A.length)
  }
}
