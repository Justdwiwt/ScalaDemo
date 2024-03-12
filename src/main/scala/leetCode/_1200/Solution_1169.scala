package leetCode._1200

import scala.collection.mutable

object Solution_1169 {
  case class Transaction(name: String, time: Int, amount: Int, city: String, raw: String)

  def invalidTransactions(transactions: Array[String]): List[String] = {
    val tsByName = mutable.HashMap.empty[String, mutable.ArrayBuffer[Transaction]]
    transactions.foreach(str => {
      val arr = str.split(',')
      val t = Transaction(arr(0), arr(1).toInt, arr(2).toInt, arr(3), str)
      tsByName.getOrElseUpdate(t.name, mutable.ArrayBuffer.empty).append(t)
    })

    def computeCityCounts(arr: mutable.ArrayBuffer[Transaction]): Array[Int] = {
      val cityCounts = Array.ofDim[Int](arr.length)
      val cities = mutable.HashMap.empty[String, Int]
      var start = 0
      var end = 0
      while (end < arr.length) {
        while ((arr(end).time - arr(start).time).abs > 60) {
          val cityCount = cities(arr(start).city)
          if (cityCount == 1) cities.remove(arr(start).city)
          else cities.put(arr(start).city, cityCount - 1)
          start += 1
        }
        cities.put(arr(end).city, cities.getOrElse(arr(end).city, 0) + 1)
        cityCounts(end) = cities.size
        end += 1
      }
      cityCounts
    }

    var res = List.empty[String]
    tsByName.valuesIterator.foreach(ts => {
      ts.sortBy(_.time)
      val cityCountsBackward = computeCityCounts(ts)
      ts.sortBy(-_.time)
      val cityCountsForward = computeCityCounts(ts)
      var i = 0
      while (i < ts.length) {
        if (cityCountsForward(i) > 1 || cityCountsBackward(ts.length - i - 1) > 1 || ts(i).amount >= 1000)
          res = ts(i).raw :: res
        i += 1
      }
    })
    res
  }
}
