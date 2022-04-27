package leetCode

import scala.collection.mutable

object Solution_1488 {
  def avoidFlood(rains: Array[Int]): Array[Int] = {
    val res = Array.fill(rains.length)(0)
    val m = mutable.HashMap.empty[Int, Int]
    var arr = Array.emptyIntArray
    rains.indices.foreach(i => {
      if (rains(i) == 0) {
        res(i) = 1
        arr :+= 1
      } else {
        res(i) = -1
        if (m.contains(rains(i))) {
          val a = m(rains(i))
          if (arr.isEmpty || arr(arr.length - 1) < a) return Array(0)
          else {
            var l = 0
            var r = arr.length - 1
            while (l < r) {
              val mid = (l + r) >>> 1
              if (arr(mid) > a) r = mid
              else l = mid + 1
            }
            res(arr(l)) = rains(i)
            arr.drop(l)
          }
        }
        m.put(rains(i), i)
      }
    })
    res
  }
}
