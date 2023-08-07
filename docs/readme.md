# schemabuilder4cats
A referentially transparent FFI to `org.apache.avro.SchemaBuilder`

### Welcome to `schemabuilder4cats`

Let's build schemas secure in the knowledge that we won't be causing side-effects.

##### Add the dependency

```
"com.julianpeeters" %% "schemabuilder4cats" % "@VERSION@"
```

### Usage

The `SchemaBuilder` API is modelled after `org.apache.avro.SchemaBuilder`.
Please see the corresponding Apache Avro Java @AVRO@ API
[Javadoc](https://avro.apache.org/docs/@AVRO@/api/java/) for documentation.

##### Example:

```scala mdoc:silent
import cats.effect.IO
import org.apache.avro.Schema
import schemabuilder4cats.SchemaBuilder

// define B as a contextual abstraction in order to import extension methodss
given B: SchemaBuilder[IO] = SchemaBuilder[IO]
val record: IO[Schema] = B.record("myrecord").fields.endRecord
```

##### Result:
```scala mdoc
import cats.effect.unsafe.implicits.global

// example usage only, avoid unsafe methods in real code
record.unsafeRunSync().toString(true)
```