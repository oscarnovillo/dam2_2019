import java.time.LocalDate

import org.apache.spark.sql.SparkSession

object MainObj extends App{

  val spark = SparkSession.builder().
    master("local").getOrCreate()

  spark.sparkContext.setLogLevel("ERROR");


  val agenda = spark.read.option("header", "true").csv("datos/206974-0-agenda-eventos-culturales-100.csv")
  agenda.printSchema()
  //agenda.map[LocalDate](linea => linea.getDate("dstart") )
  agenda.show()

}
