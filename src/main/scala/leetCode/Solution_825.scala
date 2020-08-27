package leetCode

object Solution_825 {

  case class Age(age: Int, n: Int)

  def numFriendRequests(ages: Array[Int]): Int = {
    solver(f(ages.filter(_ >= 15)).sortBy(x => -x.age), 0)
  }

  @scala.annotation.tailrec
  def solver(ages: Array[Age], acc: Int): Int = {
    if (ages.length == 0) acc
    else ages.tail.indexWhere(x => x.age.toDouble <= 0.5 * ages.head.age + 7.0) match {
      case -1 => solverHelp(ages.tail, acc + send(ages.head.n) + ages.tail.map(x => x.n).sum * ages.head.n)
      case bound: Int => solver(ages.tail, acc + send(ages.head.n) + ages.tail.slice(0, bound).map(x => x.n).sum * ages.head.n)
    }
  }

  @scala.annotation.tailrec
  def solverHelp(ages: Array[Age], acc: Int): Int = {
    if (ages.length == 0) acc
    else solverHelp(ages.tail, acc + send(ages.head.n) + ages.tail.map(x => x.n).sum * ages.head.n)
  }

  def send(n: Int): Int = n match {
    case 1 => 0
    case _ => n * (n - 1)
  }

  def f(ages: Array[Int]): Array[Age] = {
    val m = scala.collection.mutable.HashMap[Int, Int]()
    ages.foreach(i => m.put(i, m.getOrElse(i, 0) + 1))
    m.keySet.zip(m.values).map(x => Age(x._1, x._2)).toArray
  }

}
