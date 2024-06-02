package leetCode._1800

object Solution_1776 {
  def getCollisionTimes(cars: Array[Array[Int]]): Array[Double] = {
    val n = cars.length
    val res = Array.fill[Double](n)(-1)

    @scala.annotation.tailrec
    def f(i: Int, stack: List[Int]): List[Int] = {
      if (i < 0) stack
      else {
        @scala.annotation.tailrec
        def processStack(stack: List[Int]): List[Int] = stack match {
          case Nil => stack
          case head +: tail =>
            if (cars(head)(1) >= cars(i)(1)) processStack(tail)
            else {
              val collisionTime = (cars(head).head - cars(i).head).toDouble / (cars(i)(1) - cars(head)(1))
              if (res(head) < 0 || collisionTime <= res(head)) stack
              else processStack(tail)
            }
          case _ => stack
        }

        val newStack = processStack(stack)
        val newRes = if (newStack.isEmpty) -1.0
        else (cars(newStack.head).head - cars(i).head).toDouble / (cars(i)(1) - cars(newStack.head)(1))

        res(i) = newRes
        f(i - 1, i +: newStack)
      }
    }

    f(n - 1, Nil)
    res
  }
}
