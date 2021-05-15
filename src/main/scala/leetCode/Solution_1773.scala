package leetCode

object Solution_1773 {
  def countMatches(items: List[List[String]], ruleKey: String, ruleValue: String): Int = items.count({
    case t :: _ :: _ :: _ if ruleKey == "type" && t == ruleValue => true
    case _ :: c :: _ :: _ if ruleKey == "color" && c == ruleValue => true
    case _ :: _ :: n :: _ if ruleKey == "name" && n == ruleValue => true
    case _ => false
  })
}
