package leetCode

object Solution_89 {
  def grayCode(n: Int): List[Int] =
    if (n == 0) 0 :: Nil
    else grayCode(n - 1) ::: grayCode(n - 1).reverseMap(_ | (1 << (n - 1)))
}
