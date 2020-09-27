package leetCode

object Solution_1106 {
  def parseBoolExpr(expression: String): Boolean = ((true, Seq.empty[Char], -1) /: expression) {
    case ((_, st, -1), op@('!' | '&' | '|')) => (true, op +: st, -1)
    case ((_, st, -1), c@('t' | 'f')) => (c == 't', st, -1)
    case ((false, st@'&' +: _, -1), ',') => (false, st, 0)
    case ((true, st@'|' +: _, -1), ',') => (true, st, 0)
    case (s@(_, _, -1), '(') => s
    case ((cv, '!' +: st, -1), ')') => (!cv, st, -1)
    case ((cv, _ +: st, 0 | -1), ')') => (cv, st, -1)
    case ((cv, st, cn), '(') => (cv, st, cn + 1)
    case ((cv, st, cn), ')') => (cv, st, cn - 1)
    case (s, _) => s
  }._1
}
