package leetCode

import scala.util.control.Breaks._

object Solution_739 {
  def dailyTemperatures(T: Array[Int]): Array[Int] = {
    val res = new Array[Int](T.length)
    T.indices.foreach(i => {
      val curr = T(i)
      if (curr < 100) {
        breakable {
          (i + 1 until T.length).foreach(j => {
            if (T(j) > curr) {
              res(i) = j - i
              break
            }
          })
        }
      }
    })
    res
  }
}
