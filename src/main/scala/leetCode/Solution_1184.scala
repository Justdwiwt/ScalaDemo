package leetCode

object Solution_1184 {
  def distanceBetweenBusStops(distance: Array[Int], start: Int, destination: Int): Int = {
    if (distance.isEmpty || distance == null) return 0
    var sum = 0
    var dis = 0
    distance.indices.foreach(i => {
      sum += distance(i)
      if (i >= start.min(destination) && i < start.max(destination)) dis += distance(i)
    })
    dis.min(sum - dis)
  }
}
