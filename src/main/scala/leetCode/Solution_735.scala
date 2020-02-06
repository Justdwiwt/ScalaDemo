package leetCode

import scala.util.control.Breaks._

object Solution_735 {
  def asteroidCollision(asteroids: Array[Int]): Array[Int] = {
    var res = Array.empty[Int]
    asteroids.foreach(i => {
      breakable {
        if (i > 0) {
          res :+= i
          break()
        }
      }
      while (!res.isEmpty && res.last > 0 && res.last + i < 0) res.dropRight(1)
      if (res.isEmpty || res.last < 0) res :+= i
      else if (res.last + i == 0) res.dropRight(1)
    })
    res
  }
}
