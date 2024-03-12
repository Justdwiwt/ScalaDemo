package leetCode._2400

object Solution_2332 {
  def latestTimeCatchTheBus(buses: Array[Int], passengers: Array[Int], capacity: Int): Int = (buses.sorted.toList, passengers.sorted.toList) match {
    case (b1 :: bus, p1 :: pass) => f(b1, capacity, bus, p1, pass, List.empty, capacity)
    case _ => ???
  }

  @scala.annotation.tailrec
  def f(dep: Int, cap: Int, bus: List[Int], p1: Int, pass: List[Int], departed: List[Int], total: Int): Int =
    if (p1 > dep) bus match {
      case Nil => find(dep, departed)
      case b1 :: nBus => f(b1, total, nBus, p1, pass, departed, total)
    }
    else if (cap == 1) (bus, pass) match {
      case (Nil, _) => find(p1, p1 :: departed)
      case (nel, Nil) => nel.last
      case (b1 :: nBus, p2 :: nPass) => f(b1, total, nBus, p2, nPass, p1 :: departed, total)
    }
    else pass match {
      case Nil => bus.lastOption.getOrElse(find(dep, p1 :: departed))
      case p2 :: pass => f(dep, cap - 1, bus, p2, pass, p1 :: departed, total)
    }

  @scala.annotation.tailrec
  def find(n: Int, departed: List[Int]): Int = departed match {
    case `n` :: tail => find(n - 1, tail)
    case _ => n
  }
}
