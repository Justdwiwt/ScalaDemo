package leetCode

object Solution_43 {
  def multiply(num1: String, num2: String): String =
    f(num1.toList.reverse.map(_.asDigit), num2.toList.reverse.map(_.asDigit)).reverse.mkString

  def f(num1: List[Int], num2: List[Int]): List[Int] = (num1, num2) match {
    case (Nil, _) | (0 :: Nil, _) | (_, Nil) | (_, 0 :: Nil) => 0 :: Nil
    case (d1 :: Nil, d2 :: Nil) => (d1 * d2).toString.reverse.toList.map(_.asDigit)
    case (d1 :: Nil, d2 :: t2) =>
      val ones = (d1 * d2).toString.reverse.toList.map(_.asDigit)
      val tens = f(num1, t2)
      add(ones, 0 :: tens, 0)
    case (d :: t, _) =>
      val tens = f(t, num2)
      val ones = f(d :: Nil, num2)
      add(ones, 0 :: tens, 0)
  }

  def add(num1: List[Int], num2: List[Int], carry: Int): List[Int] = (num1, num2) match {
    case (Nil, Nil) => if (carry == 0) Nil else List(carry)
    case (h1 :: t1, Nil) =>
      if (carry == 0) num1
      else if (h1 + carry < 10) (h1 + carry) :: t1
      else (h1 + carry) % 10 :: add(t1, Nil, (h1 + carry) / 10)
    case (Nil, _) => add(num2, num1, carry)
    case (h1 :: t1, h2 :: t2) =>
      val ones = h1 + h2 + carry
      ones % 10 :: add(t1, t2, ones / 10)
  }
}
