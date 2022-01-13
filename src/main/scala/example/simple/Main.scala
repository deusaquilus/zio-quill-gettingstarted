package example.simple

import io.getquill.context.ZioJdbc._
import zio._
import io.getquill._
import zio.magic._

import java.sql.SQLException
import javax.sql.DataSource

case class Person(name: String, age: Int)

object QuillContext extends PostgresZioJdbcContext(SnakeCase)

object DataService {
   import QuillContext._
   def getPeople = run(query[Person])
}

/**
 * Simple example of Quill using the jdbc-zio context
 */
object Main extends App {
   override def run(args: List[String]) =
      DataService.getPeople
        .inject(DataSourceLayer.fromPrefix("myDatabaseConfig").orDie)
        .debug("Results")
        .exitCode
}
