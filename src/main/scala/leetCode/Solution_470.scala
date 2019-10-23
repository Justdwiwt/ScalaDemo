package leetCode

object Solution_470 {
  def rand10(): Int = {
    while (true) {
      val res = (rand7() - 1) * 7 + rand7() - 1
      if (res < 40) return res % 10 + 1
    }
    -1
  }

  def rand7(): Int = {
    1
  }
}
