package leetCode

object Solution_346 {

  class MovingAverage(_size: Int) {

    private val size = _size
    private var sum = 0.0
    private var q = List.empty[Int]

    def next(`val`: Int): Double = {
      q ::= `val`
      if (q.size > size) {
        sum -= q.head
        q = q.tail
      }
      sum += `val`
      sum / q.size
    }

  }

}
