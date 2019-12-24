package leetCode

object Solution_1248 {
  def numberOfSubarrays(A: Array[Int], k: Int): Int = {
    @scala.annotation.tailrec
    def f(l: List[Int], acc: List[Int] = Nil, count: Int = 0): List[Int] = l match {
      case Nil => count :: acc
      case h :: t => h % 2 match {
        case 0 => f(t, acc, count + 1)
        case 1 => f(t, count :: acc)
      }
    }

    @scala.annotation.tailrec
    def g(A: Array[Int], k: Int)(i: Int, acc: Int): Int = {
      if (i + k < A.length) g(A, k)(i + 1, acc + (A(i + k) + 1) * (A(i) + 1))
      else acc
    }

    g(f(A.toList).toArray, k)(0, 0)
  }
}
