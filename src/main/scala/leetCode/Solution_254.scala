package leetCode

object Solution_254 {
  def getFactors(n: Int): List[List[Int]] = {

    def f(start: Int, num: Int): List[List[Int]] = {
      if (num == 1) return Nil
      var res = List.empty[List[Int]]
      (start to math.sqrt(num).toInt).foreach(i => if (num % i == 0) {
        res ::= (i :: num / i :: Nil)
        f(i, num / i).foreach(v => {
          var t = v
          t ::= i
          res ::= t
        })
      })
      res
    }

    f(2, n)
  }
}
