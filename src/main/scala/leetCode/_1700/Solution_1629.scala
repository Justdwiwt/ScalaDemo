package leetCode._1700

object Solution_1629 {
  def slowestKey(releaseTimes: Array[Int], keysPressed: String): Char = {
    releaseTimes.zip(keysPressed)./:(('a', 0, 0))((prev, next) => {
      val (time, key) = next
      val (cur, mx, preTime) = prev
      val duration = time - preTime
      if (duration > mx) (key, duration, time)
      else if (duration == mx && key > cur) (key, duration, time)
      else (cur, mx, time)
    })._1
  }
}
