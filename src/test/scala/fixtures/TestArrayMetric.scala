package fixtures

trait TestArrayMetric {
  case class ValueWrapper(ch: Char)

  implicit def convertTestCase(s: String): Array[ValueWrapper] =
    s.toCharArray.map(ch => ValueWrapper(ch))
}
