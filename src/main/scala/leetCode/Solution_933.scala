package leetCode

object Solution_933 {

  class RecentCounter() {

    private var times = List[Int]()

    def ping(t: Int): Int = {
      times ::= t
      count(t, times, 0)
    }

    def count(t: Int, times: List[Int], acc: Int): Int = times match {
      case Nil => acc
      case head :: tail => if (t - head <= 3000) count(t, tail, acc + 1) else acc
    }

  }

}
