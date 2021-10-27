package leetCode

import scala.collection.immutable.HashSet

object Offer_113 {
  def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {
    @scala.annotation.tailrec
    def findOrder(dependsOn: Map[Int, List[Int]], dependencyFor: Map[Int, List[Int]], noDependencies: HashSet[Int], returnValue: List[Int]): List[Int] = {
      if (noDependencies.isEmpty)
        if (returnValue.length == numCourses) returnValue
        else List.empty
      else {
        val course = noDependencies.head
        val (updatedDependsOn: Map[Int, List[Int]], updatedNoDependencies: HashSet[Int]) = removeDependency(
          course = course,
          dependentCourses = dependencyFor.getOrElse(course, List.empty),
          dependsOn = dependsOn,
          noDependencies = noDependencies
        )
        findOrder(
          dependsOn = updatedDependsOn,
          dependencyFor = dependencyFor,
          noDependencies = updatedNoDependencies - course,
          returnValue = returnValue :+ course
        )
      }
    }

    @scala.annotation.tailrec
    def removeDependency(course: Int, dependentCourses: List[Int], dependsOn: Map[Int, List[Int]], noDependencies: HashSet[Int]): (Map[Int, List[Int]], HashSet[Int]) =
      if (dependentCourses.isEmpty) (dependsOn, noDependencies)
      else {
        val dependency: Int = dependentCourses.head
        val updatedDependencies: List[Int] = dependsOn(dependency).filter(_ != course)
        removeDependency(
          course = course,
          dependentCourses = dependentCourses.tail,
          dependsOn = {
            if (updatedDependencies.isEmpty) dependsOn - dependency
            else dependsOn - dependency + (dependency -> updatedDependencies)
          },
          noDependencies = {
            if (updatedDependencies.isEmpty) noDependencies + dependency
            else noDependencies
          }
        )
      }

    val (dependsOn: Map[Int, List[Int]], dependencyFor: Map[Int, List[Int]], noDependencies: HashSet[Int]) = prerequisites
      ./:((Map.empty[Int, List[Int]], Map.empty[Int, List[Int]], HashSet[Int](Range(0, numCourses): _*)))((tuple, current) => {
        val (dependsOn: Map[Int, List[Int]], dependencyFor: Map[Int, List[Int]], noDependencies: HashSet[Int]) = tuple
        val course = current.head
        val dependentOn = current(1)
        val updatedDependsOn = dependsOn - course + (course -> (dependsOn.getOrElse(course, List.empty) :+ dependentOn))
        val updatedDependencyFor = dependencyFor - dependentOn + (dependentOn -> (dependencyFor.getOrElse(dependentOn, List.empty) :+ course))
        val updatedNoDependencies = noDependencies - course
        (updatedDependsOn, updatedDependencyFor, updatedNoDependencies)
      })

    if (noDependencies.isEmpty) Array.empty
    else findOrder(dependsOn, dependencyFor, noDependencies, List.empty).toArray
  }
}
