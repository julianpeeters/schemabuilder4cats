package schemabuilder4cats

import cats.effect.IO
import munit.CatsEffectSuite

class SchemaBuilderSuite extends CatsEffectSuite:

  test("record schema definition"):
    // define B as a given, in order to auto-import all extension methods
    given B: SchemaBuilder[IO] = SchemaBuilder[IO]
    val record = B.record("rec").fields.endRecord
    val obtained: IO[String] = record.map(s => s.toString(true))
    val expected: String = "{\n  \"type\" : \"record\",\n  \"name\" : \"rec\",\n  \"fields\" : [ ]\n}"
    assertIO(obtained, expected)