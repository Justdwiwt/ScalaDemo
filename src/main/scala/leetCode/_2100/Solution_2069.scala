package leetCode._2100

object Solution_2069 {
  class Robot(width: Int, height: Int) {
    private val directions = Array("East", "North", "West", "South")
    private val w = width
    private val h = height
    private var loc = 0
    private var moved = false

    def step(num: Int): Unit = {
      moved = true
      loc += num
      loc %= 2 * (w - 1) + 2 * (h - 1)
    }

    def getPos: Array[Int] = {
      val info = move()
      Array(info.head, info(1))
    }

    def getDir: String = {
      val info = move()
      val x = info(0)
      val y = info(1)
      val dir = info(2)

      if (x == 0 && y == 0) {
        if (moved) directions(3) else directions.head
      } else directions(dir)
    }

    private def move(): Array[Int] =
      if (loc <= w - 1) Array(loc, 0, 0)
      else if (loc <= (w - 1) + (h - 1)) Array(w - 1, loc - (w - 1), 1)
      else if (loc <= 2 * (w - 1) + (h - 1)) Array((w - 1) - (loc - ((w - 1) + (h - 1))), h - 1, 2)
      else Array(0, (h - 1) - (loc - (2 * (w - 1) + (h - 1))), 3)
  }
}
