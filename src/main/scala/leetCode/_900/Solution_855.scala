package leetCode._900

import scala.collection.mutable

object Solution_855 {

  class ExamRoom(_N: Int) {

    private val n = _N
    private val s = mutable.Set[Int]()

    def seat(): Int = {
      var start = 0
      var index = 0
      var mx = 0
      s.foreach(i => {
        if (start == 0) {
          if (mx < i - start) {
            mx = i - start
            index = 0
          }
        } else {
          if (mx < (i - start + 1) / 2) {
            mx = (i - start + 1) / 2
            index = start + mx - 1
          }
        }
        start = i + 1
      })
      if (start > 0 && mx < n - start) {
        mx = n - start
        index = n - 1
      }
      s.add(index)
      index
    }

    def leave(p: Int): Unit = s.drop(p)

  }

}

