package schemabuilder4cats

import _root_.scala.jdk.CollectionConverters.{MapHasAsJava, SeqHasAsJava}
import cats.effect.kernel.Sync
import cats.implicits.given
import java.nio.ByteBuffer
import org.apache.avro.generic.GenericRecord
import org.apache.avro.Schema
import org.apache.avro.SchemaBuilder.{
  ArrayBuilder as JArrayBuilder,
  ArrayDefault as JArrayDefault,
  BaseTypeBuilder as JBaseTypeBuilder,
  BaseFieldTypeBuilder as JBaseFieldTypeBuilder,
  BooleanBuilder as JBooleanBuilder,
  BooleanDefault as JBooleanDefault,
  BytesBuilder as JBytesBuilder,
  BytesDefault as JBytesDefault,
  DoubleBuilder as JDoubleBuilder,
  DoubleDefault as JDoubleDefault,
  EnumBuilder as JEnumBuilder,
  EnumDefault as JEnumDefault,
  FieldAssembler as JFieldAssembler,
  FieldBuilder as JFieldBuilder,
  FieldDefault as JFieldDefault,
  FieldTypeBuilder as JFieldTypeBuilder,
  FixedBuilder as JFixedBuilder,
  FixedDefault as JFixedDefault,
  FloatBuilder as JFloatBuilder,
  FloatDefault as JFloatDefault,
  GenericDefault as JGenericDefault,
  IntBuilder as JIntBuilder,
  IntDefault as JIntDefault,
  LongBuilder as JLongBuilder,
  LongDefault as JLongDefault,
  MapBuilder as JMapBuilder,
  MapDefault as JMapDefault,
  NamedBuilder as JNamedBuilder,
  NamespacedBuilder as JNamespacedBuilder,
  NullBuilder as JNullBuilder,
  NullDefault as JNullDefault,
  PropBuilder as JPropBuilder,
  RecordBuilder as JRecordBuilder,
  RecordDefault as JRecordDefault,
  StringBldr as JStringBuilder,
  StringDefault as JStringDefault,
  TypeBuilder as JTypeBuilder,
  UnionAccumulator as JUnionAccumulator,
  UnionFieldTypeBuilder as JUnionFieldTypeBuilder,
}

// Not implemented: self methods, shortcut methods
trait SchemaBuilder[F[_]]:
  def array: F[JArrayBuilder[Schema]]
  def builder: F[JTypeBuilder[Schema]]
  def builder(namespace: String): F[JTypeBuilder[Schema]]
  def enumeration(name: String): F[JEnumBuilder[Schema]]
  def fixed(name: String): F[JFixedBuilder[Schema]]
  def map: F[JMapBuilder[Schema]]
  def nullable: F[JBaseTypeBuilder[Schema]]
  def record(name: String): F[JRecordBuilder[Schema]]
  def unionOf: F[JBaseTypeBuilder[JUnionAccumulator[Schema]]]
  extension [A] (fab: F[JArrayBuilder[A]])
    def items: F[JTypeBuilder[A]]
    def items(itemsSchema: Schema): F[A]
    @scala.annotation.targetName("propArrayBuilder")
    def prop(name: String, `val`: String): F[JArrayBuilder[A]]
  extension [A] (fad: F[JArrayDefault[A]])
    def arrayDefault[V](defaultVal: List[V]): F[JFieldAssembler[A]]
    @scala.annotation.targetName("noDefaultArrayDefault")
    def noDefault: F[JFieldAssembler[A]]
  extension [A] (fbftb: F[JBaseFieldTypeBuilder[A]])
    @scala.annotation.targetName("arrayBuilderBaseFieldTypeBuilder")
    def array: F[JArrayBuilder[JArrayDefault[A]]]
    @scala.annotation.targetName("booleanBuilderBaseFieldTypeBuilder")
    def booleanBuilder: F[JBooleanBuilder[JBooleanDefault[A]]]
    @scala.annotation.targetName("booleanTypeBaseFieldTypeBuilder")
    def booleanType: F[JBooleanDefault[A]]
    @scala.annotation.targetName("bytesBuilderBaseFieldTypeBuilder")
    def bytesBuilder: F[JBytesBuilder[JBytesDefault[A]]]
    @scala.annotation.targetName("bytesTypeBaseFieldTypeBuilder")
    def bytesType: F[JBytesDefault[A]]
    @scala.annotation.targetName("doubleBuilderBaseFieldTypeBuilder")
    def doubleBuilder: F[JDoubleBuilder[JDoubleDefault[A]]]
    @scala.annotation.targetName("doubleTypeBaseFieldTypeBuilder")
    def doubleType: F[JDoubleDefault[A]]
    @scala.annotation.targetName("enumerationBaseFieldTypeBuilder")
    def enumeration(name: String): F[JEnumBuilder[JEnumDefault[A]]]
    @scala.annotation.targetName("fixedBaseFieldTypeBuilder")
    def fixed(name: String): F[JFixedBuilder[JFixedDefault[A]]]
    @scala.annotation.targetName("floatBuilderBaseFieldTypeBuilder")
    def floatBuilder: F[JFloatBuilder[JFloatDefault[A]]]
    @scala.annotation.targetName("floatTypeBaseFieldTypeBuilder")
    def floatType: F[JFloatDefault[A]]
    @scala.annotation.targetName("intBuilderBaseFieldTypeBuilder")
    def intBuilder: F[JIntBuilder[JIntDefault[A]]]
    @scala.annotation.targetName("intTypeBaseFieldTypeBuilder")
    def intType: F[JIntDefault[A]]
    @scala.annotation.targetName("longBuilderBaseFieldTypeBuilder")
    def longBuilder: F[JLongBuilder[JLongDefault[A]]]
    @scala.annotation.targetName("longTypeBaseFieldTypeBuilder")
    def longType: F[JLongDefault[A]]
    @scala.annotation.targetName("mapBaseFieldTypeBuilder")
    def map: F[JMapBuilder[JMapDefault[A]]]
    @scala.annotation.targetName("nullBuilderBaseFieldTypeBuilder")
    def nullBuilder: F[JNullBuilder[JNullDefault[A]]]
    @scala.annotation.targetName("nullTypeBaseFieldTypeBuilder")
    def nullType: F[JNullDefault[A]]
    @scala.annotation.targetName("recordBaseFieldTypeBuilder")
    def record(name: String): F[JRecordBuilder[JRecordDefault[A]]]
    @scala.annotation.targetName("stringBuilderBaseFieldTypeBuilder")
    def stringBuilder: F[JStringBuilder[JStringDefault[A]]]
    @scala.annotation.targetName("stringTypeBaseFieldTypeBuilder")
    def stringType: F[JStringDefault[A]]
  extension [A] (fbtb: F[JBaseTypeBuilder[A]])
    @scala.annotation.targetName("arrayBuilderBaseTypeBuilder")
    def array: F[JArrayBuilder[A]]
    @scala.annotation.targetName("booleanBuilderBaseTypeBuilder")
    def booleanBuilder: F[JBooleanBuilder[A]]
    @scala.annotation.targetName("booleanTypeBaseTypeBuilder")
    def booleanType: F[A]
    @scala.annotation.targetName("bytesBuilderBaseTypeBuilder")
    def bytesBuilder: F[JBytesBuilder[A]]
    @scala.annotation.targetName("bytesTypeBaseTypeBuilder")
    def bytesType: F[A]
    @scala.annotation.targetName("doubleBuilderBaseTypeBuilder")
    def doubleBuilder: F[JDoubleBuilder[A]]
    @scala.annotation.targetName("doubleTypeBaseTypeBuilder")
    def doubleType: F[A]
    @scala.annotation.targetName("enumerationBaseTypeBuilder")
    def enumeration(name: String): F[JEnumBuilder[A]]
    @scala.annotation.targetName("fixedBaseTypeBuilder")
    def fixed(name: String): F[JFixedBuilder[A]]
    @scala.annotation.targetName("floatBuilderBaseTypeBuilder")
    def floatBuilder: F[JFloatBuilder[A]]
    @scala.annotation.targetName("floatTypeBaseTypeBuilder")
    def floatType: F[A]
    @scala.annotation.targetName("intBuilderBaseTypeBuilder")
    def intBuilder: F[JIntBuilder[A]]
    @scala.annotation.targetName("intTypeBaseTypeBuilder")
    def intType: F[A]
    @scala.annotation.targetName("longBuilderBaseTypeBuilder")
    def longBuilder: F[JLongBuilder[A]]
    @scala.annotation.targetName("longTypeBaseTypeBuilder")
    def longType: F[A]
    @scala.annotation.targetName("mapBaseTypeBuilder")
    def map: F[JMapBuilder[A]]
    @scala.annotation.targetName("nullBuilderBaseTypeBuilder")
    def nullBuilder: F[JNullBuilder[A]]
    @scala.annotation.targetName("nullTypeBaseTypeBuilder")
    def nullType: F[A]
    @scala.annotation.targetName("recordBaseTypeBuilder")
    def record(name: String): F[JRecordBuilder[A]]
    @scala.annotation.targetName("stringBuilderBaseTypeBuilder")
    def stringBuilder: F[JStringBuilder[A]]
    @scala.annotation.targetName("stringTypeBaseTypeBuilder")
    def stringType: F[A]
    @scala.annotation.targetName("typeSchemaBaseTypeBuilder")
    def `type`(schema: Schema): F[A]
    @scala.annotation.targetName("typeNameBaseTypeBuilder")
    def `type`(name: String): F[A]
    @scala.annotation.targetName("typeFullNameBaseTypeBuilder")
    def `type`(name: String, namespace: String): F[A]
  extension [A] (fbb: F[JBooleanBuilder[A]])
    def endBoolean: F[A]
    @scala.annotation.targetName("propBooleanBuilder")
    def prop(name: String, `val`: String): F[JBooleanBuilder[A]]
  extension [A] (fbd: F[JBooleanDefault[A]])
    def booleanDefault(defaultVal: Boolean): F[JFieldAssembler[A]]
    @scala.annotation.targetName("noDefaultBooleanDefault")
    def noDefault: F[JFieldAssembler[A]]
  extension [A] (fbb: F[JBytesBuilder[A]])
    def endBytes: F[A]
    @scala.annotation.targetName("propBytesBuilder")
    def prop(name: String, `val`: String): F[JBytesBuilder[A]]
  extension [A] (fbd: F[JBytesDefault[A]])
    def bytesDefault(defaultVal: Array[Byte]): F[JFieldAssembler[A]]
    def bytesDefault(defaultVal: ByteBuffer): F[JFieldAssembler[A]]
    def bytesDefault(defaultVal: String): F[JFieldAssembler[A]]
    @scala.annotation.targetName("noDefaultBytesDefault")
    def noDefault: F[JFieldAssembler[A]]
  extension [A] (fdb: F[JDoubleBuilder[A]])
    def endDouble: F[A]
    @scala.annotation.targetName("propDoubleBuilder")
    def prop(name: String, `val`: String): F[JDoubleBuilder[A]]
  extension [A] (fdd: F[JDoubleDefault[A]])
    def doubleDefault(defaultVal: Double): F[JFieldAssembler[A]]
    @scala.annotation.targetName("noDefaultDoubleDefault")
    def noDefault: F[JFieldAssembler[A]]
  extension [A] (feb: F[JEnumBuilder[A]])
    @scala.annotation.targetName("aliasesEnumBuilder")
    def aliases(aliases: String*): F[JEnumBuilder[A]]
    @scala.annotation.targetName("docEnumBuilder")
    def doc(doc: String): F[JEnumBuilder[A]]
    @scala.annotation.targetName("namespaceEnumBuilder")
    def namespace(namespace: String): F[JEnumBuilder[A]]
    @scala.annotation.targetName("propEnumBuilder")
    def prop(name: String, `val`: String): F[JEnumBuilder[A]]
    def symbols(symbols: String*): F[A]
  extension [A] (fed: F[JEnumDefault[A]])
    def enumDefault(defaultVal: String): F[JFieldAssembler[A]]
    @scala.annotation.targetName("noDefaultEnumDefault")
    def noDefault: F[JFieldAssembler[A]]
  extension [A] (ffa: F[JFieldAssembler[A]])
    def endRecord: F[A]
    def name(fieldName: String): F[JFieldBuilder[A]]
  extension [A] (ffb: F[JFieldBuilder[A]])
    @scala.annotation.targetName("aliasesFieldBuilder")
    def aliases(aliases: String*): F[JFieldBuilder[A]]
    @scala.annotation.targetName("docFieldBuilder")
    def doc(doc: String): F[JFieldBuilder[A]]
    def orderAscending: F[JFieldBuilder[A]]
    def orderDescending: F[JFieldBuilder[A]]
    def orderIgnore: F[JFieldBuilder[A]]
    @scala.annotation.targetName("propFieldBuilder")
    def prop(name: String, `val`: String): F[JFieldBuilder[A]]
    @scala.annotation.targetName("typeFieldBuilder")
    def `type`: F[JFieldTypeBuilder[A]]
    @scala.annotation.targetName("typeSchemaFieldBuilder")
    def `type`(schema: Schema): F[JGenericDefault[A]]
    @scala.annotation.targetName("typeNameFieldBuilder")
    def `type`(name: String): F[JGenericDefault[A]]
    @scala.annotation.targetName("typeFullNameFieldBuilder")
    def `type`(name: String, namespace: String): F[JGenericDefault[A]]
  extension [A] (fftb: F[JFieldTypeBuilder[A]])
    @scala.annotation.targetName("arrayBuilderFieldTypeBuilder")
    def array: F[JArrayBuilder[JArrayDefault[A]]]
    @scala.annotation.targetName("booleanBuilderFieldTypeBuilder")
    def booleanBuilder: F[JBooleanBuilder[JBooleanDefault[A]]]
    @scala.annotation.targetName("booleanTypeFieldTypeBuilder")
    def booleanType: F[JBooleanDefault[A]]
    @scala.annotation.targetName("bytesBuilderFieldTypeBuilder")
    def bytesBuilder: F[JBytesBuilder[JBytesDefault[A]]]
    @scala.annotation.targetName("bytesTypeFieldTypeBuilder")
    def bytesType: F[JBytesDefault[A]]
    @scala.annotation.targetName("doubleBuilderFieldTypeBuilder")
    def doubleBuilder: F[JDoubleBuilder[JDoubleDefault[A]]]
    @scala.annotation.targetName("doubleTypeFieldTypeBuilder")
    def doubleType: F[JDoubleDefault[A]]
    @scala.annotation.targetName("enumerationFieldTypeBuilder")
    def enumeration(name: String): F[JEnumBuilder[JEnumDefault[A]]]
    @scala.annotation.targetName("fixedFieldTypeBuilder")
    def fixed(name: String): F[JFixedBuilder[JFixedDefault[A]]]
    @scala.annotation.targetName("floatBuilderFieldTypeBuilder")
    def floatBuilder: F[JFloatBuilder[JFloatDefault[A]]]
    @scala.annotation.targetName("floatTypeFieldTypeBuilder")
    def floatType: F[JFloatDefault[A]]
    @scala.annotation.targetName("intBuilderFieldTypeBuilder")
    def intBuilder: F[JIntBuilder[JIntDefault[A]]]
    @scala.annotation.targetName("intTypeFieldTypeBuilder")
    def intType: F[JIntDefault[A]]
    @scala.annotation.targetName("longBuilderFieldTypeBuilder")
    def longBuilder: F[JLongBuilder[JLongDefault[A]]]
    @scala.annotation.targetName("longTypeFieldTypeBuilder")
    def longType: F[JLongDefault[A]]
    @scala.annotation.targetName("mapFieldTypeBuilder")
    def map: F[JMapBuilder[JMapDefault[A]]]
    @scala.annotation.targetName("nullBuilderFieldTypeBuilder")
    def nullBuilder: F[JNullBuilder[JNullDefault[A]]]
    @scala.annotation.targetName("nullTypeFieldTypeBuilder")
    def nullType: F[JNullDefault[A]]
    @scala.annotation.targetName("recordFieldTypeBuilder")
    def record(name: String): F[JRecordBuilder[JRecordDefault[A]]]
    @scala.annotation.targetName("stringBuilderFieldTypeBuilder")
    def stringBuilder: F[JStringBuilder[JStringDefault[A]]]
    @scala.annotation.targetName("stringTypeFieldTypeBuilder")
    def stringType: F[JStringDefault[A]]
    @scala.annotation.targetName("unionOfFieldTypeBuilder")
    def unionOf: F[JUnionFieldTypeBuilder[A]]
  extension [A] (fab: F[JFixedBuilder[A]])
    @scala.annotation.targetName("aliasesFixedBuilder")
    def aliases(aliases: String*): F[JFixedBuilder[A]]
    @scala.annotation.targetName("docFixedBuilder")
    def doc(doc: String): F[JFixedBuilder[A]]
    @scala.annotation.targetName("namespaceFixedBuilder")
    def namespace(namespace: String): F[JFixedBuilder[A]]
    @scala.annotation.targetName("propFixedBuilder")
    def prop(name: String, `val`: String): F[JFixedBuilder[A]]
    def size(size: Int): F[A]
  extension [A] (fad: F[JFixedDefault[A]])
    def fixedDefault(defaultVal: Array[Byte]): F[JFieldAssembler[A]]
    def fixedDefault(defaultVal: ByteBuffer): F[JFieldAssembler[A]]
    def fixedDefault(defaultVal: String): F[JFieldAssembler[A]]
    @scala.annotation.targetName("noDefaultFixedDefault")
    def noDefault: F[JFieldAssembler[A]]
  extension [A] (fgd: F[JGenericDefault[A]])
    @scala.annotation.targetName("noDefaultGenericDefault")
    def noDefault: F[JFieldAssembler[A]]
    def withDefault(defaultVal: Any): F[JFieldAssembler[A]]
  extension [A] (fib: F[JIntBuilder[A]])
    def endInt: F[A]
    @scala.annotation.targetName("propIntBuilder")
    def prop(name: String, `val`: String): F[JIntBuilder[A]]
  extension [A] (fid: F[JIntDefault[A]])
    def intDefault(defaultVal: Int): F[JFieldAssembler[A]]
    @scala.annotation.targetName("noDefaultIntDefault")
    def noDefault: F[JFieldAssembler[A]]
  extension [A] (flb: F[JLongBuilder[A]])
    def endLong: F[A]
    @scala.annotation.targetName("propLongBuilder")
    def prop(name: String, `val`: String): F[JLongBuilder[A]]
  extension [A] (fld: F[JLongDefault[A]])
    def longDefault(defaultVal: Long): F[JFieldAssembler[A]]
    @scala.annotation.targetName("noDefaultLongDefault")
    def noDefault: F[JFieldAssembler[A]]
  extension [A] (fmb: F[JMapBuilder[A]])
    @scala.annotation.targetName("propMapBuilder")
    def prop(name: String, `val`: String): F[JMapBuilder[A]]
    def values: F[JTypeBuilder[A]]
    def values(valueSchema: Schema): F[A]
  extension [A] (fmd: F[JMapDefault[A]])
    def mapDefault[V](defaultVal: Map[String, V]): F[JFieldAssembler[A]]
    @scala.annotation.targetName("noDefaultMapDefault")
    def noDefault: F[JFieldAssembler[A]]
  extension [A] (fnb: F[JNullBuilder[A]])
    def endNull: F[A]
    @scala.annotation.targetName("propNullBuilder")
    def prop(name: String, `val`: String): F[JNullBuilder[A]]
  extension [A] (fnd: F[JNullDefault[A]])
    @scala.annotation.targetName("noDefaultNullDefault")
    def noDefault: F[JFieldAssembler[A]]
    def nullDefault(): F[JFieldAssembler[A]]
  extension [A] (frb: F[JRecordBuilder[A]])
    @scala.annotation.targetName("aliasesRecordBuilder")
    def aliases(aliases: String*): F[JRecordBuilder[A]]
    @scala.annotation.targetName("docRecordBuilder")
    def doc(doc: String): F[JRecordBuilder[A]]
    def fields: F[JFieldAssembler[A]]
    @scala.annotation.targetName("namespaceRecordBuilder")
    def namespace(namespace: String): F[JRecordBuilder[A]]
    @scala.annotation.targetName("propRecordBuilder")
    def prop(name: String, `val`: String): F[JRecordBuilder[A]]
  extension [A] (frd: F[JRecordDefault[A]])
    @scala.annotation.targetName("noDefaultRecordDefault")
    def noDefault: F[JFieldAssembler[A]]
    def recordDefault(defaultVal: GenericRecord): F[JFieldAssembler[A]]
  extension [A] (fsb: F[JStringBuilder[A]])
    def endString: F[A]
    @scala.annotation.targetName("propStringBuilder")
    def prop(name: String, `val`: String): F[JStringBuilder[A]]
  extension [A] (fsd: F[JStringDefault[A]])
    @scala.annotation.targetName("noDefaultStringDefault")
    def noDefault: F[JFieldAssembler[A]]
    def stringDefault(defaultVal: String): F[JFieldAssembler[A]]
  extension [A] (ftb: F[JTypeBuilder[A]])
    @scala.annotation.targetName("arrayBuilderTypeBuilder")
    def array: F[JArrayBuilder[A]]
    @scala.annotation.targetName("booleanBuilderTypeBuilder")
    def booleanBuilder: F[JBooleanBuilder[A]]
    @scala.annotation.targetName("booleanTypeTypeBuilder")
    def booleanType: F[A]
    @scala.annotation.targetName("bytesBuilderTypeBuilder")
    def bytesBuilder: F[JBytesBuilder[A]]
    @scala.annotation.targetName("bytesTypeTypeBuilder")
    def bytesType: F[A]
    @scala.annotation.targetName("doubleBuilderTypeBuilder")
    def doubleBuilder: F[JDoubleBuilder[A]]
    @scala.annotation.targetName("doubleTypeTypeBuilder")
    def doubleType: F[A]
    @scala.annotation.targetName("enumerationTypeBuilder")
    def enumeration(name: String): F[JEnumBuilder[A]]
    @scala.annotation.targetName("fixedTypeBuilder")
    def fixed(name: String): F[JFixedBuilder[A]]
    @scala.annotation.targetName("floatBuilderTypeBuilder")
    def floatBuilder: F[JFloatBuilder[A]]
    @scala.annotation.targetName("floatTypeTypeBuilder")
    def floatType: F[A]
    @scala.annotation.targetName("intBuilderTypeBuilder")
    def intBuilder: F[JIntBuilder[A]]
    @scala.annotation.targetName("intTypeTypeBuilder")
    def intType: F[A]
    @scala.annotation.targetName("longBuilderTypeBuilder")
    def longBuilder: F[JLongBuilder[A]]
    @scala.annotation.targetName("longTypeTypeBuilder")
    def longType: F[A]
    @scala.annotation.targetName("mapTypeBuilder")
    def map: F[JMapBuilder[A]]
    @scala.annotation.targetName("nullBuilderTypeBuilder")
    def nullBuilder: F[JNullBuilder[A]]
    @scala.annotation.targetName("nullTypeTypeBuilder")
    def nullType: F[A]
    @scala.annotation.targetName("recordTypeBuilder")
    def record(name: String): F[JRecordBuilder[A]]
    @scala.annotation.targetName("stringBuilderTypeBuilder")
    def stringBuilder: F[JStringBuilder[A]]
    @scala.annotation.targetName("stringTypeTypeBuilder")
    def stringType: F[A]
    @scala.annotation.targetName("typeSchemaTypeBuilder")
    def `type`(schema: Schema): F[A]
    @scala.annotation.targetName("typeNameTypeBuilder")
    def `type`(name: String): F[A]
    @scala.annotation.targetName("typeFullNameTypeBuilder")
    def `type`(name: String, namespace: String): F[A]
    @scala.annotation.targetName("unionOfTypeBuilder")
    def unionOf: F[JBaseTypeBuilder[JUnionAccumulator[A]]]
  extension [A] (fua: F[JUnionAccumulator[A]])
    def and: F[JBaseTypeBuilder[JUnionAccumulator[A]]]
    def endUnion: F[A]
  extension [A] (fuftb: F[JUnionFieldTypeBuilder[A]])
    def array: F[JArrayBuilder[JUnionAccumulator[JArrayDefault[A]]]]
    def booleanBuilder: F[JBooleanBuilder[JUnionAccumulator[JBooleanDefault[A]]]]
    def booleanType: F[JUnionAccumulator[JBooleanDefault[A]]]
    def bytesBuilder: F[JBytesBuilder[JUnionAccumulator[JBytesDefault[A]]]]
    def bytesType: F[JUnionAccumulator[JBytesDefault[A]]]
    def doubleBuilder: F[JDoubleBuilder[JUnionAccumulator[JDoubleDefault[A]]]]
    def doubleType: F[JUnionAccumulator[JDoubleDefault[A]]]
    def enumeration(name: String): F[JEnumBuilder[JUnionAccumulator[JEnumDefault[A]]]]
    def fixed(name: String): F[JFixedBuilder[JUnionAccumulator[JFixedDefault[A]]]]
    def floatBuilder: F[JFloatBuilder[JUnionAccumulator[JFloatDefault[A]]]]
    def floatType: F[JUnionAccumulator[JFloatDefault[A]]]
    def intBuilder: F[JIntBuilder[JUnionAccumulator[JIntDefault[A]]]]
    def intType: F[JUnionAccumulator[JIntDefault[A]]]
    def longBuilder: F[JLongBuilder[JUnionAccumulator[JLongDefault[A]]]]
    def longType: F[JUnionAccumulator[JLongDefault[A]]]
    def map: F[JMapBuilder[JUnionAccumulator[JMapDefault[A]]]]
    def nullBuilder: F[JNullBuilder[JUnionAccumulator[JNullDefault[A]]]]
    def nullType: F[JUnionAccumulator[JNullDefault[A]]]
    def record(name: String): F[JRecordBuilder[JUnionAccumulator[JRecordDefault[A]]]]
    def stringBuilder: F[JStringBuilder[JUnionAccumulator[JStringDefault[A]]]]
    def stringType: F[JUnionAccumulator[JStringDefault[A]]]


