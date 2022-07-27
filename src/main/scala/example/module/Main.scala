package example.module

import io.getquill._
import io.getquill.jdbczio.Quill
import zio._

import java.sql.SQLException

case class Person(name: String, age: Int)

trait DataService {
  def getPeople: ZIO[Any, SQLException, List[Person]]
  def getPeopleOlderThan(age: Int): ZIO[Any, SQLException, List[Person]]
}

object DataService {
   def getPeople = ZIO.serviceWithZIO[DataService](_.getPeople)
   def getPeopleOlderThan(age: Int) = ZIO.serviceWithZIO[DataService](_.getPeopleOlderThan(age))
}

object DataServiceLive {
   val layer = ZLayer.fromFunction(DataServiceLive.apply _)
}

final case class DataServiceLive(quill: Quill.Postgres[SnakeCase]) extends DataService {
  import quill._
  def getPeople =
    run(query[Person])
  def getPeopleOlderThan(age: Int) =
    run(query[Person].filter(p => p.age > lift(age)))
}

/**
 * Demonstrates using Quill with a ZIO Module 2.0 pattern.
 */
object Main extends ZIOAppDefault {
  val quillLayer = Quill.Postgres.fromNamingStrategy(SnakeCase)
  val dsLayer = Quill.DataSource.fromPrefix("myDatabaseConfig")

  override def run =
    DataService.getPeople
      .provide(quillLayer, dsLayer, DataServiceLive.layer)
      .debug("Results")
      .exitCode
}
