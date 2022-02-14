package leetCode

object Solution_2169 {
  def countOperations(num1: Int, num2: Int): Int = {
    if (num1 == 0 || num2 == 0) return 0
    if (num1 > num2) num1 / num2 + countOperations(num2, num1 % num2)
    else num2 / num1 + countOperations(num1, num2 % num1)
  }
}