object SchemaBuilder:

  given apply[F[_]: Sync](
    using
      AB: SchemaBuilder.ArrayBuilder[F],
      AD: SchemaBuilder.ArrayDefault[F],
      BAF: SchemaBuilder.BaseFieldTypeBuilder[F],
      BAT: SchemaBuilder.BaseTypeBuilder[F],
      BOB: SchemaBuilder.BooleanBuilder[F],
      BOD: SchemaBuilder.BooleanDefault[F],
      BYB: SchemaBuilder.BytesBuilder[F],
      BYD: SchemaBuilder.BytesDefault[F],
      DB: SchemaBuilder.DoubleBuilder[F],
      DD: SchemaBuilder.DoubleDefault[F],
      EB: SchemaBuilder.EnumBuilder[F],
      ED: SchemaBuilder.EnumDefault[F],
      FA: SchemaBuilder.FieldAssembler[F],
      FB: SchemaBuilder.FieldBuilder[F],
      FD: SchemaBuilder.FieldDefault[F],
      FXB: SchemaBuilder.FixedBuilder[F],
      FXD: SchemaBuilder.FixedDefault[F],
      FTB: SchemaBuilder.FieldTypeBuilder[F],
      GD: SchemaBuilder.GenericDefault[F],
      IB: SchemaBuilder.IntBuilder[F],
      ID: SchemaBuilder.IntDefault[F],
      LB: SchemaBuilder.LongBuilder[F],
      LD: SchemaBuilder.LongDefault[F],
      MB: SchemaBuilder.MapBuilder[F],
      MD: SchemaBuilder.MapDefault[F],
      NMB: SchemaBuilder.NamedBuilder[F],
      NSB: SchemaBuilder.NamespacedBuilder[F],
      NB: SchemaBuilder.NullBuilder[F],
      ND: SchemaBuilder.NullDefault[F],
      PB: SchemaBuilder.PropBuilder[F],
      RB: SchemaBuilder.RecordBuilder[F],
      RD: SchemaBuilder.RecordDefault[F],
      SB: SchemaBuilder.StringBuilder[F],
      SD: SchemaBuilder.StringDefault[F],
      TB: SchemaBuilder.TypeBuilder[F],
      UA: SchemaBuilder.UnionAccumulator[F],
      UFTB: SchemaBuilder.UnionFieldTypeBuilder[F],
  ): SchemaBuilder[F] =
    new SchemaBuilder[F]:

      def array: F[JArrayBuilder[Schema]] =
        Sync[F].delay(org.apache.avro.SchemaBuilder.array())
      def builder: F[JTypeBuilder[Schema]] =
        Sync[F].delay(org.apache.avro.SchemaBuilder.builder())
      def builder(namespace: String): F[JTypeBuilder[Schema]] =
        Sync[F].delay(org.apache.avro.SchemaBuilder.builder(namespace))
      def enumeration(name: String): F[JEnumBuilder[Schema]] =
        Sync[F].delay(org.apache.avro.SchemaBuilder.enumeration(name))
      def fixed(name: String): F[JFixedBuilder[Schema]] =
        Sync[F].delay(org.apache.avro.SchemaBuilder.fixed(name))
      def map: F[JMapBuilder[Schema]] =
        Sync[F].delay(org.apache.avro.SchemaBuilder.map())
      def nullable: F[JBaseTypeBuilder[Schema]] =
        Sync[F].delay(org.apache.avro.SchemaBuilder.nullable())
      def record(name: String): F[JRecordBuilder[Schema]] =
        Sync[F].delay(org.apache.avro.SchemaBuilder.record(name))
      def unionOf: F[JBaseTypeBuilder[JUnionAccumulator[Schema]]] =
        Sync[F].delay(org.apache.avro.SchemaBuilder.unionOf())

      extension [A] (fab: F[JArrayBuilder[A]])
        def items: F[JTypeBuilder[A]] =
          fab.flatMap(ab => AB.items(ab))
        def items(itemsSchema: Schema): F[A] =
          fab.flatMap(ab => AB.items(ab)(itemsSchema))
        @scala.annotation.targetName("propArrayBuilder")
        def prop(name: String, `val`: String): F[JArrayBuilder[A]] =
          fab.flatMap(ab => PB.prop(ab)(name, `val`))

      extension [A] (fad: F[JArrayDefault[A]])
        def arrayDefault[V](defaultVal: List[V]): F[JFieldAssembler[A]] =
          fad.flatMap(ad => AD.arrayDefault(ad)(defaultVal))
        @scala.annotation.targetName("noDefaultArrayDefault")
        def noDefault: F[JFieldAssembler[A]] =
          fad.flatMap(ad => FD.noDefault(ad))

      extension [A] (fbftb: F[JBaseFieldTypeBuilder[A]])
        @scala.annotation.targetName("arrayBuilderBaseFieldTypeBuilder")
        def array: F[JArrayBuilder[JArrayDefault[A]]] =
          fbftb.flatMap(ftb => BAF.array(ftb))
        @scala.annotation.targetName("booleanBuilderBaseFieldTypeBuilder")
        def booleanBuilder: F[JBooleanBuilder[JBooleanDefault[A]]] =
          fbftb.flatMap(ftb => BAF.booleanBuilder(ftb))
        @scala.annotation.targetName("booleanTypeBaseFieldTypeBuilder")
        def booleanType: F[JBooleanDefault[A]] =
          fbftb.flatMap(ftb => BAF.booleanType(ftb))
        @scala.annotation.targetName("bytesBuilderBaseFieldTypeBuilder")
        def bytesBuilder: F[JBytesBuilder[JBytesDefault[A]]] =
          fbftb.flatMap(ftb => BAF.bytesBuilder(ftb))
        @scala.annotation.targetName("bytesTypeBaseFieldTypeBuilder")
        def bytesType: F[JBytesDefault[A]] =
          fbftb.flatMap(ftb => BAF.bytesType(ftb))
        @scala.annotation.targetName("doubleBuilderBaseFieldTypeBuilder")
        def doubleBuilder: F[JDoubleBuilder[JDoubleDefault[A]]] =
          fbftb.flatMap(ftb => BAF.doubleBuilder(ftb))
        @scala.annotation.targetName("doubleTypeBaseFieldTypeBuilder")
        def doubleType: F[JDoubleDefault[A]] =
          fbftb.flatMap(ftb => BAF.doubleType(ftb))
        @scala.annotation.targetName("enumerationBaseFieldTypeBuilder")
        def enumeration(name: String): F[JEnumBuilder[JEnumDefault[A]]] =
          fbftb.flatMap(ftb => BAF.enumeration(ftb)(name))
        @scala.annotation.targetName("fixedBaseFieldTypeBuilder")
        def fixed(name: String): F[JFixedBuilder[JFixedDefault[A]]] =
          fbftb.flatMap(ftb => BAF.fixed(ftb)(name))
        @scala.annotation.targetName("floatBuilderBaseFieldTypeBuilder")
        def floatBuilder: F[JFloatBuilder[JFloatDefault[A]]] =
          fbftb.flatMap(ftb => BAF.floatBuilder(ftb))
        @scala.annotation.targetName("floatTypeBaseFieldTypeBuilder")
        def floatType: F[JFloatDefault[A]] =
          fbftb.flatMap(ftb => BAF.floatType(ftb))
        @scala.annotation.targetName("intBuilderBaseFieldTypeBuilder")
        def intBuilder: F[JIntBuilder[JIntDefault[A]]] =
          fbftb.flatMap(ftb => BAF.intBuilder(ftb))
        @scala.annotation.targetName("intTypeBaseFieldTypeBuilder")
        def intType: F[JIntDefault[A]] =
          fbftb.flatMap(ftb => BAF.intType(ftb))
        @scala.annotation.targetName("longBuilderBaseFieldTypeBuilder")
        def longBuilder: F[JLongBuilder[JLongDefault[A]]] =
          fbftb.flatMap(ftb => BAF.longBuilder(ftb))
        @scala.annotation.targetName("longTypeBaseFieldTypeBuilder")
        def longType: F[JLongDefault[A]] =
          fbftb.flatMap(ftb => BAF.longType(ftb))
        @scala.annotation.targetName("mapBaseFieldTypeBuilder")
        def map: F[JMapBuilder[JMapDefault[A]]] =
          fbftb.flatMap(ftb => BAF.map(ftb))
        @scala.annotation.targetName("nullBuilderBaseFieldTypeBuilder")
        def nullBuilder: F[JNullBuilder[JNullDefault[A]]] =
          fbftb.flatMap(ftb => BAF.nullBuilder(ftb))
        @scala.annotation.targetName("nullTypeBaseFieldTypeBuilder")
        def nullType: F[JNullDefault[A]] =
          fbftb.flatMap(ftb => BAF.nullType(ftb))
        @scala.annotation.targetName("recordBaseFieldTypeBuilder")
        def record(name: String): F[JRecordBuilder[JRecordDefault[A]]] =
          fbftb.flatMap(ftb => BAF.record(ftb)(name))
        @scala.annotation.targetName("stringBuilderBaseFieldTypeBuilder")
        def stringBuilder: F[JStringBuilder[JStringDefault[A]]] =
          fbftb.flatMap(ftb => BAF.stringBuilder(ftb))
        @scala.annotation.targetName("stringTypeBaseFieldTypeBuilder")
        def stringType: F[JStringDefault[A]] =
          fbftb.flatMap(ftb => BAF.stringType(ftb))

      extension [A] (fbtb: F[JBaseTypeBuilder[A]])
        @scala.annotation.targetName("arrayBuilderBaseTypeBuilder")
        def array: F[JArrayBuilder[A]] =
          fbtb.flatMap(btb => BAT.array(btb))
        @scala.annotation.targetName("booleanBuilderBaseTypeBuilder")
        def booleanBuilder: F[JBooleanBuilder[A]] =
          fbtb.flatMap(btb => BAT.booleanBuilder(btb))
        @scala.annotation.targetName("booleanTypeBaseTypeBuilder")
        def booleanType: F[A] =
          fbtb.flatMap(btb => BAT.booleanType(btb))
        @scala.annotation.targetName("bytesBuilderBaseTypeBuilder")
        def bytesBuilder: F[JBytesBuilder[A]] =
          fbtb.flatMap(btb => BAT.bytesBuilder(btb))
        @scala.annotation.targetName("bytesTypeBaseTypeBuilder")
        def bytesType: F[A] =
          fbtb.flatMap(btb => BAT.bytesType(btb))
        @scala.annotation.targetName("doubleBuilderBaseTypeBuilder")
        def doubleBuilder: F[JDoubleBuilder[A]] =
          fbtb.flatMap(btb => BAT.doubleBuilder(btb))
        @scala.annotation.targetName("doubleTypeBaseTypeBuilder")
        def doubleType: F[A] =
          fbtb.flatMap(btb => BAT.doubleType(btb))
        @scala.annotation.targetName("enumerationBaseTypeBuilder")
        def enumeration(name: String): F[JEnumBuilder[A]] =
          fbtb.flatMap(btb => BAT.enumeration(btb)(name))
        @scala.annotation.targetName("fixedBaseTypeBuilder")
        def fixed(name: String): F[JFixedBuilder[A]] =
          fbtb.flatMap(btb => BAT.fixed(btb)(name))
        @scala.annotation.targetName("floatBuilderBaseTypeBuilder")
        def floatBuilder: F[JFloatBuilder[A]] =
          fbtb.flatMap(btb => BAT.floatBuilder(btb))
        @scala.annotation.targetName("floatTypeBaseTypeBuilder")
        def floatType: F[A] =
          fbtb.flatMap(btb => BAT.floatType(btb))
        @scala.annotation.targetName("intBuilderBaseTypeBuilder")
        def intBuilder: F[JIntBuilder[A]] =
          fbtb.flatMap(btb => BAT.intBuilder(btb))
        @scala.annotation.targetName("intTypeBaseTypeBuilder")
        def intType: F[A] =
          fbtb.flatMap(btb => BAT.intType(btb))
        @scala.annotation.targetName("longBuilderBaseTypeBuilder")
        def longBuilder: F[JLongBuilder[A]] =
          fbtb.flatMap(btb => BAT.longBuilder(btb))
        @scala.annotation.targetName("longTypeBaseTypeBuilder")
        def longType: F[A] =
          fbtb.flatMap(btb => BAT.longType(btb))
        @scala.annotation.targetName("mapBaseTypeBuilder")
        def map: F[JMapBuilder[A]] =
          fbtb.flatMap(btb => BAT.map(btb))
        @scala.annotation.targetName("nullBuilderBaseTypeBuilder")
        def nullBuilder: F[JNullBuilder[A]] =
          fbtb.flatMap(btb => BAT.nullBuilder(btb))
        @scala.annotation.targetName("nullTypeBaseTypeBuilder")
        def nullType: F[A] =
          fbtb.flatMap(btb => BAT.nullType(btb))
        @scala.annotation.targetName("recordBaseTypeBuilder")
        def record(name: String): F[JRecordBuilder[A]] =
          fbtb.flatMap(btb => BAT.record(btb)(name))
        @scala.annotation.targetName("stringBuilderBaseTypeBuilder")
        def stringBuilder: F[JStringBuilder[A]] =
          fbtb.flatMap(btb => BAT.stringBuilder(btb))
        @scala.annotation.targetName("stringTypeBaseTypeBuilder")
        def stringType: F[A] =
          fbtb.flatMap(btb => BAT.stringType(btb))
        @scala.annotation.targetName("typeSchemaBaseTypeBuilder")
        def `type`(schema: Schema): F[A] =
          fbtb.flatMap(btb => BAT.`type`(btb)(schema))
        @scala.annotation.targetName("typeNameBaseTypeBuilder")
        def `type`(name: String): F[A] =
          fbtb.flatMap(btb => BAT.`type`(btb)(name))
        @scala.annotation.targetName("typeFullNameBaseTypeBuilder")
        def `type`(name: String, namespace: String): F[A] =
          fbtb.flatMap(btb => BAT.`type`(btb)(name, namespace))

      extension [A] (fbb: F[JBooleanBuilder[A]])
        def endBoolean: F[A] =
          fbb.flatMap(bb => BOB.endBoolean(bb))
        @scala.annotation.targetName("propBooleanBuilder")
        def prop(name: String, `val`: String): F[JBooleanBuilder[A]] =
          fbb.flatMap(ab => PB.prop(ab)(name, `val`))

      extension [A] (fbd: F[JBooleanDefault[A]])
        def booleanDefault(defaultVal: Boolean): F[JFieldAssembler[A]] =
          fbd.flatMap(bd => BOD.booleanDefault(bd)(defaultVal))
        @scala.annotation.targetName("noDefaultBooleanDefault")
        def noDefault: F[JFieldAssembler[A]] =
          fbd.flatMap(bd => FD.noDefault(bd))

      extension [A] (fabb: F[JBytesBuilder[A]])
        def endBytes: F[A] =
          fabb.flatMap(abb => BYB.endBytes(abb))
        @scala.annotation.targetName("propBytesBuilder")
        def prop(name: String, `val`: String): F[JBytesBuilder[A]] =
          fabb.flatMap(abb => PB.prop(abb)(name, `val`))

      extension [A] (fbd: F[JBytesDefault[A]])
        def bytesDefault(defaultVal: Array[Byte]): F[JFieldAssembler[A]] =
          fbd.flatMap(bd => BYD.bytesDefault(bd)(defaultVal))
        def bytesDefault(defaultVal: ByteBuffer): F[JFieldAssembler[A]] =
          fbd.flatMap(bd => BYD.bytesDefault(bd)(defaultVal))
        def bytesDefault(defaultVal: String): F[JFieldAssembler[A]] =
          fbd.flatMap(bd => BYD.bytesDefault(bd)(defaultVal))
        @scala.annotation.targetName("noDefaultBytesDefault")
        def noDefault: F[JFieldAssembler[A]] =
          fbd.flatMap(bd => FD.noDefault(bd))

      extension [A] (fdb: F[JDoubleBuilder[A]])
        def endDouble: F[A] =
          fdb.flatMap(db => DB.endDouble(db))
        @scala.annotation.targetName("propDoubleBuilder")
        def prop(name: String, `val`: String): F[JDoubleBuilder[A]] =
          fdb.flatMap(db => PB.prop(db)(name, `val`))

      extension [A] (fdd: F[JDoubleDefault[A]])
        def doubleDefault(defaultVal: Double): F[JFieldAssembler[A]] =
          fdd.flatMap(dd => DD.doubleDefault(dd)(defaultVal))
        @scala.annotation.targetName("noDefaultDoubleDefault")
        def noDefault: F[JFieldAssembler[A]] =
          fdd.flatMap(dd => FD.noDefault(dd))

      extension [A] (feb: F[JEnumBuilder[A]])
        @scala.annotation.targetName("aliasesEnumBuilder")
        def aliases(aliases: String*): F[JEnumBuilder[A]] =
          feb.flatMap(eb => NMB.aliases(eb)(aliases*))
        @scala.annotation.targetName("docEnumBuilder")
        def doc(doc: String): F[JEnumBuilder[A]] =
          feb.flatMap(eb => NMB.doc(eb)(doc))
        @scala.annotation.targetName("namespaceEnumBuilder")
        def namespace(namespace: String): F[JEnumBuilder[A]] =
          feb.flatMap(eb => NSB.namespace(eb)(namespace))
        @scala.annotation.targetName("propEnumBuilder")
        def prop(name: String, `val`: String): F[JEnumBuilder[A]] =
          feb.flatMap(eb => PB.prop(eb)(name, `val`))
        def symbols(symbols: String*): F[A] =
          feb.flatMap(eb => EB.symbols(eb)(symbols*))

      extension [A] (fed: F[JEnumDefault[A]])
        def enumDefault(defaultVal: String): F[JFieldAssembler[A]] =
          fed.flatMap(ed => ED.enumDefault(ed)(defaultVal))
        @scala.annotation.targetName("noDefaultEnumDefault")
        def noDefault: F[JFieldAssembler[A]] =
          fed.flatMap(ed => FD.noDefault(ed))

      extension [A] (ffa: F[JFieldAssembler[A]])
        def endRecord: F[A] =
          ffa.flatMap(fa => FA.endRecord(fa))
        def name(fieldName: String): F[JFieldBuilder[A]] =
          ffa.flatMap(fa => FA.name(fa)(fieldName))
    
      extension [A] (ffb: F[JFieldBuilder[A]])
        @scala.annotation.targetName("aliasesFieldBuilder")
        def aliases(aliases: String*): F[JFieldBuilder[A]] =
          ffb.flatMap(fb => NMB.aliases(fb)(aliases*))
        @scala.annotation.targetName("docFieldBuilder")
        def doc(doc: String): F[JFieldBuilder[A]] =
          ffb.flatMap(fb => NMB.doc(fb)(doc))
        def orderAscending: F[JFieldBuilder[A]] =
          ffb.flatMap(fb => FB.orderAscending(fb))
        def orderDescending: F[JFieldBuilder[A]] =
          ffb.flatMap(fb => FB.orderAscending(fb))
        def orderIgnore: F[JFieldBuilder[A]] =
          ffb.flatMap(fb => FB.orderAscending(fb))
        @scala.annotation.targetName("propFieldBuilder")
        def prop(name: String, `val`: String): F[JFieldBuilder[A]] =
          ffb.flatMap(fb => PB.prop(fb)(name, `val`))
        @scala.annotation.targetName("typeFieldBuilder")
        def `type`: F[JFieldTypeBuilder[A]] =
          ffb.flatMap(fb => FB.`type`(fb))
        @scala.annotation.targetName("typeSchemaFieldBuilder")
        def `type`(schema: Schema): F[JGenericDefault[A]] =
          ffb.flatMap(fb => FB.`type`(fb)(schema))
        @scala.annotation.targetName("typeNameFieldBuilder")
        def `type`(name: String): F[JGenericDefault[A]] =
          ffb.flatMap(fb => FB.`type`(fb)(name))
        @scala.annotation.targetName("typeFullNameFieldBuilder")
        def `type`(name: String, namespace: String): F[JGenericDefault[A]] =
          ffb.flatMap(fb => FB.`type`(fb)(name, namespace))

      extension [A, U <: JFieldDefault[A, U]] (ffd: F[JFieldDefault[A, U]])
        def noDefault: F[JFieldAssembler[A]] =
          ffd.flatMap(fd => FD.noDefault(fd))

      extension [A] (fftb: F[JFieldTypeBuilder[A]])
        @scala.annotation.targetName("arrayBuilderFieldTypeBuilder")
        def array: F[JArrayBuilder[JArrayDefault[A]]] =
          fftb.flatMap(ftb => FTB.array(ftb))
        @scala.annotation.targetName("booleanBuilderFieldTypeBuilder")
        def booleanBuilder: F[JBooleanBuilder[JBooleanDefault[A]]] =
          fftb.flatMap(ftb => FTB.booleanBuilder(ftb))
        @scala.annotation.targetName("booleanTypeFieldTypeBuilder")
        def booleanType: F[JBooleanDefault[A]] =
          fftb.flatMap(ftb => FTB.booleanType(ftb))
        @scala.annotation.targetName("bytesBuilderFieldTypeBuilder")
        def bytesBuilder: F[JBytesBuilder[JBytesDefault[A]]] =
          fftb.flatMap(ftb => FTB.bytesBuilder(ftb))
        @scala.annotation.targetName("bytesTypeFieldTypeBuilder")
        def bytesType: F[JBytesDefault[A]] =
          fftb.flatMap(ftb => FTB.bytesType(ftb))
        @scala.annotation.targetName("doubleBuilderFieldTypeBuilder")
        def doubleBuilder: F[JDoubleBuilder[JDoubleDefault[A]]] =
          fftb.flatMap(ftb => FTB.doubleBuilder(ftb))
        @scala.annotation.targetName("doubleTypeFieldTypeBuilder")
        def doubleType: F[JDoubleDefault[A]] =
          fftb.flatMap(ftb => FTB.doubleType(ftb))
        @scala.annotation.targetName("enumerationFieldTypeBuilder")
        def enumeration(name: String): F[JEnumBuilder[JEnumDefault[A]]] =
          fftb.flatMap(ftb => FTB.enumeration(ftb)(name))
        @scala.annotation.targetName("fixedFieldTypeBuilder")
        def fixed(name: String): F[JFixedBuilder[JFixedDefault[A]]] =
          fftb.flatMap(ftb => FTB.fixed(ftb)(name))
        @scala.annotation.targetName("floatBuilderFieldTypeBuilder")
        def floatBuilder: F[JFloatBuilder[JFloatDefault[A]]] =
          fftb.flatMap(ftb => FTB.floatBuilder(ftb))
        @scala.annotation.targetName("floatTypeFieldTypeBuilder")
        def floatType: F[JFloatDefault[A]] =
          fftb.flatMap(ftb => FTB.floatType(ftb))
        @scala.annotation.targetName("intBuilderFieldTypeBuilder")
        def intBuilder: F[JIntBuilder[JIntDefault[A]]] =
          fftb.flatMap(ftb => FTB.intBuilder(ftb))
        @scala.annotation.targetName("intTypeFieldTypeBuilder")
        def intType: F[JIntDefault[A]] =
          fftb.flatMap(ftb => FTB.intType(ftb))
        @scala.annotation.targetName("longBuilderFieldTypeBuilder")
        def longBuilder: F[JLongBuilder[JLongDefault[A]]] =
          fftb.flatMap(ftb => FTB.longBuilder(ftb))
        @scala.annotation.targetName("longTypeFieldTypeBuilder")
        def longType: F[JLongDefault[A]] =
          fftb.flatMap(ftb => FTB.longType(ftb))
        @scala.annotation.targetName("mapFieldTypeBuilder")
        def map: F[JMapBuilder[JMapDefault[A]]] =
          fftb.flatMap(ftb => FTB.map(ftb))
        @scala.annotation.targetName("nullBuilderFieldTypeBuilder")
        def nullBuilder: F[JNullBuilder[JNullDefault[A]]] =
          fftb.flatMap(ftb => FTB.nullBuilder(ftb))
        @scala.annotation.targetName("nullTypeFieldTypeBuilder")
        def nullType: F[JNullDefault[A]] =
          fftb.flatMap(ftb => FTB.nullType(ftb))
        @scala.annotation.targetName("recordFieldTypeBuilder")
        def record(name: String): F[JRecordBuilder[JRecordDefault[A]]] =
          fftb.flatMap(ftb => FTB.record(ftb)(name))
        @scala.annotation.targetName("stringBuilderFieldTypeBuilder")
        def stringBuilder: F[JStringBuilder[JStringDefault[A]]] =
          fftb.flatMap(ftb => FTB.stringBuilder(ftb))
        @scala.annotation.targetName("stringTypeFieldTypeBuilder")
        def stringType: F[JStringDefault[A]] =
          fftb.flatMap(ftb => FTB.stringType(ftb))

        @scala.annotation.targetName("unionOfFieldTypeBuilder")
        def unionOf: F[JUnionFieldTypeBuilder[A]] =
          fftb.flatMap(ftb => FTB.unionOf(ftb))

      extension [A] (ffxb: F[JFixedBuilder[A]])
        @scala.annotation.targetName("aliasesFixedBuilder")
        def aliases(aliases: String*): F[JFixedBuilder[A]] =
          ffxb.flatMap(fxb => NMB.aliases(fxb)(aliases*))
        @scala.annotation.targetName("docFixedBuilder")
        def doc(doc: String): F[JFixedBuilder[A]] =
          ffxb.flatMap(fxb => NMB.doc(fxb)(doc))
        @scala.annotation.targetName("namespaceFixedBuilder")
        def namespace(namespace: String): F[JFixedBuilder[A]] =
          ffxb.flatMap(fxb => NSB.namespace(fxb)(namespace))
        @scala.annotation.targetName("propFixedBuilder")
        def prop(name: String, `val`: String): F[JFixedBuilder[A]] =
          ffxb.flatMap(fxb => PB.prop(fxb)(name, `val`))
        def size(size: Int): F[A] =
          ffxb.flatMap(fxb => FXB.size(fxb)(size))

      extension [A] (ffxd: F[JFixedDefault[A]])
        def fixedDefault(defaultVal: Array[Byte]): F[JFieldAssembler[A]] =
          ffxd.flatMap(fxd => FXD.fixedDefault(fxd)(defaultVal))
        def fixedDefault(defaultVal: ByteBuffer): F[JFieldAssembler[A]] =
          ffxd.flatMap(fxd => FXD.fixedDefault(fxd)(defaultVal))
        def fixedDefault(defaultVal: String): F[JFieldAssembler[A]] =
          ffxd.flatMap(fxd => FXD.fixedDefault(fxd)(defaultVal))
        @scala.annotation.targetName("noDefaultFixedDefault")
        def noDefault: F[JFieldAssembler[A]] =
          ffxd.flatMap(fxd => FD.noDefault(fxd))

      extension [A] (fgd: F[JGenericDefault[A]])
        @scala.annotation.targetName("noDefaultGenericDefault")
        def noDefault: F[JFieldAssembler[A]] =
          fgd.flatMap(gd => GD.noDefault(gd))
        def withDefault(defaultVal: Any): F[JFieldAssembler[A]] =
          fgd.flatMap(gd => GD.withDefault(gd)(defaultVal))

      extension [A] (fib: F[JIntBuilder[A]])
        def endInt: F[A] =
          fib.flatMap(ib => IB.endInt(ib))
        @scala.annotation.targetName("propIntBuilder")
        def prop(name: String, `val`: String): F[JIntBuilder[A]] =
          fib.flatMap(ib => PB.prop(ib)(name, `val`))

      extension [A] (fid: F[JIntDefault[A]])
        def intDefault(defaultVal: Int): F[JFieldAssembler[A]] =
          fid.flatMap(id => ID.intDefault(id)(defaultVal))
        @scala.annotation.targetName("noDefaultIntDefault")
        def noDefault: F[JFieldAssembler[A]] =
          fid.flatMap(id => FD.noDefault(id))

      extension [A] (flb: F[JLongBuilder[A]])
        def endLong: F[A] =
          flb.flatMap(lb => LB.endLong(lb))
        @scala.annotation.targetName("propLongBuilder")
        def prop(name: String, `val`: String): F[JLongBuilder[A]] =
          flb.flatMap(lb => PB.prop(lb)(name, `val`))

      extension [A] (fld: F[JLongDefault[A]])
        def longDefault(defaultVal: Long): F[JFieldAssembler[A]] =
          fld.flatMap(ld => LD.longDefault(ld)(defaultVal))
        @scala.annotation.targetName("noDefaultLongDefault")
        def noDefault: F[JFieldAssembler[A]] =
          fld.flatMap(ld => FD.noDefault(ld))

      extension [A] (fmb: F[JMapBuilder[A]])
        def values: F[JTypeBuilder[A]] =
          fmb.flatMap(mb => MB.values(mb))
        def values(valueSchema: Schema): F[A] =
          fmb.flatMap(mb => MB.values(mb)(valueSchema))
        @scala.annotation.targetName("propMapBuilder")
        def prop(name: String, `val`: String): F[JMapBuilder[A]] =
          fmb.flatMap(mb => PB.prop(mb)(name, `val`))

      extension [A] (fmd: F[JMapDefault[A]])
        def mapDefault[V](defaultVal: Map[String, V]): F[JFieldAssembler[A]] =
          fmd.flatMap(md => MD.mapDefault(md)(defaultVal))
        @scala.annotation.targetName("noDefaultMapDefault")
        def noDefault: F[JFieldAssembler[A]] =
          fmd.flatMap(md => FD.noDefault(md))

      extension [A] (fnb: F[JNullBuilder[A]])
        def endNull: F[A] =
          fnb.flatMap(nb => NB.endNull(nb))
        @scala.annotation.targetName("propNullBuilder")
        def prop(name: String, `val`: String): F[JNullBuilder[A]] =
          fnb.flatMap(nb => PB.prop(nb)(name, `val`))

      extension [A] (fnd: F[JNullDefault[A]])
        def nullDefault(): F[JFieldAssembler[A]] =
          fnd.flatMap(nd => ND.nullDefault(nd))
        @scala.annotation.targetName("noDefaultNullDefault")
        def noDefault: F[JFieldAssembler[A]] =
          fnd.flatMap(nd => FD.noDefault(nd))

      extension [A] (frb: F[JRecordBuilder[A]])
        @scala.annotation.targetName("aliasesRecordBuilder")
        def aliases(aliases: String*): F[JRecordBuilder[A]] =
          frb.flatMap(rb => NMB.aliases(rb)(aliases*))
        @scala.annotation.targetName("docRecordBuilder")
        def doc(doc: String): F[JRecordBuilder[A]] =
          frb.flatMap(rb => NMB.doc(rb)(doc))
        def fields: F[JFieldAssembler[A]] =
          frb.flatMap(rb => RB.fields(rb))
        @scala.annotation.targetName("namespaceRecordBuilder")
        def namespace(namespace: String): F[JRecordBuilder[A]] =
          frb.flatMap(nrb => NSB.namespace(nrb)(namespace))
        @scala.annotation.targetName("propRecordBuilder")
        def prop(name: String, `val`: String): F[JRecordBuilder[A]] =
          frb.flatMap(rb => PB.prop(rb)(name, `val`))

      extension [A] (frd: F[JRecordDefault[A]])
        def recordDefault(defaultVal: GenericRecord): F[JFieldAssembler[A]] =
          frd.flatMap(rd => RD.recordDefault(rd)(defaultVal))
        @scala.annotation.targetName("noDefaultRecordDefault")
        def noDefault: F[JFieldAssembler[A]] =
          frd.flatMap(rd => FD.noDefault(rd))

      extension [A] (fsb: F[JStringBuilder[A]])
        def endString: F[A] =
          fsb.flatMap(sb => SB.endString(sb))
        @scala.annotation.targetName("propStringBuilder")
        def prop(name: String, `val`: String): F[JStringBuilder[A]] =
          fsb.flatMap(sb => PB.prop(sb)(name, `val`))

      extension [A] (fsd: F[JStringDefault[A]])
        def stringDefault(defaultVal: String): F[JFieldAssembler[A]] =
          fsd.flatMap(sd => SD.stringDefault(sd)(defaultVal))
        @scala.annotation.targetName("noDefaultStringDefault")
        def noDefault: F[JFieldAssembler[A]] =
          fsd.flatMap(sd => FD.noDefault(sd))

      extension [A] (ftb: F[JTypeBuilder[A]])
        @scala.annotation.targetName("arrayBuilderTypeBuilder")
        def array: F[JArrayBuilder[A]] =
          ftb.flatMap(tb => BAT.array(tb))
        @scala.annotation.targetName("booleanBuilderTypeBuilder")
        def booleanBuilder: F[JBooleanBuilder[A]] =
          ftb.flatMap(tb => BAT.booleanBuilder(tb))
        @scala.annotation.targetName("booleanTypeTypeBuilder")
        def booleanType: F[A] =
          ftb.flatMap(tb => BAT.booleanType(tb))
        @scala.annotation.targetName("bytesBuilderTypeBuilder")
        def bytesBuilder: F[JBytesBuilder[A]] =
          ftb.flatMap(tb => BAT.bytesBuilder(tb))
        @scala.annotation.targetName("bytesTypeTypeBuilder")
        def bytesType: F[A] =
          ftb.flatMap(tb => BAT.bytesType(tb))
        @scala.annotation.targetName("doubleBuilderTypeBuilder")
        def doubleBuilder: F[JDoubleBuilder[A]] =
          ftb.flatMap(tb => BAT.doubleBuilder(tb))
        @scala.annotation.targetName("doubleTypeTypeBuilder")
        def doubleType: F[A] =
          ftb.flatMap(tb => BAT.doubleType(tb))
        @scala.annotation.targetName("enumerationTypeBuilder")
        def enumeration(name: String): F[JEnumBuilder[A]] =
          ftb.flatMap(tb => BAT.enumeration(tb)(name))
        @scala.annotation.targetName("fixedTypeBuilder")
        def fixed(name: String): F[JFixedBuilder[A]] =
          ftb.flatMap(tb => BAT.fixed(tb)(name))
        @scala.annotation.targetName("floatBuilderTypeBuilder")
        def floatBuilder: F[JFloatBuilder[A]] =
          ftb.flatMap(tb => BAT.floatBuilder(tb))
        @scala.annotation.targetName("floatTypeTypeBuilder")
        def floatType: F[A] =
          ftb.flatMap(tb => BAT.floatType(tb))
        @scala.annotation.targetName("intBuilderTypeBuilder")
        def intBuilder: F[JIntBuilder[A]] =
          ftb.flatMap(tb => BAT.intBuilder(tb))
        @scala.annotation.targetName("intTypeTypeBuilder")
        def intType: F[A] =
          ftb.flatMap(tb => BAT.intType(tb))
        @scala.annotation.targetName("longBuilderTypeBuilder")
        def longBuilder: F[JLongBuilder[A]] =
          ftb.flatMap(tb => BAT.longBuilder(tb))
        @scala.annotation.targetName("longTypeTypeBuilder")
        def longType: F[A] =
          ftb.flatMap(tb => BAT.longType(tb))
        @scala.annotation.targetName("mapTypeBuilder")
        def map: F[JMapBuilder[A]] =
          ftb.flatMap(tb => BAT.map(tb))
        @scala.annotation.targetName("nullBuilderTypeBuilder")
        def nullBuilder: F[JNullBuilder[A]] =
          ftb.flatMap(tb => BAT.nullBuilder(tb))
        @scala.annotation.targetName("nullTypeTypeBuilder")
        def nullType: F[A] =
          ftb.flatMap(tb => BAT.nullType(tb))
        @scala.annotation.targetName("recordTypeBuilder")
        def record(name: String): F[JRecordBuilder[A]] =
          ftb.flatMap(tb => BAT.record(tb)(name))
        @scala.annotation.targetName("stringBuilderTypeBuilder")
        def stringBuilder: F[JStringBuilder[A]] =
          ftb.flatMap(tb => BAT.stringBuilder(tb))
        @scala.annotation.targetName("stringTypeTypeBuilder")
        def stringType: F[A] =
          ftb.flatMap(tb => BAT.stringType(tb))
        @scala.annotation.targetName("typeSchemaTypeBuilder")
        def `type`(schema: Schema): F[A] =
          ftb.flatMap(tb => BAT.`type`(tb)(schema))
        @scala.annotation.targetName("typeNameTypeBuilder")
        def `type`(name: String): F[A] =
          ftb.flatMap(tb => BAT.`type`(tb)(name))
        @scala.annotation.targetName("typeFullNameTypeBuilder")
        def `type`(name: String, namespace: String): F[A] =
          ftb.flatMap(tb => BAT.`type`(tb)(name, namespace))
        @scala.annotation.targetName("unionOfTypeBuilder")
        def unionOf: F[JBaseTypeBuilder[JUnionAccumulator[A]]] =
          ftb.flatMap(tb => TB.unionOf(tb))

      extension [A] (fua: F[JUnionAccumulator[A]])
        def and: F[JBaseTypeBuilder[JUnionAccumulator[A]]] =
          fua.flatMap(ua => UA.and(ua))
        def endUnion: F[A] =
          fua.flatMap(ua => UA.endUnion(ua))

      extension [A] (fuftb: F[JUnionFieldTypeBuilder[A]])
        def array: F[JArrayBuilder[JUnionAccumulator[JArrayDefault[A]]]] =
          fuftb.flatMap(utfb => UFTB.array(utfb))
        def booleanBuilder: F[JBooleanBuilder[JUnionAccumulator[JBooleanDefault[A]]]] =
          fuftb.flatMap(utfb => UFTB.booleanBuilder(utfb))
        def booleanType: F[JUnionAccumulator[JBooleanDefault[A]]] =
          fuftb.flatMap(utfb => UFTB.booleanType(utfb))
        def bytesBuilder: F[JBytesBuilder[JUnionAccumulator[JBytesDefault[A]]]] =
          fuftb.flatMap(utfb => UFTB.bytesBuilder(utfb))
        def bytesType: F[JUnionAccumulator[JBytesDefault[A]]] =
          fuftb.flatMap(utfb => UFTB.bytesType(utfb))
        def doubleBuilder: F[JDoubleBuilder[JUnionAccumulator[JDoubleDefault[A]]]] =
          fuftb.flatMap(utfb => UFTB.doubleBuilder(utfb))
        def doubleType: F[JUnionAccumulator[JDoubleDefault[A]]] =
          fuftb.flatMap(utfb => UFTB.doubleType(utfb))
        def enumeration(name: String): F[JEnumBuilder[JUnionAccumulator[JEnumDefault[A]]]] =
          fuftb.flatMap(utfb => UFTB.enumeration(utfb)(name))
        def fixed(name: String): F[JFixedBuilder[JUnionAccumulator[JFixedDefault[A]]]] =
          fuftb.flatMap(utfb => UFTB.fixed(utfb)(name))
        def floatBuilder: F[JFloatBuilder[JUnionAccumulator[JFloatDefault[A]]]] =
          fuftb.flatMap(utfb => UFTB.floatBuilder(utfb))
        def floatType: F[JUnionAccumulator[JFloatDefault[A]]] =
          fuftb.flatMap(utfb => UFTB.floatType(utfb))
        def intBuilder: F[JIntBuilder[JUnionAccumulator[JIntDefault[A]]]] =
          fuftb.flatMap(utfb => UFTB.intBuilder(utfb))
        def intType: F[JUnionAccumulator[JIntDefault[A]]] =
          fuftb.flatMap(utfb => UFTB.intType(utfb))
        def longBuilder: F[JLongBuilder[JUnionAccumulator[JLongDefault[A]]]] =
          fuftb.flatMap(utfb => UFTB.longBuilder(utfb))
        def longType: F[JUnionAccumulator[JLongDefault[A]]] =
          fuftb.flatMap(utfb => UFTB.longType(utfb))
        def map: F[JMapBuilder[JUnionAccumulator[JMapDefault[A]]]] =
          fuftb.flatMap(utfb => UFTB.map(utfb))
        def nullBuilder: F[JNullBuilder[JUnionAccumulator[JNullDefault[A]]]] =
          fuftb.flatMap(utfb => UFTB.nullBuilder(utfb))
        def nullType: F[JUnionAccumulator[JNullDefault[A]]] =
          fuftb.flatMap(utfb => UFTB.nullType(utfb))
        def record(name: String): F[JRecordBuilder[JUnionAccumulator[JRecordDefault[A]]]] =
          fuftb.flatMap(utfb => UFTB.record(utfb)(name))
        def stringBuilder: F[JStringBuilder[JUnionAccumulator[JStringDefault[A]]]] =
          fuftb.flatMap(utfb => UFTB.stringBuilder(utfb))
        def stringType: F[JUnionAccumulator[JStringDefault[A]]] =
          fuftb.flatMap(utfb => UFTB.stringType(utfb))

  trait ArrayBuilder[F[_]]:
    def items[T](fab: JArrayBuilder[T]): F[JTypeBuilder[T]]
    def items[T](fab: JArrayBuilder[T])(itemsSchema: Schema): F[T]
  object ArrayBuilder:
    given [F[_]: Sync]: ArrayBuilder[F] =
      new ArrayBuilder[F]:
        def items[T](ab: JArrayBuilder[T]): F[JTypeBuilder[T]] =
          Sync[F].delay(ab.items())
        def items[T](ab: JArrayBuilder[T])(itemsSchema: Schema): F[T] =
          Sync[F].delay(ab.items(itemsSchema))

  trait ArrayDefault[F[_]]:
    def arrayDefault[T,V](ad: JArrayDefault[T])(defaultVal: List[V]): F[JFieldAssembler[T]]
  object ArrayDefault:
    given [F[_]: Sync]: ArrayDefault[F] =
      new ArrayDefault[F]:
        def arrayDefault[T, V](ad: JArrayDefault[T])(defaultVal: List[V]): F[JFieldAssembler[T]] =
          Sync[F].delay(ad.arrayDefault(defaultVal.asJava))

  trait BaseFieldTypeBuilder[F[_]]:
    def array[T](bftb: JBaseFieldTypeBuilder[T]): F[JArrayBuilder[JArrayDefault[T]]]
    def booleanBuilder[T](bftb: JBaseFieldTypeBuilder[T]): F[JBooleanBuilder[JBooleanDefault[T]]]
    def booleanType[T](bftb: JBaseFieldTypeBuilder[T]): F[JBooleanDefault[T]]
    def bytesBuilder[T](bftb: JBaseFieldTypeBuilder[T]): F[JBytesBuilder[JBytesDefault[T]]]
    def bytesType[T](bftb: JBaseFieldTypeBuilder[T]): F[JBytesDefault[T]]
    def doubleBuilder[T](bftb: JBaseFieldTypeBuilder[T]): F[JDoubleBuilder[JDoubleDefault[T]]]
    def doubleType[T](bftb: JBaseFieldTypeBuilder[T]): F[JDoubleDefault[T]]
    def enumeration[T](bftb: JBaseFieldTypeBuilder[T])(name: String): F[JEnumBuilder[JEnumDefault[T]]]
    def fixed[T](bftb: JBaseFieldTypeBuilder[T])(name: String): F[JFixedBuilder[JFixedDefault[T]]]
    def floatBuilder[T](bftb: JBaseFieldTypeBuilder[T]): F[JFloatBuilder[JFloatDefault[T]]]
    def floatType[T](bftb: JBaseFieldTypeBuilder[T]): F[JFloatDefault[T]]
    def intBuilder[T](bftb: JBaseFieldTypeBuilder[T]): F[JIntBuilder[JIntDefault[T]]]
    def intType[T](bftb: JBaseFieldTypeBuilder[T]): F[JIntDefault[T]]
    def longBuilder[T](bftb: JBaseFieldTypeBuilder[T]): F[JLongBuilder[JLongDefault[T]]]
    def longType[T](bftb: JBaseFieldTypeBuilder[T]): F[JLongDefault[T]]
    def map[T](bftb: JBaseFieldTypeBuilder[T]): F[JMapBuilder[JMapDefault[T]]]
    def nullBuilder[T](bftb: JBaseFieldTypeBuilder[T]): F[JNullBuilder[JNullDefault[T]]]
    def nullType[T](bftb: JBaseFieldTypeBuilder[T]): F[JNullDefault[T]]
    def record[T](bftb: JBaseFieldTypeBuilder[T])(name: String): F[JRecordBuilder[JRecordDefault[T]]]
    def stringBuilder[T](bftb: JBaseFieldTypeBuilder[T]): F[JStringBuilder[JStringDefault[T]]]
    def stringType[T](bftb: JBaseFieldTypeBuilder[T]): F[JStringDefault[T]]

  object BaseFieldTypeBuilder:
    given [F[_]: Sync]: BaseFieldTypeBuilder[F] =
      new BaseFieldTypeBuilder[F]:
        def array[T](bftb: JBaseFieldTypeBuilder[T]): F[JArrayBuilder[JArrayDefault[T]]] =
          Sync[F].delay(bftb.array())
        def booleanBuilder[T](bftb: JBaseFieldTypeBuilder[T]): F[JBooleanBuilder[JBooleanDefault[T]]] =
          Sync[F].delay(bftb.booleanBuilder())
        def booleanType[T](bftb: JBaseFieldTypeBuilder[T]): F[JBooleanDefault[T]] =
          Sync[F].delay(bftb.booleanType())
        def bytesBuilder[T](bftb: JBaseFieldTypeBuilder[T]): F[JBytesBuilder[JBytesDefault[T]]] =
          Sync[F].delay(bftb.bytesBuilder())
        def bytesType[T](bftb: JBaseFieldTypeBuilder[T]): F[JBytesDefault[T]] =
          Sync[F].delay(bftb.bytesType())
        def doubleBuilder[T](bftb: JBaseFieldTypeBuilder[T]): F[JDoubleBuilder[JDoubleDefault[T]]] =
          Sync[F].delay(bftb.doubleBuilder())
        def doubleType[T](bftb: JBaseFieldTypeBuilder[T]): F[JDoubleDefault[T]] =
          Sync[F].delay(bftb.doubleType())
        def enumeration[T](bftb: JBaseFieldTypeBuilder[T])(name: String): F[JEnumBuilder[JEnumDefault[T]]] =
          Sync[F].delay(bftb.enumeration(name))
        def fixed[T](bftb: JBaseFieldTypeBuilder[T])(name: String): F[JFixedBuilder[JFixedDefault[T]]] =
          Sync[F].delay(bftb.fixed(name))
        def floatBuilder[T](bftb: JBaseFieldTypeBuilder[T]): F[JFloatBuilder[JFloatDefault[T]]] =
          Sync[F].delay(bftb.floatBuilder())
        def floatType[T](bftb: JBaseFieldTypeBuilder[T]): F[JFloatDefault[T]] =
          Sync[F].delay(bftb.floatType())
        def intBuilder[T](bftb: JBaseFieldTypeBuilder[T]): F[JIntBuilder[JIntDefault[T]]] =
          Sync[F].delay(bftb.intBuilder())
        def intType[T](bftb: JBaseFieldTypeBuilder[T]): F[JIntDefault[T]] =
          Sync[F].delay(bftb.intType())
        def longBuilder[T](bftb: JBaseFieldTypeBuilder[T]): F[JLongBuilder[JLongDefault[T]]] =
          Sync[F].delay(bftb.longBuilder())
        def longType[T](bftb: JBaseFieldTypeBuilder[T]): F[JLongDefault[T]] =
          Sync[F].delay(bftb.longType())
        def map[T](bftb: JBaseFieldTypeBuilder[T]): F[JMapBuilder[JMapDefault[T]]] =
          Sync[F].delay(bftb.map())
        def nullBuilder[T](bftb: JBaseFieldTypeBuilder[T]): F[JNullBuilder[JNullDefault[T]]] =
          Sync[F].delay(bftb.nullBuilder())
        def nullType[T](bftb: JBaseFieldTypeBuilder[T]): F[JNullDefault[T]] =
          Sync[F].delay(bftb.nullType())
        def record[T](bftb: JBaseFieldTypeBuilder[T])(name: String): F[JRecordBuilder[JRecordDefault[T]]] =
          Sync[F].delay(bftb.record(name))
        def stringBuilder[T](bftb: JBaseFieldTypeBuilder[T]): F[JStringBuilder[JStringDefault[T]]] =
          Sync[F].delay(bftb.stringBuilder())
        def stringType[T](bftb: JBaseFieldTypeBuilder[T]): F[JStringDefault[T]] =
          Sync[F].delay(bftb.stringType())

  trait BaseTypeBuilder[F[_]]:
    def array[T](btb: JBaseTypeBuilder[T]): F[JArrayBuilder[T]]
    def booleanBuilder[T](btb: JBaseTypeBuilder[T]): F[JBooleanBuilder[T]]
    def booleanType[T](btb: JBaseTypeBuilder[T]): F[T]
    def bytesBuilder[T](btb: JBaseTypeBuilder[T]): F[JBytesBuilder[T]]
    def bytesType[T](btb: JBaseTypeBuilder[T]): F[T]
    def doubleBuilder[T](btb: JBaseTypeBuilder[T]): F[JDoubleBuilder[T]]
    def doubleType[T](btb: JBaseTypeBuilder[T]): F[T]
    def enumeration[T](btb: JBaseTypeBuilder[T])(name: String): F[JEnumBuilder[T]]
    def fixed[T](btb: JBaseTypeBuilder[T])(name: String): F[JFixedBuilder[T]]
    def floatBuilder[T](btb: JBaseTypeBuilder[T]): F[JFloatBuilder[T]]
    def floatType[T](btb: JBaseTypeBuilder[T]): F[T]
    def intBuilder[T](btb: JBaseTypeBuilder[T]): F[JIntBuilder[T]]
    def intType[T](btb: JBaseTypeBuilder[T]): F[T]
    def longBuilder[T](btb: JBaseTypeBuilder[T]): F[JLongBuilder[T]]
    def longType[T](btb: JBaseTypeBuilder[T]): F[T]
    def map[T](btb: JBaseTypeBuilder[T]): F[JMapBuilder[T]]
    def nullBuilder[T](btb: JBaseTypeBuilder[T]): F[JNullBuilder[T]]
    def nullType[T](btb: JBaseTypeBuilder[T]): F[T]
    def record[T](btb: JBaseTypeBuilder[T])(name: String): F[JRecordBuilder[T]]
    def stringBuilder[T](btb: JBaseTypeBuilder[T]): F[JStringBuilder[T]]
    def stringType[T](btb: JBaseTypeBuilder[T]): F[T]
    def `type`[T](btb: JBaseTypeBuilder[T])(schema: Schema): F[T]
    def `type`[T](btb: JBaseTypeBuilder[T])(name: String): F[T]
    def `type`[T](btb: JBaseTypeBuilder[T])(name: String, namespace: String): F[T]

  object BaseTypeBuilder:
    given [F[_]: Sync]: BaseTypeBuilder[F] =
      new BaseTypeBuilder[F]:
        def array[T](btb: JBaseTypeBuilder[T]): F[JArrayBuilder[T]] =
          Sync[F].delay(btb.array())
        def booleanBuilder[T](btb: JBaseTypeBuilder[T]): F[JBooleanBuilder[T]] =
          Sync[F].delay(btb.booleanBuilder())
        def booleanType[T](btb: JBaseTypeBuilder[T]): F[T] =
          Sync[F].delay(btb.booleanType())
        def bytesBuilder[T](btb: JBaseTypeBuilder[T]): F[JBytesBuilder[T]] =
          Sync[F].delay(btb.bytesBuilder())
        def bytesType[T](btb: JBaseTypeBuilder[T]): F[T] =
          Sync[F].delay(btb.bytesType())
        def doubleBuilder[T](btb: JBaseTypeBuilder[T]): F[JDoubleBuilder[T]] =
          Sync[F].delay(btb.doubleBuilder())
        def doubleType[T](btb: JBaseTypeBuilder[T]): F[T] =
          Sync[F].delay(btb.doubleType())
        def enumeration[T](btb: JBaseTypeBuilder[T])(name: String): F[JEnumBuilder[T]] =
          Sync[F].delay(btb.enumeration(name))
        def fixed[T](btb: JBaseTypeBuilder[T])(name: String): F[JFixedBuilder[T]] =
          Sync[F].delay(btb.fixed(name))
        def floatBuilder[T](btb: JBaseTypeBuilder[T]): F[JFloatBuilder[T]] =
          Sync[F].delay(btb.floatBuilder())
        def floatType[T](btb: JBaseTypeBuilder[T]): F[T] =
          Sync[F].delay(btb.floatType())
        def intBuilder[T](btb: JBaseTypeBuilder[T]): F[JIntBuilder[T]] =
          Sync[F].delay(btb.intBuilder())
        def intType[T](btb: JBaseTypeBuilder[T]): F[T] =
          Sync[F].delay(btb.intType())
        def longBuilder[T](btb: JBaseTypeBuilder[T]): F[JLongBuilder[T]] =
          Sync[F].delay(btb.longBuilder())
        def longType[T](btb: JBaseTypeBuilder[T]): F[T] =
          Sync[F].delay(btb.longType())
        def map[T](btb: JBaseTypeBuilder[T]): F[JMapBuilder[T]] =
          Sync[F].delay(btb.map())
        def nullBuilder[T](btb: JBaseTypeBuilder[T]): F[JNullBuilder[T]] =
          Sync[F].delay(btb.nullBuilder())
        def nullType[T](btb: JBaseTypeBuilder[T]): F[T] =
          Sync[F].delay(btb.nullType())
        def record[T](btb: JBaseTypeBuilder[T])(name: String): F[JRecordBuilder[T]] =
          Sync[F].delay(btb.record(name))
        def stringBuilder[T](btb: JBaseTypeBuilder[T]): F[JStringBuilder[T]] =
          Sync[F].delay(btb.stringBuilder())
        def stringType[T](btb: JBaseTypeBuilder[T]): F[T] =
          Sync[F].delay(btb.stringType())
        def `type`[T](btb: JBaseTypeBuilder[T])(schema: Schema): F[T] =
          Sync[F].delay(btb.`type`(schema))
        def `type`[T](btb: JBaseTypeBuilder[T])(name: String): F[T] =
          Sync[F].delay(btb.`type`(name))
        def `type`[T](btb: JBaseTypeBuilder[T])(name: String, namespace: String): F[T] =
          Sync[F].delay(btb.`type`(name, namespace))

  trait BooleanBuilder[F[_]]:
    def endBoolean[T](bb: JBooleanBuilder[T]): F[T]    
  object BooleanBuilder:
    given [F[_]: Sync]: BooleanBuilder[F] =
      new BooleanBuilder[F]:
        def endBoolean[T](bb: JBooleanBuilder[T]): F[T] =
          Sync[F].delay(bb.endBoolean())

  trait BooleanDefault[F[_]]:
    def booleanDefault[T](bd: JBooleanDefault[T])(defaultVal: Boolean): F[JFieldAssembler[T]]
  object BooleanDefault:
    given [F[_]: Sync]: BooleanDefault[F] =
      new BooleanDefault[F]:
        def booleanDefault[T](bd: JBooleanDefault[T])(defaultVal: Boolean): F[JFieldAssembler[T]] =
          Sync[F].delay(bd.booleanDefault(defaultVal))

  trait BytesBuilder[F[_]]:
    def endBytes[T](bb: JBytesBuilder[T]): F[T]    
  object BytesBuilder:
    given [F[_]: Sync]: BytesBuilder[F] =
      new BytesBuilder[F]:
        def endBytes[T](bb: JBytesBuilder[T]): F[T] =
          Sync[F].delay(bb.endBytes())

  trait BytesDefault[F[_]]:
    def bytesDefault[T](bd: JBytesDefault[T])(defaultVal: Array[Byte]): F[JFieldAssembler[T]]
    def bytesDefault[T](bd: JBytesDefault[T])(defaultVal: ByteBuffer): F[JFieldAssembler[T]]
    def bytesDefault[T](bd: JBytesDefault[T])(defaultVal: String): F[JFieldAssembler[T]]
  object BytesDefault:
    given [F[_]: Sync]: BytesDefault[F] =
      new BytesDefault[F]:
        def bytesDefault[T](bd: JBytesDefault[T])(defaultVal: Array[Byte]): F[JFieldAssembler[T]] =
          Sync[F].delay(bd.bytesDefault(defaultVal))
        def bytesDefault[T](bd: JBytesDefault[T])(defaultVal: ByteBuffer): F[JFieldAssembler[T]] =
          Sync[F].delay(bd.bytesDefault(defaultVal))
        def bytesDefault[T](bd: JBytesDefault[T])(defaultVal: String): F[JFieldAssembler[T]] =
          Sync[F].delay(bd.bytesDefault(defaultVal))

  trait DoubleBuilder[F[_]]:
    def endDouble[T](bb: JDoubleBuilder[T]): F[T]    
  object DoubleBuilder:
    given [F[_]: Sync]: DoubleBuilder[F] =
      new DoubleBuilder[F]:
        def endDouble[T](bb: JDoubleBuilder[T]): F[T] =
          Sync[F].delay(bb.endDouble())

  trait DoubleDefault[F[_]]:
    def doubleDefault[T](bd: JDoubleDefault[T])(defaultVal: Double): F[JFieldAssembler[T]]
  object DoubleDefault:
    given [F[_]: Sync]: DoubleDefault[F] =
      new DoubleDefault[F]:
        def doubleDefault[T](bd: JDoubleDefault[T])(defaultVal: Double): F[JFieldAssembler[T]] =
          Sync[F].delay(bd.doubleDefault(defaultVal))

  trait EnumBuilder[F[_]]:
    def symbols[T](eb: JEnumBuilder[T])(symbols: String*): F[T]    
  object EnumBuilder:
    given [F[_]: Sync](using NSB: NamespacedBuilder[F]): EnumBuilder[F] =
      new EnumBuilder[F]:
        def symbols[T](eb: JEnumBuilder[T])(symbols: String*): F[T] =
          Sync[F].delay(eb.symbols(symbols*))

  trait EnumDefault[F[_]]:
    def enumDefault[T](ed: JEnumDefault[T])(defaultVal: String): F[JFieldAssembler[T]]
  object EnumDefault:
    given [F[_]: Sync]: EnumDefault[F] =
      new EnumDefault[F]:
        def enumDefault[T](ed: JEnumDefault[T])(defaultVal: String): F[JFieldAssembler[T]] =
          Sync[F].delay(ed.enumDefault(defaultVal))

  trait FieldAssembler[F[_]]:
    def endRecord[T](fa: JFieldAssembler[T]): F[T]
    def name[T](fa: JFieldAssembler[T])(fieldName: String): F[JFieldBuilder[T]]
  object FieldAssembler:
    given [F[_]: Sync]: FieldAssembler[F] =
      new FieldAssembler[F]:
        def endRecord[T](fa: JFieldAssembler[T]): F[T] =
          Sync[F].delay(fa.endRecord())
        def name[T](fa: JFieldAssembler[T])(fieldName: String): F[JFieldBuilder[T]] =
          Sync[F].delay(fa.name(fieldName))

  trait FieldBuilder[F[_]]:
    def orderAscending[T](fb: JFieldBuilder[T]): F[JFieldBuilder[T]]    
    def orderDescending[T](fb: JFieldBuilder[T]): F[JFieldBuilder[T]]    
    def orderIgnore[T](fb: JFieldBuilder[T]): F[JFieldBuilder[T]]    
    def `type`[T](fb: JFieldBuilder[T]): F[JFieldTypeBuilder[T]]
    def `type`[T](fb: JFieldBuilder[T])(schema: Schema): F[JGenericDefault[T]]
    def `type`[T](fb: JFieldBuilder[T])(name: String): F[JGenericDefault[T]]
    def `type`[T](fb: JFieldBuilder[T])(name: String, namespace: String): F[JGenericDefault[T]]
     
  object FieldBuilder:
    given [F[_]: Sync]: FieldBuilder[F] =
      new FieldBuilder[F]:
        def orderAscending[T](fb: JFieldBuilder[T]): F[JFieldBuilder[T]] =
          Sync[F].delay(fb.orderAscending())
        def orderDescending[T](fb: JFieldBuilder[T]): F[JFieldBuilder[T]] =
          Sync[F].delay(fb.orderDescending())
        def orderIgnore[T](fb: JFieldBuilder[T]): F[JFieldBuilder[T]] =
          Sync[F].delay(fb.orderIgnore())
        def `type`[T](fb: JFieldBuilder[T]): F[JFieldTypeBuilder[T]] =
          Sync[F].delay(fb.`type`())
        def `type`[T](fb: JFieldBuilder[T])(schema: Schema): F[JGenericDefault[T]] =
          Sync[F].delay(fb.`type`(schema))
        def `type`[T](fb: JFieldBuilder[T])(name: String): F[JGenericDefault[T]] =
          Sync[F].delay(fb.`type`(name))
        def `type`[T](fb: JFieldBuilder[T])(name: String, namespace: String): F[JGenericDefault[T]] =
          Sync[F].delay(fb.`type`(name, namespace))

  trait FieldDefault[F[_]]:
    def noDefault[T, U <: JFieldDefault[T, U]](fd: JFieldDefault[T, U]): F[JFieldAssembler[T]]
  object FieldDefault:
    given [F[_]: Sync]: FieldDefault[F] =
      new FieldDefault[F]:
        def noDefault[T, U <: JFieldDefault[T, U]](fd: JFieldDefault[T, U]): F[JFieldAssembler[T]] =
          Sync[F].delay(fd.noDefault())

  trait FieldTypeBuilder[F[_]]:
    def array[T](ftb: JFieldTypeBuilder[T]): F[JArrayBuilder[JArrayDefault[T]]]
    def booleanBuilder[T](ftb: JFieldTypeBuilder[T]): F[JBooleanBuilder[JBooleanDefault[T]]]
    def booleanType[T](ftb: JFieldTypeBuilder[T]): F[JBooleanDefault[T]]
    def bytesBuilder[T](ftb: JFieldTypeBuilder[T]): F[JBytesBuilder[JBytesDefault[T]]]
    def bytesType[T](ftb: JFieldTypeBuilder[T]): F[JBytesDefault[T]]
    def doubleBuilder[T](ftb: JFieldTypeBuilder[T]): F[JDoubleBuilder[JDoubleDefault[T]]]
    def doubleType[T](ftb: JFieldTypeBuilder[T]): F[JDoubleDefault[T]]
    def enumeration[T](ftb: JFieldTypeBuilder[T])(name: String): F[JEnumBuilder[JEnumDefault[T]]]
    def fixed[T](ftb: JFieldTypeBuilder[T])(name: String): F[JFixedBuilder[JFixedDefault[T]]]
    def floatBuilder[T](ftb: JFieldTypeBuilder[T]): F[JFloatBuilder[JFloatDefault[T]]]
    def floatType[T](ftb: JFieldTypeBuilder[T]): F[JFloatDefault[T]]
    def intBuilder[T](ftb: JFieldTypeBuilder[T]): F[JIntBuilder[JIntDefault[T]]]
    def intType[T](ftb: JFieldTypeBuilder[T]): F[JIntDefault[T]]
    def longBuilder[T](ftb: JFieldTypeBuilder[T]): F[JLongBuilder[JLongDefault[T]]]
    def longType[T](ftb: JFieldTypeBuilder[T]): F[JLongDefault[T]]
    def map[T](ftb: JFieldTypeBuilder[T]): F[JMapBuilder[JMapDefault[T]]]
    def nullBuilder[T](ftb: JFieldTypeBuilder[T]): F[JNullBuilder[JNullDefault[T]]]
    def nullType[T](ftb: JFieldTypeBuilder[T]): F[JNullDefault[T]]
    def record[T](ftb: JFieldTypeBuilder[T])(name: String): F[JRecordBuilder[JRecordDefault[T]]]
    def stringBuilder[T](ftb: JFieldTypeBuilder[T]): F[JStringBuilder[JStringDefault[T]]]
    def stringType[T](ftb: JFieldTypeBuilder[T]): F[JStringDefault[T]]
    def unionOf[T](ftb: JFieldTypeBuilder[T]): F[JUnionFieldTypeBuilder[T]]
  object FieldTypeBuilder:
    given [F[_]: Sync]: FieldTypeBuilder[F] =
      new FieldTypeBuilder[F]:
        def unionOf[T](ftb: JFieldTypeBuilder[T]): F[JUnionFieldTypeBuilder[T]] =
          Sync[F].delay(ftb.unionOf())
        def array[T](ftb: JFieldTypeBuilder[T]): F[JArrayBuilder[JArrayDefault[T]]] =
          Sync[F].delay(ftb.array())
        def booleanBuilder[T](ftb: JFieldTypeBuilder[T]): F[JBooleanBuilder[JBooleanDefault[T]]] =
          Sync[F].delay(ftb.booleanBuilder())
        def booleanType[T](ftb: JFieldTypeBuilder[T]): F[JBooleanDefault[T]] =
          Sync[F].delay(ftb.booleanType())
        def bytesBuilder[T](ftb: JFieldTypeBuilder[T]): F[JBytesBuilder[JBytesDefault[T]]] =
          Sync[F].delay(ftb.bytesBuilder())
        def bytesType[T](ftb: JFieldTypeBuilder[T]): F[JBytesDefault[T]] =
          Sync[F].delay(ftb.bytesType())
        def doubleBuilder[T](ftb: JFieldTypeBuilder[T]): F[JDoubleBuilder[JDoubleDefault[T]]] =
          Sync[F].delay(ftb.doubleBuilder())
        def doubleType[T](ftb: JFieldTypeBuilder[T]): F[JDoubleDefault[T]] =
          Sync[F].delay(ftb.doubleType())
        def enumeration[T](ftb: JFieldTypeBuilder[T])(name: String): F[JEnumBuilder[JEnumDefault[T]]] =
          Sync[F].delay(ftb.enumeration(name))
        def fixed[T](ftb: JFieldTypeBuilder[T])(name: String): F[JFixedBuilder[JFixedDefault[T]]] =
          Sync[F].delay(ftb.fixed(name))
        def floatBuilder[T](ftb: JFieldTypeBuilder[T]): F[JFloatBuilder[JFloatDefault[T]]] =
          Sync[F].delay(ftb.floatBuilder())
        def floatType[T](ftb: JFieldTypeBuilder[T]): F[JFloatDefault[T]] =
          Sync[F].delay(ftb.floatType())
        def intBuilder[T](ftb: JFieldTypeBuilder[T]): F[JIntBuilder[JIntDefault[T]]] =
          Sync[F].delay(ftb.intBuilder())
        def intType[T](ftb: JFieldTypeBuilder[T]): F[JIntDefault[T]] =
          Sync[F].delay(ftb.intType())
        def longBuilder[T](ftb: JFieldTypeBuilder[T]): F[JLongBuilder[JLongDefault[T]]] =
          Sync[F].delay(ftb.longBuilder())
        def longType[T](ftb: JFieldTypeBuilder[T]): F[JLongDefault[T]] =
          Sync[F].delay(ftb.longType())
        def map[T](ftb: JFieldTypeBuilder[T]): F[JMapBuilder[JMapDefault[T]]] =
          Sync[F].delay(ftb.map())
        def nullBuilder[T](ftb: JFieldTypeBuilder[T]): F[JNullBuilder[JNullDefault[T]]] =
          Sync[F].delay(ftb.nullBuilder())
        def nullType[T](ftb: JFieldTypeBuilder[T]): F[JNullDefault[T]] =
          Sync[F].delay(ftb.nullType())
        def record[T](ftb: JFieldTypeBuilder[T])(name: String): F[JRecordBuilder[JRecordDefault[T]]] =
          Sync[F].delay(ftb.record(name))
        def stringBuilder[T](ftb: JFieldTypeBuilder[T]): F[JStringBuilder[JStringDefault[T]]] =
          Sync[F].delay(ftb.stringBuilder())
        def stringType[T](ftb: JFieldTypeBuilder[T]): F[JStringDefault[T]] =
          Sync[F].delay(ftb.stringType())

  trait FixedBuilder[F[_]]:
    def size[T](fb: JFixedBuilder[T])(size: Int): F[T]
  object FixedBuilder:
    given [F[_]: Sync](using NSB: NamespacedBuilder[F]): FixedBuilder[F] =
      new FixedBuilder[F]:
        def size[T](fb: JFixedBuilder[T])(size: Int): F[T] =
          Sync[F].delay(fb.size(size))

  trait FixedDefault[F[_]]:
    def fixedDefault[T](gd: JFixedDefault[T])(defaultVal: Array[Byte]): F[JFieldAssembler[T]]
    def fixedDefault[T](gd: JFixedDefault[T])(defaultVal: ByteBuffer): F[JFieldAssembler[T]]
    def fixedDefault[T](gd: JFixedDefault[T])(defaultVal: String): F[JFieldAssembler[T]]
  object FixedDefault:
    given [F[_]: Sync]: FixedDefault[F] =
      new FixedDefault[F]:
        def fixedDefault[T](gd: JFixedDefault[T])(defaultVal: Array[Byte]): F[JFieldAssembler[T]] =
          Sync[F].delay(gd.fixedDefault(defaultVal))
        def fixedDefault[T](gd: JFixedDefault[T])(defaultVal: ByteBuffer): F[JFieldAssembler[T]] =
          Sync[F].delay(gd.fixedDefault(defaultVal))
        def fixedDefault[T](gd: JFixedDefault[T])(defaultVal: String): F[JFieldAssembler[T]] =
          Sync[F].delay(gd.fixedDefault(defaultVal))

  trait GenericDefault[F[_]]:
    def noDefault[T](gd: JGenericDefault[T]): F[JFieldAssembler[T]]
    def withDefault[T](gd: JGenericDefault[T])(defaultVal: Any): F[JFieldAssembler[T]]
  object GenericDefault:
    given [F[_]: Sync]: GenericDefault[F] =
      new GenericDefault[F]:
        def noDefault[T](gd: JGenericDefault[T]): F[JFieldAssembler[T]] =
          Sync[F].delay(gd.noDefault())
        def withDefault[T](gd: JGenericDefault[T])(defaultVal: Any): F[JFieldAssembler[T]] =
          Sync[F].delay(gd.withDefault(defaultVal))

  trait IntBuilder[F[_]]:
    def endInt[T](ib: JIntBuilder[T]): F[T]    
  object IntBuilder:
    given [F[_]: Sync]: IntBuilder[F] =
      new IntBuilder[F]:
        def endInt[T](ib: JIntBuilder[T]): F[T] =
          Sync[F].delay(ib.endInt())

  trait IntDefault[F[_]]:
    def intDefault[T](id: JIntDefault[T])(defaultVal: Int): F[JFieldAssembler[T]]
  object IntDefault:
    given [F[_]: Sync]: IntDefault[F] =
      new IntDefault[F]:
        def intDefault[T](id: JIntDefault[T])(defaultVal: Int): F[JFieldAssembler[T]] =
          Sync[F].delay(id.intDefault(defaultVal))

  trait LongBuilder[F[_]]:
    def endLong[T](lb: JLongBuilder[T]): F[T]    
  object LongBuilder:
    given [F[_]: Sync]: LongBuilder[F] =
      new LongBuilder[F]:
        def endLong[T](lb: JLongBuilder[T]): F[T] =
          Sync[F].delay(lb.endLong())

  trait LongDefault[F[_]]:
    def longDefault[T](ld: JLongDefault[T])(defaultVal: Long): F[JFieldAssembler[T]]
  object LongDefault:
    given [F[_]: Sync]: LongDefault[F] =
      new LongDefault[F]:
        def longDefault[T](ld: JLongDefault[T])(defaultVal: Long): F[JFieldAssembler[T]] =
          Sync[F].delay(ld.longDefault(defaultVal))

  trait MapBuilder[F[_]]:
    def values[T](mb: JMapBuilder[T]): F[JTypeBuilder[T]]
    def values[T](mb: JMapBuilder[T])(valueSchema: Schema): F[T]
  object MapBuilder:
    given [F[_]: Sync]: MapBuilder[F] =
      new MapBuilder[F]:
        def values[T](mb: JMapBuilder[T]): F[JTypeBuilder[T]] =
          Sync[F].delay(mb.values())
        def values[T](mb: JMapBuilder[T])(valueSchema: Schema): F[T] =
          Sync[F].delay(mb.values(valueSchema))

  trait MapDefault[F[_]]:
    def mapDefault[T, V](md: JMapDefault[T])(defaultVal: Map[String, V]): F[JFieldAssembler[T]]
  object MapDefault:
    given [F[_]: Sync]: MapDefault[F] =
      new MapDefault[F]:
        def mapDefault[T, V](md: JMapDefault[T])(defaultVal: Map[String, V]): F[JFieldAssembler[T]] =
          Sync[F].delay(md.mapDefault(defaultVal.asJava))

  trait NamedBuilder[F[_]]:
    def aliases[T, U <: JNamedBuilder[U]](nb: U)(aliases: String*): F[U]
    def doc[T, U <: JNamedBuilder[U]](nb: U)(doc: String): F[U]
  object NamedBuilder:
    given [F[_]: Sync]: NamedBuilder[F] =
      new NamedBuilder[F]:
        def aliases[T, U <: JNamedBuilder[U]](nb: U)(aliases: String*): F[U] =
          Sync[F].delay(nb.aliases(aliases*))
        def doc[T, U <: JNamedBuilder[U]](nb: U)(doc: String): F[U] =
          Sync[F].delay(nb.doc(doc))


  trait NamespacedBuilder[F[_]]:
    def namespace[T, U <: JNamespacedBuilder[T, U]](nb: JNamespacedBuilder[T, U])(namespace: String): F[U]
  object NamespacedBuilder:
    given [F[_]: Sync]: NamespacedBuilder[F] =
      new NamespacedBuilder[F]:
        def namespace[T, U <: JNamespacedBuilder[T, U]](nb: JNamespacedBuilder[T, U])(namespace: String): F[U] =
          Sync[F].delay(nb.namespace(namespace))

  trait NullBuilder[F[_]]:
    def endNull[T](nb: JNullBuilder[T]): F[T]    
  object NullBuilder:
    given [F[_]: Sync]: NullBuilder[F] =
      new NullBuilder[F]:
        def endNull[T](nb: JNullBuilder[T]): F[T] =
          Sync[F].delay(nb.endNull())

  trait NullDefault[F[_]]:
    def nullDefault[T](nd: JNullDefault[T]): F[JFieldAssembler[T]]
  object NullDefault:
    given [F[_]: Sync]: NullDefault[F] =
      new NullDefault[F]:
        def nullDefault[T](nd: JNullDefault[T]): F[JFieldAssembler[T]] =
          Sync[F].delay(nd.nullDefault())

  trait PropBuilder[F[_]]:
    def prop[U <: JPropBuilder[U]](pb: U)(name: String, `val`: String): F[U]    
  object PropBuilder:
    given [F[_]: Sync]: PropBuilder[F] =
      new PropBuilder[F]:
        def prop[U <: JPropBuilder[U]](pb: U)(name: String, `val`: String): F[U] =
          Sync[F].delay(pb.prop(name, `val`))

  trait RecordBuilder[F[_]]:
    def fields[T](rb: JRecordBuilder[T]): F[JFieldAssembler[T]]
  object RecordBuilder:
    given [F[_]: Sync](using NSB: NamespacedBuilder[F]): RecordBuilder[F] =
      new RecordBuilder[F]:
        def fields[T](rb: JRecordBuilder[T]): F[JFieldAssembler[T]] =
          Sync[F].delay(rb.fields())

  trait RecordDefault[F[_]]:
    def recordDefault[T](rd: JRecordDefault[T])(defaultValue: GenericRecord): F[JFieldAssembler[T]]
  object RecordDefault:
    given [F[_]: Sync]: RecordDefault[F] =
      new RecordDefault[F]:
        def recordDefault[T](rd: JRecordDefault[T])(defaultValue: GenericRecord): F[JFieldAssembler[T]] =
          Sync[F].delay(rd.recordDefault(defaultValue))

  trait StringBuilder[F[_]]:
    def endString[T](sb: JStringBuilder[T]): F[T]    
  object StringBuilder:
    given [F[_]: Sync]: StringBuilder[F] =
      new StringBuilder[F]:
        def endString[T](sb: JStringBuilder[T]): F[T] =
          Sync[F].delay(sb.endString())

  trait StringDefault[F[_]]:
    def stringDefault[T](sd: JStringDefault[T])(defaultVal: String): F[JFieldAssembler[T]]
  object StringDefault:
    given [F[_]: Sync]: StringDefault[F] =
      new StringDefault[F]:
        def stringDefault[T](sd: JStringDefault[T])(defaultVal: String): F[JFieldAssembler[T]] =
          Sync[F].delay(sd.stringDefault(defaultVal))
          
  trait TypeBuilder[F[_]]:
    def array[T](tb: JTypeBuilder[T]): F[JArrayBuilder[T]]
    def booleanBuilder[T](tb: JTypeBuilder[T]): F[JBooleanBuilder[T]]
    def booleanType[T](tb: JTypeBuilder[T]): F[T]
    def bytesBuilder[T](tb: JTypeBuilder[T]): F[JBytesBuilder[T]]
    def bytesType[T](tb: JTypeBuilder[T]): F[T]
    def doubleBuilder[T](tb: JTypeBuilder[T]): F[JDoubleBuilder[T]]
    def doubleType[T](tb: JTypeBuilder[T]): F[T]
    def enumeration[T](tb: JTypeBuilder[T])(name: String): F[JEnumBuilder[T]]
    def fixed[T](tb: JTypeBuilder[T])(name: String): F[JFixedBuilder[T]]
    def floatBuilder[T](tb: JTypeBuilder[T]): F[JFloatBuilder[T]]
    def floatType[T](tb: JTypeBuilder[T]): F[T]
    def intBuilder[T](tb: JTypeBuilder[T]): F[JIntBuilder[T]]
    def intType[T](tb: JTypeBuilder[T]): F[T]
    def longBuilder[T](tb: JTypeBuilder[T]): F[JLongBuilder[T]]
    def longType[T](tb: JTypeBuilder[T]): F[T]
    def map[T](tb: JTypeBuilder[T]): F[JMapBuilder[T]]
    def nullBuilder[T](tb: JTypeBuilder[T]): F[JNullBuilder[T]]
    def nullType[T](tb: JTypeBuilder[T]): F[T]
    def record[T](tb: JTypeBuilder[T])(name: String): F[JRecordBuilder[T]]
    def stringBuilder[T](tb: JTypeBuilder[T]): F[JStringBuilder[T]]
    def stringType[T](tb: JTypeBuilder[T]): F[T]
    def `type`[T](tb: JTypeBuilder[T])(schema: Schema): F[T]
    def `type`[T](tb: JTypeBuilder[T])(name: String): F[T]
    def `type`[T](tb: JTypeBuilder[T])(name: String, namespace: String): F[T]
    def unionOf[T](tb: JTypeBuilder[T]): F[JBaseTypeBuilder[JUnionAccumulator[T]]]    
  object TypeBuilder:
    given [F[_]: Sync]: TypeBuilder[F] =
      new TypeBuilder[F]:
        def array[T](tb: JTypeBuilder[T]): F[JArrayBuilder[T]] =
          Sync[F].delay(tb.array())
        def booleanBuilder[T](tb: JTypeBuilder[T]): F[JBooleanBuilder[T]] =
          Sync[F].delay(tb.booleanBuilder())
        def booleanType[T](tb: JTypeBuilder[T]): F[T] =
          Sync[F].delay(tb.booleanType())
        def bytesBuilder[T](tb: JTypeBuilder[T]): F[JBytesBuilder[T]] =
          Sync[F].delay(tb.bytesBuilder())
        def bytesType[T](tb: JTypeBuilder[T]): F[T] =
          Sync[F].delay(tb.bytesType())
        def doubleBuilder[T](tb: JTypeBuilder[T]): F[JDoubleBuilder[T]] =
          Sync[F].delay(tb.doubleBuilder())
        def doubleType[T](tb: JTypeBuilder[T]): F[T] =
          Sync[F].delay(tb.doubleType())
        def enumeration[T](tb: JTypeBuilder[T])(name: String): F[JEnumBuilder[T]] =
          Sync[F].delay(tb.enumeration(name))
        def fixed[T](tb: JTypeBuilder[T])(name: String): F[JFixedBuilder[T]] =
          Sync[F].delay(tb.fixed(name))
        def floatBuilder[T](tb: JTypeBuilder[T]): F[JFloatBuilder[T]] =
          Sync[F].delay(tb.floatBuilder())
        def floatType[T](tb: JTypeBuilder[T]): F[T] =
          Sync[F].delay(tb.floatType())
        def intBuilder[T](tb: JTypeBuilder[T]): F[JIntBuilder[T]] =
          Sync[F].delay(tb.intBuilder())
        def intType[T](tb: JTypeBuilder[T]): F[T] =
          Sync[F].delay(tb.intType())
        def longBuilder[T](tb: JTypeBuilder[T]): F[JLongBuilder[T]] =
          Sync[F].delay(tb.longBuilder())
        def longType[T](tb: JTypeBuilder[T]): F[T] =
          Sync[F].delay(tb.longType())
        def map[T](tb: JTypeBuilder[T]): F[JMapBuilder[T]] =
          Sync[F].delay(tb.map())
        def nullBuilder[T](tb: JTypeBuilder[T]): F[JNullBuilder[T]] =
          Sync[F].delay(tb.nullBuilder())
        def nullType[T](tb: JTypeBuilder[T]): F[T] =
          Sync[F].delay(tb.nullType())
        def record[T](tb: JTypeBuilder[T])(name: String): F[JRecordBuilder[T]] =
          Sync[F].delay(tb.record(name))
        def stringBuilder[T](tb: JTypeBuilder[T]): F[JStringBuilder[T]] =
          Sync[F].delay(tb.stringBuilder())
        def stringType[T](tb: JTypeBuilder[T]): F[T] =
          Sync[F].delay(tb.stringType())
        def `type`[T](tb: JTypeBuilder[T])(schema: Schema): F[T] =
          Sync[F].delay(tb.`type`(schema))
        def `type`[T](tb: JTypeBuilder[T])(name: String): F[T] =
          Sync[F].delay(tb.`type`(name))
        def `type`[T](tb: JTypeBuilder[T])(name: String, namespace: String): F[T] =
          Sync[F].delay(tb.`type`(name, namespace))
        def unionOf[T](tb: JTypeBuilder[T]): F[JBaseTypeBuilder[JUnionAccumulator[T]]] =
          Sync[F].delay(tb.unionOf())

  trait UnionAccumulator[F[_]]:
    def and[T](ua: JUnionAccumulator[T]): F[JBaseTypeBuilder[JUnionAccumulator[T]]]
    def endUnion[T](ua: JUnionAccumulator[T]): F[T]    
  object UnionAccumulator:
    given [F[_]: Sync]: UnionAccumulator[F] =
      new UnionAccumulator[F]:
        def and[T](ua: JUnionAccumulator[T]): F[JBaseTypeBuilder[JUnionAccumulator[T]]] =
          Sync[F].delay(ua.and())
        def endUnion[T](ua: JUnionAccumulator[T]): F[T] =
          Sync[F].delay(ua.endUnion())

  trait UnionFieldTypeBuilder[F[_]]:
    def array[T](uftb: JUnionFieldTypeBuilder[T]): F[JArrayBuilder[JUnionAccumulator[JArrayDefault[T]]]]
    def booleanBuilder[T](uftb: JUnionFieldTypeBuilder[T]): F[JBooleanBuilder[JUnionAccumulator[JBooleanDefault[T]]]]
    def booleanType[T](uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JBooleanDefault[T]]]
    def bytesBuilder[T](uftb: JUnionFieldTypeBuilder[T]): F[JBytesBuilder[JUnionAccumulator[JBytesDefault[T]]]]
    def bytesType[T](uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JBytesDefault[T]]]
    def doubleBuilder[T](uftb: JUnionFieldTypeBuilder[T]): F[JDoubleBuilder[JUnionAccumulator[JDoubleDefault[T]]]]
    def doubleType[T](uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JDoubleDefault[T]]]
    def enumeration[T](uftb: JUnionFieldTypeBuilder[T])(name: String): F[JEnumBuilder[JUnionAccumulator[JEnumDefault[T]]]]
    def fixed[T](uftb: JUnionFieldTypeBuilder[T])(name: String): F[JFixedBuilder[JUnionAccumulator[JFixedDefault[T]]]]
    def floatBuilder[T](uftb: JUnionFieldTypeBuilder[T]): F[JFloatBuilder[JUnionAccumulator[JFloatDefault[T]]]]
    def floatType[T](uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JFloatDefault[T]]]
    def intBuilder[T](uftb: JUnionFieldTypeBuilder[T]): F[JIntBuilder[JUnionAccumulator[JIntDefault[T]]]]
    def intType[T](uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JIntDefault[T]]]
    def longBuilder[T](uftb: JUnionFieldTypeBuilder[T]): F[JLongBuilder[JUnionAccumulator[JLongDefault[T]]]]
    def longType[T](uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JLongDefault[T]]]
    def map[T](uftb: JUnionFieldTypeBuilder[T]): F[JMapBuilder[JUnionAccumulator[JMapDefault[T]]]]
    def nullBuilder[T](uftb: JUnionFieldTypeBuilder[T]): F[JNullBuilder[JUnionAccumulator[JNullDefault[T]]]]
    def nullType[T](uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JNullDefault[T]]]
    def record[T](uftb: JUnionFieldTypeBuilder[T])(name: String): F[JRecordBuilder[JUnionAccumulator[JRecordDefault[T]]]]
    def stringBuilder[T](uftb: JUnionFieldTypeBuilder[T]): F[JStringBuilder[JUnionAccumulator[JStringDefault[T]]]]
    def stringType[T](uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JStringDefault[T]]]

  object UnionFieldTypeBuilder:
    given [F[_]: Sync]: UnionFieldTypeBuilder[F] =
      new UnionFieldTypeBuilder[F]:
        def array[T](uftb: JUnionFieldTypeBuilder[T]): F[JArrayBuilder[JUnionAccumulator[JArrayDefault[T]]]] =
          Sync[F].delay(uftb.array())
        def booleanBuilder[T](uftb: JUnionFieldTypeBuilder[T]): F[JBooleanBuilder[JUnionAccumulator[JBooleanDefault[T]]]] =
          Sync[F].delay(uftb.booleanBuilder())
        def booleanType[T](uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JBooleanDefault[T]]] =
          Sync[F].delay(uftb.booleanType())
        def bytesBuilder[T](uftb: JUnionFieldTypeBuilder[T]): F[JBytesBuilder[JUnionAccumulator[JBytesDefault[T]]]] =
          Sync[F].delay(uftb.bytesBuilder())
        def bytesType[T](uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JBytesDefault[T]]] =
          Sync[F].delay(uftb.bytesType())
        def doubleBuilder[T](uftb: JUnionFieldTypeBuilder[T]): F[JDoubleBuilder[JUnionAccumulator[JDoubleDefault[T]]]] =
          Sync[F].delay(uftb.doubleBuilder())
        def doubleType[T](uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JDoubleDefault[T]]] =
          Sync[F].delay(uftb.doubleType())
        def enumeration[T](uftb: JUnionFieldTypeBuilder[T])(name: String): F[JEnumBuilder[JUnionAccumulator[JEnumDefault[T]]]] =
          Sync[F].delay(uftb.enumeration(name))
        def fixed[T](uftb: JUnionFieldTypeBuilder[T])(name: String): F[JFixedBuilder[JUnionAccumulator[JFixedDefault[T]]]] =
          Sync[F].delay(uftb.fixed(name))
        def floatBuilder[T](uftb: JUnionFieldTypeBuilder[T]): F[JFloatBuilder[JUnionAccumulator[JFloatDefault[T]]]] =
          Sync[F].delay(uftb.floatBuilder())
        def floatType[T](uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JFloatDefault[T]]] =
          Sync[F].delay(uftb.floatType())
        def intBuilder[T](uftb: JUnionFieldTypeBuilder[T]): F[JIntBuilder[JUnionAccumulator[JIntDefault[T]]]] =
          Sync[F].delay(uftb.intBuilder())
        def intType[T](uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JIntDefault[T]]] =
          Sync[F].delay(uftb.intType())
        def longBuilder[T](uftb: JUnionFieldTypeBuilder[T]): F[JLongBuilder[JUnionAccumulator[JLongDefault[T]]]] =
          Sync[F].delay(uftb.longBuilder())
        def longType[T](uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JLongDefault[T]]] =
          Sync[F].delay(uftb.longType())
        def map[T](uftb: JUnionFieldTypeBuilder[T]): F[JMapBuilder[JUnionAccumulator[JMapDefault[T]]]] =
          Sync[F].delay(uftb.map())
        def nullBuilder[T](uftb: JUnionFieldTypeBuilder[T]): F[JNullBuilder[JUnionAccumulator[JNullDefault[T]]]] =
          Sync[F].delay(uftb.nullBuilder())
        def nullType[T](uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JNullDefault[T]]] =
          Sync[F].delay(uftb.nullType())
        def record[T](uftb: JUnionFieldTypeBuilder[T])(name: String): F[JRecordBuilder[JUnionAccumulator[JRecordDefault[T]]]] =
          Sync[F].delay(uftb.record(name))
        def stringBuilder[T](uftb: JUnionFieldTypeBuilder[T]): F[JStringBuilder[JUnionAccumulator[JStringDefault[T]]]] =
          Sync[F].delay(uftb.stringBuilder())
        def stringType[T](uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JStringDefault[T]]] =
          Sync[F].delay(uftb.stringType())