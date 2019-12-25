package leetCode

import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

object Solution_1282 {
  def groupThePeople(groupSizes: Array[Int]): List[List[Int]] = {
    var res = List.empty[List[Int]]
    if (groupSizes.length != 0) {
      groupSizes.indices.foreach(i => {
        var num = groupSizes(i)
        breakable {
          if (num == 0) break
        }
        if (num == 1) {
          var tmp = List(i)
          res :+= tmp
        } else {
          val tmp = ListBuffer(num)
          num -= 1
          tmp(num) = i
          var j = i + 1
          while (j < groupSizes.length && num > 0) {
            if (groupSizes(i) == groupSizes(j)) {
              groupSizes(j) = 0
              num -= 1
              tmp(num) = j
            }
            j += 1
          }
          res :+= tmp.toList
        }
      })
    }
    res
  }
}
