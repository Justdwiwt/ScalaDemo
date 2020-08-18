package leetCode

import scala.collection.mutable

object Solution_554 {
  def leastBricks(wall: List[List[Int]]): Int = {
    var m = new mutable.HashMap[Int, Int]()
    var cnt = 0
    wall.foreach(v => {
      var sum = 0
      (0 until v.length - 1).foreach(i => {
        sum += v(i)
        m += sum -> (m.getOrElseUpdate(sum, 0) + 1)
        cnt = cnt.max(m(sum))
      })
    })
    wall.length - cnt
  }
}
