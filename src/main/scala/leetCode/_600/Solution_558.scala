package leetCode._600

object Solution_558 {

  class Node(var _value: Boolean, var _isLeaf: Boolean) {
    var value: Boolean = _value
    var isLeaf: Boolean = _isLeaf
    var topLeft: Node = _
    var topRight: Node = _
    var bottomLeft: Node = _
    var bottomRight: Node = _
  }

  private def CreateNode(_value: Boolean, _isLeaf: Boolean, _topLeft: Node, _topRight: Node, _bottomLeft: Node, _bottomRight: Node): Node = {
    val res = new Node(_value, _isLeaf)
    res.topLeft = _topLeft
    res.topRight = _topRight
    res.bottomLeft = _bottomLeft
    res.bottomRight = _bottomRight
    res
  }

  def intersect(quadTree1: Node, quadTree2: Node): Node = {
    if (quadTree1.isLeaf) {
      if (quadTree1.value) return new Node(_value = true, _isLeaf = true)
      return CreateNode(quadTree2.value, quadTree2.isLeaf, quadTree2.topLeft, quadTree2.topRight, quadTree2.bottomLeft, quadTree2.bottomRight)
    }
    if (quadTree2.isLeaf) return intersect(quadTree2, quadTree1)
    val o1 = intersect(quadTree1.topLeft, quadTree2.topLeft)
    val o2 = intersect(quadTree1.topRight, quadTree2.topRight)
    val o3 = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft)
    val o4 = intersect(quadTree1.bottomRight, quadTree2.bottomRight)
    if (o1.isLeaf && o2.isLeaf && o3.isLeaf && o4.isLeaf && o1.value == o2.value && o1.value == o3.value && o1.value == o4.value)
      return new Node(_value = o1.value, _isLeaf = true)
    CreateNode(_value = false, _isLeaf = false, o1, o2, o3, o4)
  }
}
