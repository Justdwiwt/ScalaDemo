package leetCode._900

import scala.collection.mutable

object Solution_815 {
  private def getBusStops(routes: Array[Array[Int]]): mutable.Map[Int, mutable.Set[Int]] = {
    val busStops = mutable.Map.empty[Int, mutable.Set[Int]]
    routes.indices.foreach(i => {
      val route = routes(i)
      route.foreach(busStops.getOrElseUpdate(_, mutable.Set.empty[Int]).add(i))
    })
    busStops
  }

  private def getBusGraph(busStops: mutable.Map[Int, mutable.Set[Int]]): mutable.Map[Int, mutable.Set[Int]] = {
    val busGraph = mutable.Map.empty[Int, mutable.Set[Int]]
    busStops
      .values
      .map(_.toArray)
      .foreach(buses => buses.indices.foreach(i => (i + 1 until buses.length).foreach(j => {
        busGraph.getOrElseUpdate(buses(i), mutable.Set.empty[Int]).add(buses(j))
        busGraph.getOrElseUpdate(buses(j), mutable.Set.empty[Int]).add(buses(i))
      })))
    busGraph
  }

  private def bfs(busGraph: mutable.Map[Int, mutable.Set[Int]], start: mutable.Set[Int], end: mutable.Set[Int]): Int =
    if (end.isEmpty) -1
    else {
      var num = 0
      var reached = false
      var current = start.toArray
      val visited = mutable.Set.empty[Int]
      while (!reached && current.nonEmpty) {
        num += 1
        current.foreach(visited.+=)
        current.foreach(reached |= end.contains(_))
        if (!reached) {
          val next = mutable.Set.empty[Int]
          current
            .foreach(busGraph.getOrElse(_, mutable.Set.empty[Int])
              .withFilter(!visited.contains(_))
              .foreach(next.add))
          current = next.toArray
        }
      }
      if (reached) num else -1
    }

  def numBusesToDestination(routes: Array[Array[Int]], source: Int, target: Int): Int =
    if (source == target) 0
    else {
      val busStops = getBusStops(routes)
      val start = busStops.getOrElse(source, mutable.Set.empty[Int])
      val end = busStops.getOrElse(target, mutable.Set.empty[Int])
      val busGraph = getBusGraph(busStops)
      bfs(busGraph, start, end)
    }
}
