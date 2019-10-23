package leetCode

object Solution_66 {
  def plusOne(digits: Array[Int]): Array[Int] = {
    (digits.length - 1 to 0 by (-1)).foreach(i => {
      digits(i) += 1
      digits(i) = digits(i) % 10
      if (digits(i) != 0) return digits
    })
    val tmp = new Array[Int](digits.length + 1)
    tmp(0) = 1
    tmp
  }
}
