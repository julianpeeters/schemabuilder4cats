# schemabuilder4cats
 - **Library for Scala 3.3.0 (JVM only)**
 - **Depends on Avro 1.11.1**

### Installation

Build schemas secure in the knowledge that we won't be causing side-effects.

##### Add the dependency

```
"com.julianpeeters" %% "schemabuilder4cats" % "0.1.2"
```

### Usage

The `SchemaBuilder` API is modelled after Apache Avro Java 1.11.1 API.
Please see the corresponding `org.apache.avro.SchemaBuilder`
[Javadoc](https://avro.apache.org/docs/1.11.1/api/java/) for documentation.

##### Example:

```scala
import cats.effect.IO
import org.apache.avro.Schema
import schemabuilder4cats.SchemaBuilder

// define B as a contextual abstraction in order to import extension methods
given B: SchemaBuilder[IO] = SchemaBuilder[IO]
val record: IO[Schema] = B.record("myrecord").fields.endRecord
```

##### Result:

```scala
import cats.effect.unsafe.implicits.global

// example usage only, avoid unsafe methods in real code
record.unsafeRunSync().toString(true)
// res0: String = """{
//   "type" : "record",
//   "name" : "myrecord",
//   "fields" : [ ]
// }"""
```