package leetCode._1300

object Solution_1237 {

  class CustomFunction {
    def f(x: Int, y: Int): Int = ???
  }

  def findSolution(customfunction: CustomFunction, z: Int): List[List[Int]] = {
    def f(x: Int, y: Int): List[List[Int]] = {
      if (x > 1000 || y <= 0) return Nil
      val v = customfunction.f(x, y)
      if (v < z) f(x + 1, y)
      else if (v > z) f(x, y - 1)
      else List(List(x, y)) ::: f(x + 1, y - 1)
    }

    f(1, 1000)
  }
}
