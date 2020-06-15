package leetCode

object Solution_1237 {

  class CustomFunction {
    def f(x: Int, y: Int): Int = ???
  }

  def findSolution(customfunction: CustomFunction, z: Int): List[List[Int]] = {
    var res = List.empty[List[Int]]
    var start = 1
    var end = 1000
    while (start <= 1000 && end >= 1) {
      val r = customfunction.f(start, end)
      if (r == z) {
        var t = List.empty[Int]
        t :+= start
        t :+= end
        res :+= t
        start += 1
        end -= 1
      } else if (r > z) end -= 1
      else start += 1
    }
    res
  }
}
