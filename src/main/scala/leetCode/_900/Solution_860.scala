package leetCode._900

object Solution_860 {
  def lemonadeChange(bills: Array[Int]): Boolean = {
    @scala.annotation.tailrec
    def f(bills: Array[Int], changes: Map[Int, Int]): Boolean = {
      if (bills.isEmpty) true
      else bills.head match {
        case 5 => f(bills.tail, changes.updated(5, changes(5) + 1))
        case 10 => if (changes(5) == 0) false else f(bills.tail, changes.updated(5, changes(5) - 1).updated(10, changes(10) + 1))
        case 20 => if (changes(10) > 0 && changes(5) > 0) f(bills.tail, changes.updated(5, changes(5) - 1).updated(10, changes(10) - 1))
        else if (changes(5) >= 3) f(bills.tail, changes.updated(5, changes(5) - 3))
        else false
      }
    }

    f(bills, Map(5 -> 0, 10 -> 0))
  }
}
