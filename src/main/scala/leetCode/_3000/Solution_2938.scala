package leetCode._3000

object Solution_2938 {
  def minimumSteps(s: String): Long = s./:(0L, 0) {
    case ((res, cnt), '1') => (res, cnt + 1)
    case ((res, cnt), _) => (res + cnt, cnt)
  }._1
}
