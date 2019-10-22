package leetCode

object Solution_860 {
  def lemonadeChange(bills: Array[Int]): Boolean = {
    var five = 0
    var ten = 0
    bills.foreach(i =>
      if (i == 5) five += 1
      else if (i == 10) {
        ten += 1
        five -= 1
        if (five < 0) return false
      } else {
        if (ten > 0) {
          ten -= 1
          five -= 1
          if (five < 0) return false
        } else if (five > 0) {
          five -= 3
          if (five < 0) return false
        }
        else return false
      })
    true
  }
}
