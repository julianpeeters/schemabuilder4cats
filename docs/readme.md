# schemabuilder4cats
 - **Library for Scala @SCALA@ (JVM only)**
 - **Depends on Avro @AVRO@**

### Installation

Build schemas secure in the knowledge that we won't be causing side-effects.

##### Add the dependency

```
"com.julianpeeters" %% "schemabuilder4cats" % "@VERSION@"
```

### Usage

The `SchemaBuilder` API is modelled after Apache Avro Java @AVRO@ API.
Please see the corresponding `org.apache.avro.SchemaBuilder`
[Javadoc](https://avro.apache.org/docs/@AVRO@/api/java/) for documentation.

##### Example:

```scala mdoc:silent
import cats.effect.IO
import org.apache.avro.Schema
import schemabuilder4cats.SchemaBuilder

// define B as a contextual abstraction in order to import extension methods
given B: SchemaBuilder[IO] = SchemaBuilder[IO]
val record: IO[Schema] = B.record("myrecord").fields.endRecord
```

##### Result:

```scala mdoc
import cats.effect.unsafe.implicits.global

// example usage only, avoid unsafe methods in real code
record.unsafeRunSync().toString(true)
```