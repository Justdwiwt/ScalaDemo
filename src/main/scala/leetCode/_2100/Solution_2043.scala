package leetCode._2100

object Solution_2043 {
  class Bank(balance: Array[Long]) {
    def transfer(account1: Int, account2: Int, money: Long): Boolean =
      if (!withdraw(account1, money)) false
      else if (deposit(account2, money)) true
      else {
        deposit(account1, money)
        false
      }

    def deposit(account: Int, money: Long): Boolean =
      if (account > balance.length) false
      else {
        balance(account - 1) += money
        true
      }

    def withdraw(account: Int, money: Long): Boolean =
      if (account > balance.length) false
      else if (balance(account - 1) < money) false
      else {
        balance(account - 1) -= money
        true
      }
  }
}
