package leetCode._900

object Solution_900 {

  class RLEIterator(_A: Array[Int]) {

    private val A = _A
    private var cur = 0

    def next(n: Int): Int = {
      if (cur > A.length - 1 || n <= 0) -1
      else if (n <= A(cur)) {
        A(cur) -= n
        A(cur + 1)
      } else {
        cur += 2
        next(n - A(cur - 2))
      }
    }
  }

}
