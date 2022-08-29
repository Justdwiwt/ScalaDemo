package leetCode

object Solution_2391 {
  def garbageCollection(garbage: Array[String], travel: Array[Int]): Int = {
    val diff = List('G', 'P', 'M')
    val costs = diff.map(tpe => {
      val last = garbage.lastIndexWhere(_.contains(tpe))
      val pickups = (0 to last).map(i => garbage(i).count(_ == tpe))
      val transitions = (0 until last).map(i => travel(i))
      pickups.sum + transitions.sum
    })
    costs.sum
  }
}
