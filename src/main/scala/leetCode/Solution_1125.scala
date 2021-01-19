package leetCode

object Solution_1125 {
  def smallestSufficientTeam(skills: Array[String], people: List[List[String]]): Array[Int] =
    f(skills.toSet, people, 0, Set.empty, None).map(_.toArray).orNull

  def f(skills: Set[String], people: List[List[String]], ide: Int, team: Set[Int], mnTeam: Option[Set[Int]]): Option[Set[Int]] = (skills, people, team, mnTeam) match {
    case (_, _, _, Some(sst)) if team.size == sst.size => mnTeam
    case (_, _, _, _) if skills.isEmpty => Some(team)
    case (_, head :: tail, _, _) if head.exists(skills.contains) => f(skills, tail, ide + 1, team, f(skills -- head, tail, ide + 1, team + ide, mnTeam))
    case (_, _ :: tail, _, _) => f(skills, tail, ide + 1, team, mnTeam)
    case _ => mnTeam
  }
}
