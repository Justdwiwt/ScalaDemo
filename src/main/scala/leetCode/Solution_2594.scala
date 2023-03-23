package leetCode

object Solution_2594 {
  case class Mech(rank: Int, repaired: Int) {
    private val nRepaired = repaired + 1
    val cost: Long = rank.toLong * nRepaired * nRepaired
  }

  implicit val ord: Ordering[Mech] = Ordering.by(-_.cost)

  def repairCars(ranks: Array[Int], totalCars: Int): Long = {
    var time = 0L
    //    val mechs = scala.collection.mutable.PriorityQueue.empty[Int](ranks.map(r => Mech(r, 0): _*)
    val mechs = scala.collection.mutable.PriorityQueue.empty[Mech]
    (1 to totalCars).foreach(_ => {
      val mech = mechs.dequeue()
      time = time.max(mech.cost)
      mechs.enqueue(Mech(mech.rank, mech.repaired + 1))
    })
    time
  }
}
