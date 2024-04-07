package leetCode._300

object Solution_282 {
  def addOperators(num: String, target: Int): List[String] = {
    def dfs(idx: Int, path: String, pathValue: Long, maybePrevOperand: Option[Long]): Seq[String] = {
      if (idx == num.length && pathValue == target) return Seq(path)
      (idx + 1 to num.length).flatMap(i => {
        val remain = num.substring(idx, i)
        if (i > idx + 1 && num(idx) == '0') Seq.empty
        else {
          val operand = remain.toLong
          maybePrevOperand match {
            case None => dfs(i, remain, operand, Some(operand))
            case Some(prev) =>
              dfs(i, s"$path+$remain", pathValue + operand, Some(operand)) ++
                dfs(i, s"$path-$remain", pathValue - operand, Some(-operand)) ++
                dfs(i, s"$path*$remain", pathValue - prev + prev * operand, Some(prev * operand))
          }
        }
      })
    }

    dfs(idx = 0, path = "", pathValue = 0, maybePrevOperand = None).toList
  }
}
