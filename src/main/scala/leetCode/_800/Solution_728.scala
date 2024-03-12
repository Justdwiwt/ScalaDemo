package leetCode._800

object Solution_728 {
  def selfDividingNumbers(left: Int, right: Int): List[Int] =
    (left to right).withFilter(i => i.toString.toCharArray.map(_ - '0').forall(x => x != 0 && i % x == 0)).map(i => i).toList
}
