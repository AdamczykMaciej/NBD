//Monads, wrapping up

object ex2 {

  def toInt(x: String): Maybe[Int] = {
    try {
      new Yes[Int](x.toInt)
    } catch {
      case _: Exception => new No[Int]
    }
  }

  def toInt2(x: String): Int = {
    try {
      x.toInt
    } catch {
      case _: Exception => 0
    }
  }

  def toString(x: Int): Maybe[String] = {
    try {
      new Yes[String](x.toString)
    } catch {
      case _: Exception => new No[String]
    }
  }

  def multiplyBy2(x: Int): Maybe[Int] = {
    new Yes[Int](x*2)
  }

  trait Maybe[A]{
    def map[R](f: A => R): Maybe[R]
    def flatMap[R](f: A => Maybe[R]): Maybe[R]
    def getOrElse[R >: A](default:R): R
  }

  class No[Nothing] extends Maybe[Nothing] {
    override def map[R](f: Nothing => R): Maybe[R] = {
      new No[R]
    }

    override def flatMap[R](f: Nothing => Maybe[R]): Maybe[R]= {
      new No[R]
    }
    override def getOrElse[R >: Nothing](default:R): R = {
      default
    }
  }

  class Yes[A](private var _content: A) extends Maybe[A] {
    override def map[R](f: A => R): Maybe[R] = {
      new Yes[R](f(_content))
    }

    override def flatMap[R](f: A => Maybe[R]): Maybe[R] = {
      f(_content)
    }

    override def getOrElse[R >: A](default:R): R = {
      return _content
    }
  }

  def main(args: Array[String]): Unit = {

    val no = new No[String]
    val yes = new Yes[String]("10")
    println(no.isInstanceOf[Maybe[String]])
    println(yes.isInstanceOf[Maybe[String]])

    // 3,4.)
    println("3,4.)")
    print("Map")
    println(yes.map(toInt2).getOrElse("default"))
    println(yes.map(toInt).getOrElse("default")) // does not flatten
//    println(yes.map(toInt).map(toString).getOrElse("default")) // will not work because toInt function would need Maybe[Int] => ..., but toString is Int=>
    println("FlatMap")
    println(no.flatMap(toInt).flatMap(toString).getOrElse("default"))
    println(yes.flatMap(toInt).getOrElse("default")) // flattens
    println(yes.flatMap(toInt).flatMap(toString).getOrElse("default")) // flattens
    println(yes.flatMap(toInt).flatMap(toString).flatMap(toInt).flatMap(toString).getOrElse("default")) // flattens

  }
}
