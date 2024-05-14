package leetCode._500

object Solution_465 {
  def minTransfers(transactions: Array[Array[Int]]): Int = {
    val account = transactions.foldLeft(Map.empty[Int, Int])((acc, transaction) => {
      val (from, to, amount) = (transaction.head, transaction(1), transaction(2))
      acc + (from -> (acc.getOrElse(from, 0) - amount)) + (to -> (acc.getOrElse(to, 0) + amount))
    })

    val money = account.values.filter(_ != 0).toList

    def dfs(start: Int, count: Int, money: List[Int], ans: Int): Int =
      if (count > ans) ans
      else {
        val currentStart = money.indexWhere(_ != 0, start)
        if (currentStart == -1) ans.min(count)
        else {
          val newAns = (currentStart + 1 until money.length).foldLeft(ans)((acc, i) => {
            if (money(i) * money(currentStart) < 0) {
              val newMoney = money.updated(i, money(i) + money(currentStart))
              dfs(currentStart + 1, count + 1, newMoney, acc)
            } else acc
          })
          newAns
        }
      }

    dfs(0, 0, money, Int.MaxValue)
  }
}
