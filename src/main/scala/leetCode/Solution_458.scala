package leetCode

object Solution_458 {
  def poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int = {
    math.ceil(math.log(buckets) / math.log(minutesToTest / minutesToDie + 1)).toInt
  }
}
