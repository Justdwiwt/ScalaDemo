package leetCode._1200

object Solution_1103 {
  def distributeCandies(candies: Int, num_people: Int): Array[Int] = {
    @scala.annotation.tailrec
    def f(candiesLeft: Int, num: Int, res: Array[Int], cnt: Int): Array[Int] =
      if (candiesLeft <= 0) res
      else {
        val updated = res.updated(num % num_people, res(num % num_people) + Math.min(candiesLeft, num + 1))
        f(candiesLeft - Math.min(candiesLeft, num + 1), num + 1, updated, cnt)
      }

    f(candies, 0, Array.fill(num_people)(0), 0)
  }
}
