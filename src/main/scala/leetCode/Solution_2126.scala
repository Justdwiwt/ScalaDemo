package leetCode

object Solution_2126 {
  def asteroidsDestroyed(mass: Int, asteroids: Array[Int]): Boolean = {
    var cnt = mass.toLong
    val sorted = asteroids.sorted
    sorted.foreach(i => if (cnt >= i) cnt += i else return false)
    true
  }
}
